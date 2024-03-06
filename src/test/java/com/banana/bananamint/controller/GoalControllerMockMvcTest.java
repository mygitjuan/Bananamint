package com.banana.bananamint.controller;

import com.banana.bananamint.domain.Goal;
import com.banana.bananamint.persistence.GoalRepositoryData;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GoalControllerMockMvcTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private GoalRepositoryData repository;


    @Test
    @Order(1)
    @Transactional
    public void givenProducts_whenGetProducts_thenStatus200() throws Exception {
        LocalDate datObj = LocalDate.now().plusYears(1L);

        Goal nuevoObjetivo = new Goal(null, "Ladrillo", "Invertir en Ladrillo", 50000.00, "Activo", datObj, null);;
        repository.save(nuevoObjetivo);

        mvc.perform(get("/objetivos").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[*].name", hasItem("Ladrillo")));
    }

}