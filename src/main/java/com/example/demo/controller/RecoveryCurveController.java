package com.example.demo.controller;

import com.example.demo.model.RecoveryCurveProfile;
import com.example.demo.service.RecoveryCurveService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recovery-curves")
@Tag(name = "Recovery Curve", description = "Recovery curve management")
public class RecoveryCurveController {
    private final RecoveryCurveService recoveryCurveService;

    public RecoveryCurveController(RecoveryCurveService recoveryCurveService) {
        this.recoveryCurveService = recoveryCurveService;
    }

    @PostMapping
    public ResponseEntity<RecoveryCurveProfile> createCurveEntry(@Valid @RequestBody RecoveryCurveProfile entry) {
        return ResponseEntity.ok(recoveryCurveService.createCurveEntry(entry));
    }

    @GetMapping("/surgery/{surgeryType}")
    public ResponseEntity<List<RecoveryCurveProfile>> getCurveForSurgery(@PathVariable String surgeryType) {
        return ResponseEntity.ok(recoveryCurveService.getCurveForSurgery(surgeryType));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecoveryCurveProfile> getCurveById(@PathVariable Long id) {
        return recoveryCurveService.getAllCurves().stream()
                .filter(curve -> curve.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<RecoveryCurveProfile>> getAllCurves() {
        return ResponseEntity.ok(recoveryCurveService.getAllCurves());
    }
}