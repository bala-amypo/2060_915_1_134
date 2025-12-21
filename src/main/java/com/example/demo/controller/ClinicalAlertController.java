package com.example.demo.controller;

import com.example.demo.model.ClinicalAlertRecord;
import com.example.demo.service.ClinicalAlertService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class ClinicalAlertController {

    private final ClinicalAlertService alertService;

    // Constructor injection
    public ClinicalAlertController(ClinicalAlertService alertService) {
        this.alertService = alertService;
    }

    /**
     * Resolve an alert
     */
    @PutMapping("/{alertId}/resolve")
    public ClinicalAlertRecord resolveAlert(@PathVariable Long alertId) {
        return alertService.resolveAlert(alertId);
    }

    /**
     * Get alerts by patient ID
     */
    @GetMapping("/patient/{patientId}")
    public List<ClinicalAlertRecord> getAlertsByPatient(@PathVariable Long patientId) {
        return alertService.getAlertsByPatient(patientId);
    }

    /**
     * Get alert by alert ID
     */
    @GetMapping("/{alertId}")
    public ClinicalAlertRecord getAlertById(@PathVariable Long alertId) {
        return alertService.getAlertById(alertId)
                .orElseThrow(() -> new RuntimeException("Alert not found"));
    }

    /**
     * Get all alerts
     */
    @GetMapping
    public List<ClinicalAlertRecord> getAllAlerts() {
        return alertService.getAllAlerts();
    }
}
