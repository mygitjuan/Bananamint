package com.banana.bananamint.services;

import com.banana.bananamint.domain.Budget;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

public class BudgetServicesControllerTest {
//@SpringBootTest
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)

    @Autowired
    private BudgetServicesControllerTest controller;

//   @Test
//   void givenBudgets_whengetAllBudgets_thenIsNotNull() {
//       ResponseEntity<List<Budget>> response = controller.getAllBudgets();
//       System.out.println("response:" + response.getBody());

//       assertThat(response.getStatusCode().value())
//               .isEqualTo(HttpStatus.OK.value());

//       assertThat(response.getBody())
//               .isNotNull();
//   }

//   @Test
//   void givenBudgets_whenVaildCreateBudget_thenIsCreatedAndHaveId() {
//       Budget newBudget = new Budget(null, 2000, "Nuevo Presupuesto", 4");

//       ResponseEntity<Budget> response = controller.createBudget(newBudget);
//       System.out.println("***** response:" + response);

//       assertThat(response.getStatusCode().value()).isEqualTo(HttpStatus.CREATED.value());
//       assertThat(response.getBody().getId()).isGreaterThan(0);

//   }

//   @Test
//   void givenBudgets_whenInVaildCreateBudget_thenException() {
//       Budget newBudget = new Budget(null, 1,3000,1,500,600 );

//       Assertions.assertThrows(RuntimeException.class, () -> {
//           ResponseEntity<Budget> response = controller.createBudget(newBudget);

//       });


}
