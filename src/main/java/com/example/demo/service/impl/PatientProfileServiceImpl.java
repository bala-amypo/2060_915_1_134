package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.PatientProfile;
import com.example.demo.repository.PatientProfileRepository;
import com.example.demo.service.PatientProfileService;

import java.util.*;

public class PatientProfileServiceImpl implements PatientProfileService {

    private final PatientProfileRepository repo;

    public PatientProfileServiceImpl(PatientProfileRepository r) {
        this.repo = r;
    }

    public PatientProfile createPatient(PatientProfile p) {
        return repo.save(p);
    }

    public PatientProfile getPatientById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient"));
    }

    public PatientProfile updatePatientStatus(Long id, boolean active) {
        PatientProfile p = getPatientById(id);
        p.setActive(active);
        return repo.save(p);
    }

    public Optional<PatientProfile> findByPatientId(String pid) {
        return repo.findByPatientId(pid);
    }

    public List<PatientProfile> getAllPatients() {
        return repo.findAll();
    }
}
