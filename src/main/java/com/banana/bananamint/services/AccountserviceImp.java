package com.banana.bananamint.services;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.exception.AccountException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountserviceImp implements AccountService{
    @Override
    public List<Account> showAll(Long idCustomer) throws AccountException {
        return null;
    }

    @Override
    public Account open(Long idCustomer, Account account) throws AccountException {
        return null;
    }
}
