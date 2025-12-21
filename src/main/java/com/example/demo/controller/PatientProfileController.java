package com.example.demo.controller;

import com.example.demo.model.PatientProfile;
import com.example.demo.service.PatientProfileService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientProfileController {

    private final PatientProfileService service;

    public PatientProfileController(PatientProfileService service) {
        this.service = service;
    }

    @PostMapping
    public PatientProfile create(@RequestBody PatientProfile profile) {
        return service.createPatient(profile);
    }

    @GetMapping("/{id}")
    public PatientProfile getById(@PathVariable Long id) {
        return service.getPatientById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    @GetMapping
    public List<PatientProfile> getAll() {
        return service.getAllPatients();
    }

    @PutMapping("/{id}/deactivate")
    public PatientProfile deactivate(@PathVariable Long id) {
        return service.deactivatePatient(id);
    }
}
