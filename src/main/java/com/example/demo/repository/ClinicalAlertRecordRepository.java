package com.example.demo.repository;

import java.util.*;
import com.example.demo.model.*;

public interface ClinicalAlertRecordRepository {
    Optional<ClinicalAlertRecord> findById(Long id);
    List<ClinicalAlertRecord> findByPatientId(Long id);
    List<ClinicalAlertRecord> findAll();
    ClinicalAlertRecord save(ClinicalAlertRecord c);

}
