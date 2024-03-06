package com.banana.bananamint.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class IncomeExpenseControllerTest {

    @Autowired
    private IncomeExpenseController controller;
    @Test
    void anadeGastosCuenta() {
    }

    void dadoUnGasto_cuandoAñadimosACuentaDeUnUsuario_entoncesIsNotNull() {
        ResponseEntity<List<Product>> response = controller.getAllProducts();
        System.out.println("response:" + response.getBody());

        assertThat(response.getStatusCode().value())
                .isEqualTo(HttpStatus.OK.value());

        assertThat(response.getBody())
                .isNotNull();
    }

    @Test
    void anadeIngresosCuenta() {
    }
}