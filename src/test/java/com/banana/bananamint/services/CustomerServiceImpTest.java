package com.banana.bananamint.services;

import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.exception.CustomerException;
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
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.banana.bananamint.services","com.banana.bananamint.persistence"})
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomerServiceImpTest {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private TestEntityManager em;

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpTest.class);

    @Test
    @Transactional
    void findById() throws CustomerException {
        // given
        Customer usu = new Customer(null,"FAKE","j@j.com", LocalDate.now(),"04653011L");
        em.persist(usu);
        em.flush();

        // when

        Customer usuario = customerService.findByCustomerId(usu.getId());
        logger.info("Usuario devuelto:" + usuario);

        // then
        assertThat(usuario.getId())
                .isEqualTo(usu.getId());

        assertNotNull(usuario);

    }



}