package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.SQLException;
import java.util.List;

public interface AccountRepositoryData extends JpaRepository<Account, Long> {
    List<Account> findByOwner(Customer cowner);

}
