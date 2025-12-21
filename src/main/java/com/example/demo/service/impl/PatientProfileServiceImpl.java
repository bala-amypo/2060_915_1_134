package com.example.demo.service.impl;

import com.example.demo.model.PatientProfile;
import com.example.demo.repository.PatientProfileRepository;
import com.example.demo.service.PatientProfileService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientProfileServiceImpl implements PatientProfileService {

    private final PatientProfileRepository repo;

    public PatientProfileServiceImpl(PatientProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public PatientProfile createPatient(PatientProfile profile) {
        return repo.save(profile);
    }

    @Override
    public Optional<PatientProfile> getPatientById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<PatientProfile> getAllPatients() {
        return repo.findAll();
    }

    @Override
    public PatientProfile deactivatePatient(Long id) {
        PatientProfile p = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        p.setActive(false);
        return repo.save(p);
    }
}
