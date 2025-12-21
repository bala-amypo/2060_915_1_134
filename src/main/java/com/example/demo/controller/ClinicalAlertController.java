package com.example.demo.controller;

import com.example.demo.model.ClinicalAlertRecord;
import com.example.demo.service.ClinicalAlertService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class ClinicalAlertController {

    private final ClinicalAlertService service;

    public ClinicalAlertController(ClinicalAlertService service) {
        this.service = service;
    }

    @PutMapping("/{id}/resolve")
    public ClinicalAlertRecord resolve(@PathVariable Long id) {
        return service.resolveAlert(id);
    }

    @GetMapping("/{id}")
    public ClinicalAlertRecord getById(@PathVariable Long id) {
        return service.getAlertById(id)
                .orElseThrow(() -> new RuntimeException("Alert not found"));
    }

    @GetMapping("/patient/{patientId}")
    public List<ClinicalAlertRecord> getByPatient(@PathVariable Long patientId) {
        return service.getAlertsByPatient(patientId);
    }

    @GetMapping
    public List<ClinicalAlertRecord> getAll() {
        return service.getAllAlerts();
    }
}
