package com.banana.bananamint.services;

import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.exception.CustomerException;
import com.banana.bananamint.persistence.CustomerRepositoryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService{
    @Autowired
    CustomerRepositoryData repoCustomer;

    @Override
    public Customer findByCustomerId(Long idCustomer) throws CustomerException {
        Customer customer = repoCustomer.findByCustomerId(idCustomer);
        return customer;
    }
}
