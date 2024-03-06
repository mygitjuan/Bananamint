package com.banana.bananamint.domain;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Schema(name = "goal", description = "Modelo objetivo")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    @Schema(name = "ID", example = "1", required = false)
    private Long id;

    private String name;

    private String description;

    private double targetAmount;

    private String status;

    private LocalDate targetDate;

    @Transient
    private Customer user;


}
