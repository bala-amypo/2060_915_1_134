package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ClinicalAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;
    private String alertMessage;
    private boolean resolved = false;

    public ClinicalAlertRecord() {}

    public Long getId() {
        return id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }
}
