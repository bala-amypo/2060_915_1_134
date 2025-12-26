package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PatientProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientId;
    private String fullName;
    private String email;
    private String surgeryType;

    private Boolean active = true;
    private LocalDateTime createdAt;

    // --------------------
    // Constructor
    // --------------------
    public PatientProfile() {
    }

    // --------------------
    // Getters and Setters
    // --------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurgeryType() {
        return surgeryType;
    }

    public void setSurgeryType(String surgeryType) {
        this.surgeryType = surgeryType;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // --------------------
    // Manual Builder (NO Lombok)
    // --------------------
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final PatientProfile p = new PatientProfile();

        public Builder id(Long id) {
            p.setId(id);
            return this;
        }

        public Builder patientId(String patientId) {
            p.setPatientId(patientId);
            return this;
        }

        public Builder fullName(String fullName) {
            p.setFullName(fullName);
            return this;
        }

        public Builder email(String email) {
            p.setEmail(email);
            return this;
        }

        public Builder surgeryType(String surgeryType) {
            p.setSurgeryType(surgeryType);
            return this;
        }

        public Builder active(Boolean active) {
            p.setActive(active);
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            p.setCreatedAt(createdAt);
            return this;
        }

        public PatientProfile build() {
            return p;
        }
    }
}
