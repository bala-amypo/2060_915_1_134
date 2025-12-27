package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.DailySymptomLogRepository;
import com.example.demo.repository.PatientProfileRepository;
import com.example.demo.service.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class DailySymptomLogServiceImpl implements DailySymptomLogService {
    
    private final DailySymptomLogRepository dailySymptomLogRepository;
    private final PatientProfileRepository patientProfileRepository;
    private final RecoveryCurveService recoveryCurveService;
    private final DeviationRuleService deviationRuleService;
    private final ClinicalAlertService clinicalAlertService;
    
    public DailySymptomLogServiceImpl(DailySymptomLogRepository dailySymptomLogRepository,
                                     PatientProfileRepository patientProfileRepository,
                                     RecoveryCurveService recoveryCurveService,
                                     DeviationRuleService deviationRuleService,
                                     ClinicalAlertService clinicalAlertService) {
        this.dailySymptomLogRepository = dailySymptomLogRepository;
        this.patientProfileRepository = patientProfileRepository;
        this.recoveryCurveService = recoveryCurveService;
        this.deviationRuleService = deviationRuleService;
        this.clinicalAlertService = clinicalAlertService;
    }
    
    @Override
    public DailySymptomLog recordSymptomLog(DailySymptomLog log) {
        // Validate patient exists
        PatientProfile patient = patientProfileRepository.findById(log.getPatientId())
            .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));
        
        // Validate date is not in future
        if (log.getLogDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Log date cannot be in future date");
        }
        
        // Check for duplicate log
        if (dailySymptomLogRepository.findByPatientIdAndLogDate(log.getPatientId(), log.getLogDate()).isPresent()) {
            throw new IllegalArgumentException("Duplicate log for patient on same date");
        }
        
        DailySymptomLog savedLog = dailySymptomLogRepository.save(log);
        
        // Check for deviations and create alerts
        checkForDeviations(savedLog, patient);
        
        return savedLog;
    }
    
    @Override
    public List<DailySymptomLog> getLogsByPatient(Long patientId) {
        // Validate patient exists
        patientProfileRepository.findById(patientId)
            .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));
        
        return dailySymptomLogRepository.findByPatientId(patientId);
    }
    
    @Override
    public Optional<DailySymptomLog> getLogById(Long id) {
        return dailySymptomLogRepository.findById(id);
    }
    
    @Override
    public DailySymptomLog updateSymptomLog(Long id, DailySymptomLog updated) {
        DailySymptomLog existing = dailySymptomLogRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Log not found"));
        
        // Validate patient exists
        PatientProfile patient = patientProfileRepository.findById(updated.getPatientId())
            .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));
        
        existing.setPainLevel(updated.getPainLevel());
        existing.setMobilityLevel(updated.getMobilityLevel());
        existing.setFatigueLevel(updated.getFatigueLevel());
        existing.setAdditionalNotes(updated.getAdditionalNotes());
        existing.setPatientId(updated.getPatientId());
        
        return dailySymptomLogRepository.save(existing);
    }
    
    private void checkForDeviations(DailySymptomLog log, PatientProfile patient) {
        // Calculate days since surgery
        long daysSinceSurgery = ChronoUnit.DAYS.between(patient.getCreatedAt().toLocalDate(), log.getLogDate());
        
        // Get recovery curve for this surgery type and day
        Optional<RecoveryCurveProfile> curveOpt = recoveryCurveService.getCurveByDayAndSurgery(
            patient.getSurgeryType(), (int) daysSinceSurgery);
        
        if (curveOpt.isPresent()) {
            RecoveryCurveProfile curve = curveOpt.get();
            List<DeviationRule> activeRules = deviationRuleService.getActiveRules();
            
            for (DeviationRule rule : activeRules) {
                if (rule.getSurgeryType().equals(patient.getSurgeryType())) {
                    checkRuleViolation(log, curve, rule);
                }
            }
        }
    }
    
    private void checkRuleViolation(DailySymptomLog log, RecoveryCurveProfile curve, DeviationRule rule) {
        int actualValue = 0;
        int expectedValue = 0;
        
        switch (rule.getParameter()) {
            case "PAIN":
                actualValue = log.getPainLevel();
                expectedValue = curve.getExpectedPainLevel();
                break;
            case "MOBILITY":
                actualValue = log.getMobilityLevel();
                expectedValue = curve.getExpectedMobilityLevel();
                break;
            case "FATIGUE":
                actualValue = log.getFatigueLevel();
                expectedValue = curve.getExpectedFatigueLevel();
                break;
        }
        
        if (Math.abs(actualValue - expectedValue) > rule.getThreshold()) {
            ClinicalAlertRecord alert = ClinicalAlertRecord.builder()
                .patientId(log.getPatientId())
                .logId(log.getId())
                .alertType(rule.getParameter() + "_DEVIATION")
                .severity(rule.getSeverity())
                .message(String.format("Patient %s level %d deviates from expected %d by more than threshold %d",
                    rule.getParameter().toLowerCase(), actualValue, expectedValue, rule.getThreshold()))
                .build();
            
            clinicalAlertService.createAlert(alert);
        }
    }
}