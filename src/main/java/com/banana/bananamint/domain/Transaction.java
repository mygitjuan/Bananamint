package com.banana.bananamint.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "transaction", description = "Modelo movimientos o transacciones")
public class Transaction {

    @Schema(name = "ID", example = "1", required = false)
    private Integer id;

    private double amount;

    private String description;

    private String paymentType;

    private Category category;

    private Account account;

    private Customer user;

    private boolean isDeleted;

    private Long dateTime;

    private LocalDate createdAt;

    private LocalDate updatedAt;


}
