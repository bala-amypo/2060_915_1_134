package com.example.demo.service.impl;

import com.example.demo.model.ClinicalAlertRecord;
import com.example.demo.repository.ClinicalAlertRecordRepository;
import com.example.demo.service.ClinicalAlertService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicalAlertServiceImpl implements ClinicalAlertService {

    private final ClinicalAlertRecordRepository repo;

    public ClinicalAlertServiceImpl(ClinicalAlertRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public ClinicalAlertRecord resolveAlert(Long alertId) {
        ClinicalAlertRecord alert = repo.findById(alertId)
                .orElseThrow(() -> new RuntimeException("Alert not found"));
        alert.setResolved(true);
        return repo.save(alert);
    }

    @Override
    public Optional<ClinicalAlertRecord> getAlertById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<ClinicalAlertRecord> getAlertsByPatient(Long patientId) {
        return repo.findByPatientId(patientId);
    }

    @Override
    public List<ClinicalAlertRecord> getAllAlerts() {
        return repo.findAll();
    }
}
