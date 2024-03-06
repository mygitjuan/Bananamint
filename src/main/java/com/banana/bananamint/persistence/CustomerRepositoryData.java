package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Category;
import com.banana.bananamint.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositoryData extends JpaRepository<Customer, Long> {

}
