package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.PatientProfile;

public interface PatientProfileRepository
        extends JpaRepository<PatientProfile, Long> {

    Optional<PatientProfile> findByPatientId(String patientId);
}
