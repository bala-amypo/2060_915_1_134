package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "deviation_rules")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviationRule {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String ruleCode;
    
    @NotBlank
    private String surgeryType;
    
    @NotBlank
    private String parameter;
    
    @NotNull
    @Positive
    private Integer threshold;
    
    @NotBlank
    private String severity;
    
    @Builder.Default
    private Boolean active = true;
    
    public DeviationRule(String surgeryType, String parameter, Integer threshold, String severity) {
        this.surgeryType = surgeryType;
        this.parameter = parameter;
        this.threshold = threshold;
        this.severity = severity;
        this.active = true;
    }
}