package com.example.demo.controller;

import com.example.demo.model.DailySymptomLog;
import com.example.demo.service.DailySymptomLogService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Record symptom log")
    public ResponseEntity<DailySymptomLog> recordSymptomLog(@Valid @RequestBody DailySymptomLog log) {
        return ResponseEntity.ok(dailySymptomLogService.recordSymptomLog(log));
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update symptom log")
    public ResponseEntity<DailySymptomLog> updateSymptomLog(@PathVariable Long id, @Valid @RequestBody DailySymptomLog log) {
        return ResponseEntity.ok(dailySymptomLogService.updateSymptomLog(id, log));
    }
    
    @GetMapping("/patient/{patientId}")
    @Operation(summary = "Get logs by patient")
    public ResponseEntity<List<DailySymptomLog>> getLogsByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(dailySymptomLogService.getLogsByPatient(patientId));
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get log by ID")
    public ResponseEntity<DailySymptomLog> getLogById(@PathVariable Long id) {
        return dailySymptomLogService.getLogById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping
    @Operation(summary = "List all logs")
    public ResponseEntity<List<DailySymptomLog>> getAllLogs() {
        return ResponseEntity.ok(dailySymptomLogService.getLogsByPatient(1L)); // Simplified for demo
    }
}