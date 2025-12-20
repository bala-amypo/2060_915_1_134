package com.example.demo.repository;

import com.example.demo.model.DailySymptomLog;

import java.time.LocalDate;   // ✅ REQUIRED IMPORT
import java.util.List;
import java.util.Optional;

public interface DailySymptomLogRepository {

    Optional<DailySymptomLog> findByPatientIdAndLogDate(Long patientId, LocalDate logDate);

    Optional<DailySymptomLog> findById(Long id);

    List<DailySymptomLog> findByPatientId(Long patientId);

    DailySymptomLog save(DailySymptomLog log);
}
