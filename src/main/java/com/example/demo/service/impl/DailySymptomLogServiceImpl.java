package com.example.demo.controller;

import com.example.demo.model.DailySymptomLog;
import com.example.demo.service.DailySymptomLogService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/symptom-logs")
public class DailySymptomLogController {

    private final DailySymptomLogService logService;

    // Constructor injection
    public DailySymptomLogController(DailySymptomLogService logService) {
        this.logService = logService;
    }

    /**
     * Record daily symptom log
     */
    @PostMapping
    public DailySymptomLog recordLog(@RequestBody DailySymptomLog log) {
        return logService.recordSymptomLog(log);
    }

    /**
     * Get all logs for a patient
     */
    @GetMapping("/patient/{patientId}")
    public List<DailySymptomLog> getLogsByPatient(@PathVariable Long patientId) {
        return logService.getLogsByPatient(patientId);
    }

    /**
     * Update an existing symptom log
     */
    @PutMapping("/{logId}")
    public DailySymptomLog updateLog(
            @PathVariable Long logId,
            @RequestBody DailySymptomLog updatedLog) {
        return logService.updateSymptomLog(logId, updatedLog);
    }
}
