package com.banana.bananamint.controller;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import lombok.Data;

@Data
public class AccountRequestDto {
    private Customer customer;
    private Account account;

}
