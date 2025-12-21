package com.example.demo.controller;

import com.example.demo.model.RecoveryCurveProfile;
import com.example.demo.service.RecoveryCurveService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recovery-curves")
public class RecoveryCurveController {

    private final RecoveryCurveService service;

    public RecoveryCurveController(RecoveryCurveService service) {
        this.service = service;
    }

    @PostMapping
    public RecoveryCurveProfile create(@RequestBody RecoveryCurveProfile profile) {
        return service.createCurve(profile);
    }

    @GetMapping("/{surgeryType}")
    public RecoveryCurveProfile getByType(@PathVariable String surgeryType) {
        return service.getCurveBySurgeryType(surgeryType)
                .orElseThrow(() -> new RuntimeException("Curve not found"));
    }
}
