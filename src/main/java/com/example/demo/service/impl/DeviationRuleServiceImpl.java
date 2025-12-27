package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.example.demo.repository.DeviationRuleRepository;
import com.example.demo.model.DeviationRule;
import com.example.demo.service.DeviationRuleService;

@Service
@RequiredArgsConstructor
public class DeviationRuleServiceImpl implements DeviationRuleService {

    private final DeviationRuleRepository repository;

    @Override
    public DeviationRule getRuleByCode(String code) {
        return repository.findByRuleCode(code).orElse(null);
    }

    @Override
    public List<DeviationRule> getActiveRules() {
        return repository.findByActiveTrue();
    }
}
