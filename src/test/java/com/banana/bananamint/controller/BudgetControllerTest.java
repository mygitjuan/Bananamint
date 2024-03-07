package com.banana.bananamint.controller;

import com.banana.bananamint.domain.Budget;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import com.banana.bananamint.domain.Budget;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)

//@DataJpaTest
@Sql(value = "classpath:testing.sql")
@ComponentScan(basePackages = {"com.banana.bananamint.services","com.banana.bananamint.persistence"})
//@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class BudgetControllerTest {

   // @Autowired
   // private BudgetServiceTest service;
    // /private static final Logger logger = LoggerFactory.getLogger(BudgetServiceTest.class);

 // @Test
 // void givenBudgets_whengetAllBudgets_thenIsNotNull() {
 //    ResponseEntity<List<Budget>> response = controller.getAllBudgets();
 //    System.out.println("response:" + response.getBody());

      // assertThat(response.getStatusCode().value()).isEqualTo(HttpStatus.OK.value());

       //assertThat(response.getBody()).isNotNull();
  // }

//  @Test
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
