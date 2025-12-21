package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class PatientProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;
    private Integer age;
    private String surgeryType;

    private boolean active = true;

    public PatientProfile() {}

    public Long getId() {
        return id;
    }

    public String getPatientName() {
        return patientName;
    }

    public Integer getAge() {
        return age;
    }

    public String getSurgeryType() {
        return surgeryType;
    }

    public boolean isActive() {
        return active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSurgeryType(String surgeryType) {
        this.surgeryType = surgeryType;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
