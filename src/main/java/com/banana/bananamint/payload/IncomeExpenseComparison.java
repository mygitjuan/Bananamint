package com.banana.bananamint.payload;


import com.banana.bananamint.domain.Expense;
import com.banana.bananamint.domain.Income;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "netting", description = "Modelo balance")
public class IncomeExpenseComparison {

    private Income income;
    private Expense expense;

    private int perspective; // 1, 0, -1, depending on income - expense (positive, near zero, negative)

}
