package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "daily_symptom_logs", uniqueConstraints = @UniqueConstraint(columnNames = {"patient_id", "log_date"}))
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailySymptomLog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(name = "patient_id")
    private Long patientId;
    
    @NotNull
    @PastOrPresent
    @Column(name = "log_date")
    private LocalDate logDate;
    
    @NotNull
    @Min(0)
    @Max(10)
    private Integer painLevel;
    
    @NotNull
    @Min(0)
    @Max(10)
    private Integer mobilityLevel;
    
    @NotNull
    @Min(0)
    @Max(10)
    private Integer fatigueLevel;
    
    @Lob
    @Size(max = 2000)
    private String additionalNotes;
    
    @CreationTimestamp
    private LocalDateTime submittedAt;
    
    public DailySymptomLog(Long patientId, LocalDate logDate, Integer painLevel, Integer mobilityLevel, Integer fatigueLevel) {
        this.patientId = patientId;
        this.logDate = logDate;
        this.painLevel = painLevel;
        this.mobilityLevel = mobilityLevel;
        this.fatigueLevel = fatigueLevel;
    }
}