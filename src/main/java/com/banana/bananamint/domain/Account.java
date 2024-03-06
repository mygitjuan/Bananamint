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
@Schema(name = "account", description = "Modelo cuentas")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    @Schema(name = "ID", example = "1", required = false)
    private Long id;

    @Size(min = 3, max = 20)
    @Schema(name = "type", example = "UML", required = true)
    private String type;

    @Column(name="opening_date")
    @DateTimeFormat
    @NotNull
    @Schema(name = "openingDate", example = "2024-01-31", required = true)
    LocalDate openingDate;

    private double balance;

    private double maxOverdraft;

    @Transient
    private Customer owner;

    private boolean active;

}
