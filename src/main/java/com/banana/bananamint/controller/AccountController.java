package com.banana.bananamint.controller;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.exception.AccountException;
import com.banana.bananamint.services.AccountService;
import com.banana.bananamint.services.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountServiceImpl accountService;

    @Autowired
    public AccountController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{idCustomer}")
    public List<Account> showAllAccounts(@PathVariable Long idCustomer) throws AccountException {
        return accountService.showAll(idCustomer);
    }

    @PostMapping("/open")
    public Account openAccount(@RequestBody AccountRequestDto accountDto) throws AccountException {
        Long customerId = accountDto.getCustomer().getId();
        Customer customer = customerService.fin
        Account account = accountDto.getAccount();
        return accountService.open(customer.getId(), account);
    }
}