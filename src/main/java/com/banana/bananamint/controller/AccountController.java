package com.banana.bananamint.controller;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.exception.AccountException;
import com.banana.bananamint.exception.CustomerException;
import com.banana.bananamint.services.AccountService;
import com.banana.bananamint.services.AccountServiceImpl;
import com.banana.bananamint.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;
    private final CustomerService customerService;

    @Autowired
    public AccountController(AccountServiceImpl accountService, CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }

    @GetMapping("/{idCustomer}")
    public List<Account> showAllAccounts(@PathVariable Long idCustomer) throws AccountException {
        return accountService.showAll(idCustomer);
    }

    @PostMapping("/open")
    public Account openAccount(@RequestBody AccountRequestDto accountDto) throws AccountException {
        Long customerId = accountDto.getCustomer().getId();
        Customer customer = customerService.findById(customerId);
        if (customer == null){
            throw new CustomerException("Customer no encontrado con ese Id: "+ customerId);
        }
        Account account = accountDto.getAccount();
        return accountService.open(customer.getId(), account);
    }
}