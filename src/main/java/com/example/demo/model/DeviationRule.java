package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DeviationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String metric;
    private Integer threshold;

    public DeviationRule() {}

    public Long getId() {
        return id;
    }

    public String getMetric() {
        return metric;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }
}
