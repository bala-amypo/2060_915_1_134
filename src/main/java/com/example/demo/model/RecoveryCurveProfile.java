package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RecoveryCurveProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String surgeryType;
    private Integer expectedPainLevel;
    private Integer expectedMobilityLevel;

    public RecoveryCurveProfile() {}

    public Long getId() {
        return id;
    }

    public String getSurgeryType() {
        return surgeryType;
    }

    public Integer getExpectedPainLevel() {
        return expectedPainLevel;
    }

    public Integer getExpectedMobilityLevel() {
        return expectedMobilityLevel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSurgeryType(String surgeryType) {
        this.surgeryType = surgeryType;
    }

    public void setExpectedPainLevel(Integer expectedPainLevel) {
        this.expectedPainLevel = expectedPainLevel;
    }

    public void setExpectedMobilityLevel(Integer expectedMobilityLevel) {
        this.expectedMobilityLevel = expectedMobilityLevel;
    }
}
