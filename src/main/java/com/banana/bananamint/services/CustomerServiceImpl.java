package com.banana.bananamint.services;

import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.exception.CustomerException;
import com.banana.bananamint.persistence.CustomerRepositoryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepositoryData customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepositoryData customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerException("Customer no encontrado con el id: " + id));
    }
}

