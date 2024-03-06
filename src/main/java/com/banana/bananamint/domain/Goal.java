package com.banana.bananamint.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Schema(name = "goal", description = "Modelo objetivo")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    @Schema(name = "ID", example = "1", required = false)
    private Long id;

    @Size(min = 3, max = 20)
    @Schema(name = "name", example = "UML", required = true)
    private String name;

    @Size(min = 3, max = 20)
    @Schema(name = "description", example = "UML", required = true)
    private String description;

    @Column(name = "target_amount")
    @Schema(name = "targetAmount", example = "1", required = true)
    private double targetAmount;

    @Size(min = 3, max = 20)
    @Schema(name = "status", example = "UML", required = true)
    private String status;

    @Column(name = "target_date")
    @DateTimeFormat
    @NotNull
    @Schema(name = "targetDate", example = "2024-01-31", required = true)
    private LocalDate targetDate;


    //@Transient
    @JsonIgnore
    @Schema(name = "customer_id", example = "", required = false)
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer user;


}
