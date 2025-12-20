package com.example.demo.repository;

import java.util.*;
import com.example.demo.model.*;

public interface DailySymptomLogRepository {
    Optional<DailySymptomLog> findByPatientIdAndLogDate(Long id, LocalDate d);
    Optional<DailySymptomLog> findById(Long id);
    List<DailySymptomLog> findByPatientId(Long id);
    DailySymptomLog save(DailySymptomLog d);

}
