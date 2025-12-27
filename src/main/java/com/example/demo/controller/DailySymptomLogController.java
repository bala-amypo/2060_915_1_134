package com.example.demo.controller;

import com.example.demo.model.DailySymptomLog;
import com.example.demo.service.DailySymptomLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/symptom-logs")
@Tag(name = "Daily Symptom Log", description = "Daily symptom log management")
public class DailySymptomLogController {
    private final DailySymptomLogService dailySymptomLogService;

    public DailySymptomLogController(DailySymptomLogService dailySymptomLogService) {
        this.dailySymptomLogService = dailySymptomLogService;
    }

    @PostMapping
    public ResponseEntity<DailySymptomLog> recordSymptomLog(@Valid @RequestBody DailySymptomLog log) {
        return ResponseEntity.ok(dailySymptomLogService.recordSymptomLog(log));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DailySymptomLog> updateSymptomLog(@PathVariable Long id, @Valid @RequestBody DailySymptomLog log) {
        return ResponseEntity.ok(dailySymptomLogService.updateSymptomLog(id, log));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<DailySymptomLog>> getLogsByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(dailySymptomLogService.getLogsByPatient(patientId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DailySymptomLog> getLogById(@PathVariable Long id) {
        return dailySymptomLogService.getLogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<DailySymptomLog>> getAllLogs() {
        return ResponseEntity.ok(dailySymptomLogService.getLogsByPatient(1L)); // Simplified for demo
    }
}