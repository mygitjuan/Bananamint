package com.banana.bananamint.services;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.exception.AccountException;

import java.util.List;

public interface AccountService {
    public List<Account> showAll(Long idCustomer) throws AccountException;

    public Account open(Customer idCustomer, Account account) throws AccountException;
}
