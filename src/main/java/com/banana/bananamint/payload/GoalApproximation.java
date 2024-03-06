package com.banana.bananamint.payload;


import com.banana.bananamint.domain.Goal;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "goalaproximation", description = "Modelo objetivo financiero")
public class GoalApproximation {


    @Schema(name = "ID", example = "1", required = false)
    private Goal goal;

    private double targetAmountDifference;

    private int tendency; // 1, 0, -1, depending on targetAmountDifference (positive, near zero, negative)

    private LocalDate estimatedReachingTargetDate;

}
