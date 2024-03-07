package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerJPARepository {
    public List<Customer> findAll(Long idCustomer) throws SQLException;
}
