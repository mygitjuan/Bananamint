package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Budget;
import com.banana.bananamint.domain.Category;
import com.banana.bananamint.domain.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@ComponentScan("com.banana.bananamint.persistence")
@AutoConfigureTestEntityManager
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class BudgetRepositoyDataTest {
    private static final Logger logger = LoggerFactory.getLogger(BudgetRepositoyDataTest.class);
    @Autowired
    private BudgetRepositoryData presup;
    @Autowired
    private TestEntityManager pem;

    @Test
    void crear_presupuesto() throws Exception {
        // given SQL Inserts
        Category cat = new Category(null,"Categria Casa","personal","Previsión de gastos mensual de casa",LocalDate.now());
        Customer usu = new Customer(null,"USUDRE", "diego@gmail.com", LocalDate.now(), "25444030G");
    //    Customer usu1 = new Customer(null,"FAKE","j@j.com", LocalDate.now(),"04653011L");

        Budget presu1 = new Budget(null, cat, 100, usu,200L,400L);

        // when
        presup.save(presu1);
        //em.remove(presu); //quiero usar un Entity Manager, pero no quiero hacer el alta, solo quiero retornar datos
        //em.flush();

        assertThat(presu1.getId()).isGreaterThan(0);
    }

    // @Test
   // void save() {
        // given
     //   Budget presu = new Budget(null, 1, 1000, 1, 2000, 500);

      //  repo.save(presu);
      //  System.out.println(presu);
      //  assertThat(presu.getId()).isGreaterThan(0);
   // }

}