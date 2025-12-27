package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.DeviationRule;
import com.example.demo.repository.DeviationRuleRepository;

@Service
public class DeviationRuleService {

    private final DeviationRuleRepository repository;

    public DeviationRuleService(DeviationRuleRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public DeviationRule createRule(DeviationRule rule) {
        return repository.save(rule);
    }

    // GET BY ID
    public DeviationRule getRuleById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "DeviationRule not found with id " + id));
    }

    // GET ALL
    public List<DeviationRule> getAllRules() {
        return repository.findAll();
    }

    // DELETE
    public void deleteRule(Long id) {
        repository.deleteById(id);
    }
}
