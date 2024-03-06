package com.banana.bananamint.services;

import com.banana.bananamint.domain.Customer;

public interface CustomerService {
    Customer findById(Long id);
}
