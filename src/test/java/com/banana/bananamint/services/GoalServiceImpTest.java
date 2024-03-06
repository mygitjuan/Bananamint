package com.banana.bananamint.services;

import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Goal;
import com.banana.bananamint.payload.GoalApproximation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
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
@ComponentScan(basePackages = {"com.banana.bananamint.services","com.banana.bananamint.persistence"})
@AutoConfigureTestEntityManager
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class GoalServiceImpTest {
    @Autowired
    private GoalService servicioGoal;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TestEntityManager em;

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpTest.class);

    @Test
    void showAllValid() {
        // given
        LocalDate datNat = LocalDate.now().minusYears(20L);
        Customer usu = new Customer(null,"FAKE","j@j.com", datNat,"04653011L");
        em.persist(usu);
        em.flush();

        // when

        Customer usuario = customerService.findByCustomerId(usu.getId());
        logger.info("Usuario devuelto:" + usuario);

        // then
        assertThat(usuario.getId())
                .isEqualTo(usu.getId());

        assertNotNull(usuario);


        //given
        LocalDate datObj = LocalDate.now().plusYears(1L);

        Goal objetivo = new Goal(null, "Ladrillo", "Invertir en Ladrillo", 50000.00, "Activo", datObj, usuario);

        em.persist(objetivo);
        em.flush();

        // when
        List<Goal> objetivoList = servicioGoal.showAll(usuario.getId());

        logger.info("Objetivo:" + objetivoList);

        // then
        assertThat(objetivoList.size())
                .isGreaterThan(0);
        assertNotNull(objetivoList);
    }

    @Test
    void showAllInvalid() {
        // given
        LocalDate datNat = LocalDate.now().minusYears(20L);
        Customer usu = new Customer(null,"FAKE","j@j.com", datNat,"04653011L");
        em.persist(usu);
        em.flush();

        // when

        Customer usuario = customerService.findByCustomerId(usu.getId());
        logger.info("Usuario devuelto:" + usuario);

        // then
        assertThat(usuario.getId())
                .isEqualTo(usu.getId());

        assertNotNull(usuario);


        //given
        LocalDate datObj = LocalDate.now().plusYears(1L);

        Goal objetivo = new Goal(null, "Ladrillo", "Invertir en Ladrillo", 50000.00, "Activo", datObj, usuario);

        em.persist(objetivo);
        em.flush();

        // when
        List<Goal> objetivoList = servicioGoal.showAll(12345L);

        logger.info("Objetivo:" + objetivoList);

        // then
        assertThat(objetivoList.size())
                .isEqualTo(0);

    }

    @Test
    void generarReporteValido() {
        // given
        LocalDate datNat = LocalDate.now().minusYears(20L);
        Customer usu = new Customer(null,"FAKE","j@j.com", datNat,"04653011L");
        em.persist(usu);
        em.flush();

        // when

        Customer usuario = customerService.findByCustomerId(usu.getId());
        logger.info("Usuario devuelto:" + usuario);

        // then
        assertThat(usuario.getId())
                .isEqualTo(usu.getId());

        assertNotNull(usuario);


        //given
        LocalDate datObj = LocalDate.now().plusMonths(2L);

        Goal objetivo = new Goal(null, "Ladrillo", "Invertir en Ladrillo", 50000.00, "Activo", datObj, usuario);

        em.persist(objetivo);
        em.flush();


        logger.info("Objetivo:" + objetivo);


        LocalDate initDate = LocalDate.now().minusMonths(3L);
        LocalDate finalDate = LocalDate.now().plusMonths(3L);

        List<GoalApproximation> goalApproximationList = servicioGoal.generateReport(usuario.getId(), initDate, finalDate);

        logger.info("Lista de Objetivo Próximo:" + goalApproximationList);

        assertThat(goalApproximationList.size())
                .isGreaterThan(0);
        assertNotNull(goalApproximationList);

    }

@Test
    void generarReporteFueradeRangodeFechasInicialYFinal() {
        // given
        LocalDate datNat = LocalDate.now().minusYears(20L);
        Customer usu = new Customer(null,"FAKE","j@j.com", datNat,"04653011L");
        em.persist(usu);
        em.flush();

        // when

        Customer usuario = customerService.findByCustomerId(usu.getId());
        logger.info("Usuario devuelto:" + usuario);

        // then
        assertThat(usuario.getId())
                .isEqualTo(usu.getId());

        assertNotNull(usuario);


        //given
        LocalDate datObj = LocalDate.now().plusYears(2L);

        Goal objetivo = new Goal(null, "Ladrillo", "Invertir en Ladrillo", 50000.00, "Activo", datObj, usuario);

        em.persist(objetivo);
        em.flush();


        logger.info("Objetivo:" + objetivo);


        LocalDate initDate = LocalDate.now().minusMonths(3L);
        LocalDate finalDate = LocalDate.now().plusMonths(3L);

        List<GoalApproximation> goalApproximationList = servicioGoal.generateReport(usuario.getId(), initDate, finalDate);

        logger.info("Lista de Objetivo Próximo:" + goalApproximationList);

        assertThat(goalApproximationList.size())
                .isEqualTo(0);


    }

}