package com.example.demo.repository;

import java.util.*;
import com.example.demo.model.*;

public interface ADeviationRuleRepository {
    Optional<DeviationRule> findById(Long id);
    Optional<DeviationRule> findByRuleCode(String code);
    List<DeviationRule> findByActiveTrue();
    DeviationRule save(DeviationRule d);

}
