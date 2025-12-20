package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;

import java.time.temporal.ChronoUnit;
import java.util.*;

public class DailySymptomLogServiceImpl implements DailySymptomLogService {

    private final DailySymptomLogRepository logRepo;
    private final PatientProfileRepository patientRepo;
    private final RecoveryCurveService curveService;
    private final DeviationRuleService ruleService;
    private final ClinicalAlertService alertService;

    public DailySymptomLogServiceImpl(
            DailySymptomLogRepository l,
            PatientProfileRepository p,
            RecoveryCurveService c,
            DeviationRuleService r,
            ClinicalAlertService a) {

        this.logRepo = l;
        this.patientRepo = p;
        this.curveService = c;
        this.ruleService = r;
        this.alertService = a;
    }

    public DailySymptomLog recordSymptomLog(DailySymptomLog log) {

        PatientProfile patient = patientRepo.findById(log.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient"));

        logRepo.findByPatientIdAndLogDate(log.getPatientId(), log.getLogDate())
                .ifPresent(l -> { throw new IllegalArgumentException("Duplicate"); });

        return logRepo.save(log);
    }

    public List<DailySymptomLog> getLogsByPatient(Long id) {
        patientRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient"));
        return logRepo.findByPatientId(id);
    }

    public DailySymptomLog updateSymptomLog(Long id, DailySymptomLog updated) {
        DailySymptomLog existing = logRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log"));

        patientRepo.findById(updated.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient"));

        existing.setPainLevel(updated.getPainLevel());
        existing.setMobilityLevel(updated.getMobilityLevel());
        existing.setFatigueLevel(updated.getFatigueLevel());

        return logRepo.save(existing);
    }
}
