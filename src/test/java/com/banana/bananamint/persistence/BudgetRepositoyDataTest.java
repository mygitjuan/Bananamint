package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Budget;
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

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ComponentScan("com.banana.bananamint.persistence")
@AutoConfigureTestEntityManager
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

    public class BudgetJPARepositoyTest {

    private static final Logger logger = LoggerFactory.getLogger(BudgetJPARepositoyTest.class);

    @Autowired
    BudgetJPARepository repo;

    @Autowired
    private TestEntityManager em;

    @Test
    void findAll() throws Exception {
        // given SQL Inserts
        Budget pres = new Budget(null, 1, 1000, 1, 2000, 500);
        em.persist(pres);
        em.flush();
    }

}