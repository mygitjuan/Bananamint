package com.banana.bananamint.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Schema(name = "budget", description = "Modelo presupuesto")
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    @Schema(name = "ID", example = "1", required = false)
    private Long id;

    @Transient
    private Category category;

    @Schema(name = "orden", example = "1.0", required = true)
    private double amount;

    @Transient
    private Customer user;

    @Schema(name = "selected", example = "1", required = true)
    private Long selected;

    @Schema(name = "balance", example = "1", required = true)
    private Long balance;

}
