package com.example.demo.controller;

import com.example.demo.model.DeviationRule;
import com.example.demo.service.DeviationRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deviation-rules")
@Tag(name = "Deviation Rule", description = "Deviation rule management")
public class DeviationRuleController {
    private final DeviationRuleService deviationRuleService;

    public DeviationRuleController(DeviationRuleService deviationRuleService) {
        this.deviationRuleService = deviationRuleService;
    }

    @PostMapping
    public ResponseEntity<DeviationRule> createRule(@Valid @RequestBody DeviationRule rule) {
        return ResponseEntity.ok(deviationRuleService.createRule(rule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeviationRule> updateRule(@PathVariable Long id, @Valid @RequestBody DeviationRule rule) {
        return ResponseEntity.ok(deviationRuleService.updateRule(id, rule));
    }

    @GetMapping("/active")
    public ResponseEntity<List<DeviationRule>> getActiveRules() {
        return ResponseEntity.ok(deviationRuleService.getActiveRules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviationRule> getRuleById(@PathVariable Long id) {
        return deviationRuleService.getActiveRules().stream()
                .filter(rule -> rule.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<DeviationRule>> getAllRules() {
        return ResponseEntity.ok(deviationRuleService.getActiveRules());
    }
}