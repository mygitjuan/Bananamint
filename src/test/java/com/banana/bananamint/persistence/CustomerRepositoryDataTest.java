package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Customer;
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
@ComponentScan("com.banana.bananamint.persistence")
@AutoConfigureTestEntityManager
class CustomerRepositoryDataTest {
    private static final Logger logger = LoggerFactory.getLogger(CustomerRepositoryDataTest.class);

    @Autowired
    private CustomerRepositoryData repo;

    @Autowired
    private TestEntityManager em;

    @Test
    void findAll() throws Exception {
        // given
        Customer usu = new Customer(null,"FAKE","j@j.com", LocalDate.now(),"04653011L");
        em.persist(usu);

        // when

        List<Customer> usuList = repo.findAll();
        logger.info("Lista usuarios:" + usuList);

        // then
        assertThat(usuList.size()).isGreaterThan(0);
        assertNotNull(usuList);
    }
}