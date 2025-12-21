package com.example.demo.service.impl;

import com.example.demo.model.DailySymptomLog;
import com.example.demo.repository.DailySymptomLogRepository;
import com.example.demo.service.DailySymptomLogService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailySymptomLogServiceImpl implements DailySymptomLogService {

    private final DailySymptomLogRepository repo;

    public DailySymptomLogServiceImpl(DailySymptomLogRepository repo) {
        this.repo = repo;
    }

    @Override
    public DailySymptomLog recordSymptomLog(DailySymptomLog log) {
        return repo.save(log);
    }

    @Override
    public List<DailySymptomLog> getLogsByPatient(Long patientId) {
        return repo.findByPatientId(patientId);
    }

    @Override
    public DailySymptomLog updateSymptomLog(Long logId, DailySymptomLog log) {
        DailySymptomLog existing = repo.findById(logId)
                .orElseThrow(() -> new RuntimeException("Log not found"));

        existing.setPainLevel(log.getPainLevel());
        existing.setMobilityLevel(log.getMobilityLevel());
        existing.setFatigueLevel(log.getFatigueLevel());

        return repo.save(existing);
    }
}
