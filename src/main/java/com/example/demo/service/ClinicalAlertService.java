package com.example.demo.service;

import com.example.demo.model.ClinicalAlertRecord;

import java.util.List;
import java.util.Optional;

public interface ClinicalAlertService {

    ClinicalAlertRecord resolveAlert(Long alertId);

    Optional<ClinicalAlertRecord> getAlertById(Long id);

    List<ClinicalAlertRecord> getAlertsByPatient(Long patientId);

    List<ClinicalAlertRecord> getAllAlerts();
}
