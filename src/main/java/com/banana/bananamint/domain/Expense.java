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
@Schema(name = "expense", description = "Modelo gasto")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    @Schema(name = "ID", example = "1", required = false)
    private Integer Id;

    //@Transient
    @ToString.Exclude
    @JsonIgnore
    @Schema(name = "customer_id", example = "", required = false)
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer user;

    @Schema(name = "amount", example = "0", required = true)
    private double amount;

    @Column(name = "due_date")
    @DateTimeFormat
    @NotNull
    @Schema(name = "dueDate", example = "2024-01-31", required = true)
    private LocalDate dueDate;

    //@Transient
    @ToString.Exclude
    @JsonIgnore
    @Schema(name = "account_id", example = "", required = false)
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account moneyFrom;

    @Size(min = 3, max = 20)
    @Schema(name = "status", example = "UML", required = true)
    private String status;

}
