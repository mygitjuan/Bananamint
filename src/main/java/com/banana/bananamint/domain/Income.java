package com.banana.bananamint.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Schema(name = "income", description = "Modelo ingreso")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    @Schema(name = "ID", example = "1", required = false)
    private Integer Id;

    @Transient
    private Customer user;

    @Schema(name = "amount", example = "1", required = true)
    private double amount;

    @Column(name = "enter_date")
    @DateTimeFormat
    @NotNull
    @Schema(name = "enterDate", example = "2024-01-31", required = true)
    private LocalDate enterDate;

    @Transient
    private Account moneyTo;

    @Size(min=3, max = 20)
    @Schema(name = "status", example = "UML", required = true)
    private String status;
}
