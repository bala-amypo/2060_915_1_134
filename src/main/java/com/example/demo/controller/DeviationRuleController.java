package com.example.demo.controller;

import com.example.demo.model.DeviationRule;
import com.example.demo.service.DeviationRuleService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deviation-rules")
public class DeviationRuleController {

    private final DeviationRuleService service;

    public DeviationRuleController(DeviationRuleService service) {
        this.service = service;
    }

    @PostMapping
    public DeviationRule create(@RequestBody DeviationRule rule) {
        return service.createRule(rule);
    }

    @GetMapping("/{id}")
    public DeviationRule getById(@PathVariable Long id) {
        return service.getRuleById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
    }

    @GetMapping
    public List<DeviationRule> getAll() {
        return service.getAllRules();
    }
}
