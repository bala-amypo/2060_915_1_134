package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RecoveryCurveProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String surgeryType;
    private Integer dayNumber;
    private Integer expectedPainLevel;
    private Integer expectedMobilityLevel;
    private Integer expectedFatigueLevel;

    public RecoveryCurveProfile() {}

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSurgeryType() { return surgeryType; }
    public void setSurgeryType(String surgeryType) { this.surgeryType = surgeryType; }

    public Integer getDayNumber() { return dayNumber; }
    public void setDayNumber(Integer dayNumber) { this.dayNumber = dayNumber; }

    public Integer getExpectedPainLevel() { return expectedPainLevel; }
    public void setExpectedPainLevel(Integer expectedPainLevel) { this.expectedPainLevel = expectedPainLevel; }

    public Integer getExpectedMobilityLevel() { return expectedMobilityLevel; }
    public void setExpectedMobilityLevel(Integer expectedMobilityLevel) { this.expectedMobilityLevel = expectedMobilityLevel; }

    public Integer getExpectedFatigueLevel() { return expectedFatigueLevel; }
    public void setExpectedFatigueLevel(Integer expectedFatigueLevel) { this.expectedFatigueLevel = expectedFatigueLevel; }
}
