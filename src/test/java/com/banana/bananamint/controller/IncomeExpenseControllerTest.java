package com.banana.bananamint.controller;
import com.banana.bananamint.domain.*;
import com.banana.bananamint.persistence.*;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class IncomeExpenseControllerTest {

    @Autowired
    private IncomeExpenseController controller;

    @Test
    void dadoUnGasto_cuandoAnadimosACuentaDeUnUsuario_entoncesIsNotNull() {
        Customer usu = new Customer(1L);
        Account cta = new Account(1L);
        Expense gasto = new Expense(null, usu, 10, LocalDate.now(),cta, "pendiente");

        System.out.println("usu:" + usu);
        System.out.println("cta:" + cta);
        System.out.println("gasto:" + gasto);

        ResponseEntity<Expense> response = controller.anadeGastosCuenta(usu.getId(),cta.getId(),gasto);

        System.out.println("respuesta gasto:" + response);
        System.out.println("gasto:" + response.getBody());

        //assertThat(response.getStatusCode().value()).isEqualTo(HttpStatus.OK.value());
        //assertThat(response.getBody()).isNotNull();
    }

    @Test
    void anadeIngresosCuenta() {
    }
}