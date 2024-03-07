package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Budget;
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
    BudgetRepositoryData repo;
    @Autowired
    private TestEntityManager em;

    @Test
    void findAll() throws Exception {
        // given SQL Inserts
        Budget presu = new Budget(null, 1, 1000, null, 20.40, 500.50);
        em.persist(presu);
        //em.remove(presu); //quiero usar un Entity Manager, pero no quiero hacer el alta, solo quiero retornar datos
        //em.flush();

        List<Budget> presuList = repo.findAll();
        logger.info("Lista Presupuestos:" + presuList);

        assertThat(presuList.size()).isGreaterThan(0);
        assertNotNull(presuList);
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