package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Goal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.Boolean.FALSE;
import static org.junit.jupiter.api.Assertions.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ComponentScan("com.banana.bananamint.persistence")
@AutoConfigureTestEntityManager
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class GoalRepositoryDataTest {
        // given
    @Autowired
    private GoalRepositoryData repo;

    private static final Logger logger = LoggerFactory.getLogger(GoalRepositoryDataTest.class);

    @Autowired
    private TestEntityManager em;


    @Test void observarCumplimientoFinanciero() throws Exception {
        LocalDate datObj = LocalDate.now().plusYears(1L);

        Goal objetivo = new Goal(null, "Ladrillo", "Invertir en Ladrillo", 50000.00, "Activo", datObj, null);

        em.persist(objetivo);
        em.flush();

        // when
        List<Goal> objetivoList = repo.findAll();
        logger.info("Proyectos:" + objetivoList);

        // then
        assertThat(objetivoList.size())
                .isGreaterThan(0);
        assertNotNull(objetivoList);



    }

}