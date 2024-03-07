package com.banana.bananamint.services;

import com.banana.bananamint.domain.Expense;
import com.banana.bananamint.domain.Income;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.banana.bananamint.services","com.banana.bananamint.persistence"})
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IncomeExpenseServTest {

    @Autowired
    private IncomeExpenseService servicioInEx;

    @Autowired
    private TestEntityManager em;

    @Test
    void dadoIncomes_cuandoshowAllIncomes_entoncesListaVacia() {
        List<Income> ingresos = servicioInEx.showAllIncomes(1L);

        System.out.println("todos los ingresos:" + ingresos);

        assertThat(ingresos.size(), equalTo(0));
        assertNotNull(ingresos);
    }

    @Test
    void dadoaddIncome() {
    }

    @Test
    void dadoExpenses_cuandoshowAllExpenses_entoncesListaVacia() {
        List<Expense> gastos = servicioInEx.showAllExpenses(1L);

        System.out.println("todos los gastos:" + gastos);

        assertThat(gastos.size(), equalTo(0));
        assertNotNull(gastos);
    }

    @Test
    void addExpense() {
    }
}