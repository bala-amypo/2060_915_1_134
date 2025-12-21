package com.example.demo.service;

import com.example.demo.model.DeviationRule;

import java.util.List;
import java.util.Optional;

public interface DeviationRuleService {

    DeviationRule createRule(DeviationRule rule);

    Optional<DeviationRule> getRuleById(Long id);

    List<DeviationRule> getAllRules();
}
