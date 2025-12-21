package com.example.demo.controller;

import com.example.demo.model.DailySymptomLog;
import com.example.demo.service.DailySymptomLogService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/symptom-logs")
public class DailySymptomLogController {

    private final DailySymptomLogService service;

    public DailySymptomLogController(DailySymptomLogService service) {
        this.service = service;
    }

    @PostMapping
    public DailySymptomLog create(@RequestBody DailySymptomLog log) {
        return service.recordSymptomLog(log);
    }

    @GetMapping("/patient/{patientId}")
    public List<DailySymptomLog> getByPatient(@PathVariable Long patientId) {
        return service.getLogsByPatient(patientId);
    }

    @PutMapping("/{logId}")
    public DailySymptomLog update(@PathVariable Long logId,
                                  @RequestBody DailySymptomLog log) {
        return service.updateSymptomLog(logId, log);
    }
}
