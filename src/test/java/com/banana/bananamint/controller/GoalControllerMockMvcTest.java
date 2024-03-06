package com.banana.bananamint.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;


@AutoConfigureTestEntityManager
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class GoalControllerMockMvcTest {

    @Autowired
    private GoalController controller;

    @Test
    void getAll() {

        ResponseEntity<Object> response = controller.getAll();
        System.out.println("response:" + response.getBody());

        assertThat(response.getStatusCode().value())
                .isEqualTo(HttpStatus.OK.value());

        assertThat(response.getBody())
                .isNotNull();
    }

    @Test
    void getById() {

        ResponseEntity<Object> response = controller.getOne(1L);
        System.out.println("response:" + response.getBody());

        assertThat(response.getStatusCode().value())
                .isEqualTo(HttpStatus.OK.value());

        assertThat(response.getBody())
                .isNotNull();
    }

    @Test
    void getByIdInvalid() {

        final Long notFoundID  = 12345L;
        
        assertThat(controller.getOne(notFoundID).getStatusCode().value())
                .isEqualTo(HttpStatus.NOT_FOUND.value());

        assertThat(controller.getOne(notFoundID).getBody())
                .isNotEqualTo("[]");
    }


}