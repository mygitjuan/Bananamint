package com.banana.bananamint.services;

import com.banana.bananamint.domain.Income;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ComponentScan(basePackages = {"com.banana.bananamint.service","com.banana.bananamint.persistence"})
@AutoConfigureTestEntityManager
class IncomeExpenseServTest {

    @Autowired
    private IncomeExpenseServ service;

    private static final Logger logger = LoggerFactory.getLogger(IncomeExpenseServTest.class);

    @Test
    void dadoIncomes_cuandoshowAllIncomes_entoncesNotNull() {
    //    List<Income> ingresos = service.showAllIncomes(1L);

    //    System.out.println("todos los ingresos:" + ingresos);

    //    assertThat(ingresos.size(),greaterThan(0));
    //    assertNotNull(ingresos);
    }

    @Test
    void addIncome() {
    }

    @Test
    void showAllExpenses() {
    }

    @Test
    void addExpense() {
    }
}