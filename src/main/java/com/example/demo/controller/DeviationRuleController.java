package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.DeviationRule;
import com.example.demo.service.DeviationRuleService;

@RestController
@RequestMapping("/deviation-rules")
public class DeviationRuleController {

    private final DeviationRuleService service;

    public DeviationRuleController(DeviationRuleService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public DeviationRule createRule(@RequestBody DeviationRule rule) {
        return service.createRule(rule);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public DeviationRule getRuleById(@PathVariable Long id) {
        return service.getRuleById(id);
    }

    // GET ALL
    @GetMapping
    public List<DeviationRule> getAllRules() {
        return service.getAllRules();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteRule(@PathVariable Long id) {
        service.deleteRule(id);
        return "DeviationRule deleted successfully";
    }
}
