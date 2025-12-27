package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}