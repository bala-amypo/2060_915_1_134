package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "deviation_rule")
public class DeviationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private String description;
    private Double threshold;

    public DeviationRule() {
    }

    public DeviationRule(Long id, String ruleName, String description, Double threshold) {
        this.id = id;
        this.ruleName = ruleName;
        this.description = description;
        this.threshold = threshold;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getThreshold() {
        return threshold;
    }

    public void setThreshold(Double threshold) {
        this.threshold = threshold;
    }
}
