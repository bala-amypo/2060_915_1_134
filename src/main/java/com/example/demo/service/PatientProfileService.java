package com.example.demo.service;

import com.example.demo.model.PatientProfile;

import java.util.List;
import java.util.Optional;

public interface PatientProfileService {

    PatientProfile createPatient(PatientProfile profile);

    Optional<PatientProfile> getPatientById(Long id);

    List<PatientProfile> getAllPatients();

    PatientProfile deactivatePatient(Long id);
}
