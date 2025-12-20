package com.example.demo.service;

import com.example.demo.model.ClinicalAlertRecord;
import java.util.*;

public interface ClinicalAlertService {

    ClinicalAlertRecord resolveAlert(Long alertId);

    List<ClinicalAlertRecord> getAlertsByPatient(Long patientId);

    Optional<ClinicalAlertRecord> getAlertById(Long id);

    List<ClinicalAlertRecord> getAllAlerts();
}
