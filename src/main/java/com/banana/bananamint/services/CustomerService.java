package com.banana.bananamint.services;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.exception.CustomerException;

public interface CustomerService {
    public Customer findByCustomerId(Long idCustomer) throws CustomerException;
}
