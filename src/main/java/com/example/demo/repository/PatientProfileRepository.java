package com.example.demo.repository;

import java.util.*;
import com.example.demo.model.*;

public interface PatientProfileRepository {
    Optional<PatientProfile> findById(Long id);
    Optional<PatientProfile> findByPatientId(String pid);
    List<PatientProfile> findAll();
    PatientProfile save(PatientProfile p);
}
