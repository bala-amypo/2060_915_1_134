package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.DeviationRule;

public interface DeviationRuleRepository
        extends JpaRepository<DeviationRule, Long> {

    Optional<DeviationRule> findByRuleCode(String ruleCode);
    List<DeviationRule> findByActiveTrue();
}
