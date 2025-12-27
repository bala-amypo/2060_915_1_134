package com.example.demo.service;

import java.util.List;
import com.example.demo.model.DeviationRule;

public interface DeviationRuleService {
    DeviationRule getRuleByCode(String code);
    List<DeviationRule> getActiveRules();
}
