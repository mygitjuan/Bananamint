package com.banana.bananamint.controller;

import com.banana.bananamint.domain.Goal;
import com.banana.bananamint.persistence.GoalRepositoryData;
import com.banana.bananamint.services.GoalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GoalControllerWebMockMvcTest {


    @BeforeEach
    public void setUp() {
        LocalDate datObj = LocalDate.now().plusYears(1L);

        List<Goal> proyectos = Arrays.asList(
                new Goal(2L, "Ladrillo", "Invertir en Ladrillo", 50000.00, "Activo", datObj, null));


        Mockito.when(service.getGoalsByText("Fake"))
                .thenReturn(proyectos);

        Mockito.when(repository.findByNameContaining("Fake"))
                .thenReturn(proyectos);

        Mockito.when(repository.findAll())
                .thenReturn(proyectos);

    }


    @Autowired
    private MockMvc mvc;

    @MockBean
    private GoalService service;

    @MockBean
    private GoalRepositoryData repository;


    @Test
    @Order(1)
    public void givenGoal_whenGetGoal_thenStatus200() throws Exception {
        LocalDate datObj = LocalDate.now().plusYears(1L);

        Goal nuevoObjetivo = new Goal(2L, "Ladrillo", "Invertir en Ladrillo", 50000.00, "Activo", datObj, null);

        List<Goal> allGoals = Arrays.asList(nuevoObjetivo);

        given(repository.findAll()).willReturn(allGoals);

        mvc.perform(get("/objetivos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(nuevoObjetivo.getName())));
    }

    @Test
    @Order(2)
    public void givenGoal_whenGetGoal_thenStatus404() throws Exception {
        LocalDate datObj = LocalDate.now().plusYears(1L);
        Goal nuevoObjetivo = new Goal(2L, "Ladrillo", "Invertir en Ladrillo", 50000.00, "Activo", datObj, null);

        List<Goal> allGoals = Arrays.asList(nuevoObjetivo);

        given(repository.findAll()).willReturn(allGoals);

        mvc.perform(get("/noexisto")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }

}