package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Expense;
import com.banana.bananamint.domain.Income;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ComponentScan("com.banana.bananamint.persistence")
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ExpenseRepositoryDataTest {

    @Autowired
    private TestEntityManager tem;

    @Autowired
    private ExpenseRepositoryData gastRepo;
    @Autowired
    private IncomeRepositoryData ingrRepo;

    @Test
    void anadir_ungasto() {
        // given
        Customer usu = tem.find(Customer.class, 1L);
        Account cta = tem.find(Account.class, 1L);
        Expense gasto = new Expense(null, usu, 10, LocalDate.now(),cta, "pendiente");

        // when
        gastRepo.save(gasto);

        System.out.println("añadido gasto:" + gasto);

        // then
        assertThat(gasto.getId()).isGreaterThan(0);
    }
        @Test
    void anadir_uningreso() {
        // given
        Customer usu = tem.find(Customer.class, 1L);
        Account cta = tem.find(Account.class, 1L);
        Income ingreso = new Income(null, usu, 10, LocalDate.now(),cta, "pendiente");

        // when
        ingrRepo.save(ingreso);

        System.out.println("añadido gasto:" + ingreso);

        // then
        assertThat(ingreso.getId()).isGreaterThan(0);
    }

}