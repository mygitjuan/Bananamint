package com.banana.bananamint.services;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Expense;
import com.banana.bananamint.domain.Income;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.time.LocalDate;
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
    private IncomeExpenseServ servicioInEx;

    @Test
    void dadoUnIngreso_cuandoAnadimosACuentaDeUnUsuario_entoncesSeCrea() {
        Customer usu = new Customer(1L);
        Account cta = new Account(1L);
        Income ingreso = new Income(null, usu, 10, LocalDate.now(),cta, "pendiente");

        System.out.println("usu:" + usu);
        System.out.println("cta:" + cta);
        System.out.println("gasto:" + ingreso);

        Income income = servicioInEx.addIncome(usu.getId(),ingreso);

        System.out.println("Id ingreso:" + income.getId());

        assertNotNull(income);
        assertThat(income.getId(), greaterThan(0));
    }
    @Test
    void dadoIncomes_cuandoshowAllIncomes_entoncesListaVacia() {
        List<Income> ingresos = servicioInEx.showAllIncomes(1L);

        System.out.println("todos los ingresos:" + ingresos);

        assertThat(ingresos.size(), equalTo(0));
        assertNotNull(ingresos);
    }

    @Test
    void dadoUnGasto_cuandoAnadimosACuentaDeUnUsuario_entoncesSeCrea() {
        Customer usu = new Customer(1L);
        Account cta = new Account(1L);
        Expense gasto = new Expense(null, usu, 10, LocalDate.now(),cta, "pendiente");

        System.out.println("usu:" + usu);
        System.out.println("cta:" + cta);
        System.out.println("gasto:" + gasto);

        Expense expense = servicioInEx.addExpense(usu.getId(),gasto);

        System.out.println("Id gasto:" + expense.getId());

        assertNotNull(expense);
        assertThat(expense.getId(), greaterThan(0));
    }

    @Test
    void dadoExpenses_cuandoshowAllExpenses_entoncesListaVacia() {
        List<Expense> gastos = servicioInEx.showAllExpenses(1L);

        System.out.println("todos los gastos:" + gastos);

        assertThat(gastos.size(), equalTo(0));
        assertNotNull(gastos);
    }
}