package com.example.demo.repository;

import com.example.demo.model.RecoveryCurveProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecoveryCurveProfileRepository
        extends JpaRepository<RecoveryCurveProfile, Long> {

    Optional<RecoveryCurveProfile> findBySurgeryType(String surgeryType);
}
