package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "patient_profiles")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientProfile {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Column(unique = true)
    private String patientId;
    
    @NotBlank
    private String fullName;
    
    @NotNull
    @Positive
    private Integer age;
    
    @Email
    @NotBlank
    @Column(unique = true)
    private String email;
    
    @NotBlank
    private String surgeryType;
    
    @Builder.Default
    private Boolean active = true;
    
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    public PatientProfile(String patientId, String fullName, Integer age, String email, String surgeryType) {
        this.patientId = patientId;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.surgeryType = surgeryType;
        this.active = true;
    }
}