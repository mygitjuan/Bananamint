package com.banana.bananamint.controller;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Expense;
import com.banana.bananamint.domain.Income;
import com.banana.bananamint.exception.IncomeExpenseException;
import com.banana.bananamint.persistence.AccountRepositoryData;
import com.banana.bananamint.services.IncomeExpenseServ;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
@RestController
@RequestMapping(value = "/customer")
@Tag(name = "IncomeExpense API", description = "Incomes Expenses management APIs")
public class IncomeExpenseController {
    private static final Logger logger = LoggerFactory.getLogger(IncomeExpenseController.class);

    @Autowired
    IncomeExpenseServ servIncExp;

    @Autowired
    private AccountRepositoryData accoRepo;

    @PutMapping(value = "/{uid}/cuenta/{cid}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity anadeGastosCuenta(
            @PathVariable @Min(1) Long uid,
            @PathVariable @Min(1) Long cid,
            @RequestBody @Valid Expense gastos
    ) {
        Account cta = accoRepo.findById(cid).orElseThrow(() -> new IncomeExpenseException("No existe la cuenta" + cid));;
        if(gastos.getMoneyFrom() == null && gastos.getMoneyFrom() == cta){
            gastos.setMoneyFrom(cta);
            return new ResponseEntity<>(servIncExp.addExpense(uid,gastos), HttpStatus.CREATED);
        }
        else throw new IncomeExpenseException("Gastos de una cuenta distinta a la de Expense");
    }


    @PutMapping(value = "/{uid}/ingreso/{cid}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity anadeIngresosCuenta(
            @PathVariable @Min(1) Long uid,
            @PathVariable @Min(1) Long cid,
            @RequestBody @Valid Income ingresos
    ) {
        Account cta = accoRepo.findById(cid).orElseThrow(() -> new IncomeExpenseException("No existe la cuenta" + cid));;
        if(ingresos.getMoneyTo() == null && ingresos.getMoneyTo() == cta){
            ingresos.setMoneyTo(cta);
            return new ResponseEntity<>(servIncExp.addIncome(uid,ingresos), HttpStatus.CREATED);
        }
        else throw new IncomeExpenseException("Gastos de una cuenta distinta a la de Expense");
    }


}
