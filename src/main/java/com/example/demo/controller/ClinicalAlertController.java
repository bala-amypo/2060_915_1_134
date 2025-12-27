package com.example.demo.controller;

import com.example.demo.model.ClinicalAlertRecord;
import com.example.demo.service.ClinicalAlertService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@Tag(name = "Clinical Alert", description = "Clinical alert management")
public class ClinicalAlertController {
    private final ClinicalAlertService clinicalAlertService;

    public ClinicalAlertController(ClinicalAlertService clinicalAlertService) {
        this.clinicalAlertService = clinicalAlertService;
    }

    @PostMapping
    public ResponseEntity<ClinicalAlertRecord> createAlert(@Valid @RequestBody ClinicalAlertRecord alert) {
        return ResponseEntity.ok(clinicalAlertService.createAlert(alert));
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<ClinicalAlertRecord> resolveAlert(@PathVariable Long id) {
        return ResponseEntity.ok(clinicalAlertService.resolveAlert(id));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<ClinicalAlertRecord>> getAlertsByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(clinicalAlertService.getAlertsByPatient(patientId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicalAlertRecord> getAlertById(@PathVariable Long id) {
        return clinicalAlertService.getAlertById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ClinicalAlertRecord>> getAllAlerts() {
        return ResponseEntity.ok(clinicalAlertService.getAllAlerts());
    }
}