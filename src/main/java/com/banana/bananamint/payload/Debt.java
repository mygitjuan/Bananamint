package com.banana.bananamint.payload;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Schema(name = "debt", description = "Modelo deuda")
public class Debt {

    @Schema(name = "ID", example = "1", required = false)
    private Long accountId;

    private LocalDate initDate;
    private LocalDate finalDate;

    private double[] accumulatedDebt; // income - expense, if negative, in the date range, for every month. It is accumulative.

}
