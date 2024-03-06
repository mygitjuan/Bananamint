package com.banana.bananamint.services;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.exception.AccountException;
import com.banana.bananamint.persistence.AccountRepositoryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class AccountServiceImpl implements AccountService {

    private final AccountRepositoryData accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepositoryData accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> showAll(Long idCustomer) throws AccountException {
        List<Account> accounts = accountRepository.findAll();
        if (accounts.isEmpty()) {
            throw new AccountException("No se encontraron cuentas para el cliente con ID: " + idCustomer);
        }
        return accounts;
    }
    @Override
    public Account open(Customer idCustomer, Account account) throws AccountException {
        // Asignar el cliente a la cuenta
        account.setOwner(idCustomer);

        // Guardar la nueva cuenta en la base de datos
        return accountRepository.save(account);
    }
}