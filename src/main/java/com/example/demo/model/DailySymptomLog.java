package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DailySymptomLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;
    private LocalDate logDate;

    private Integer painLevel;
    private Integer mobilityLevel;
    private Integer fatigueLevel;

    public DailySymptomLog() {}

    public Long getId() {
        return id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public LocalDate getLogDate() {
        return logDate;
    }

    public Integer getPainLevel() {
        return painLevel;
    }

    public Integer getMobilityLevel() {
        return mobilityLevel;
    }

    public Integer getFatigueLevel() {
        return fatigueLevel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }

    public void setPainLevel(Integer painLevel) {
        this.painLevel = painLevel;
    }

    public void setMobilityLevel(Integer mobilityLevel) {
        this.mobilityLevel = mobilityLevel;
    }

    public void setFatigueLevel(Integer fatigueLevel) {
        this.fatigueLevel = fatigueLevel;
    }
}
