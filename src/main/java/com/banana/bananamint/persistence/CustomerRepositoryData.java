package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Category;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepositoryData extends JpaRepository<Customer, Long> {
    @Query("select c from Customer c where c.id = ?1")
    Customer findByCustomerId(Long id);
}
