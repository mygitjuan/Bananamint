package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Income;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.SQLException;
import java.util.List;

public interface IncomeRepositoryData extends JpaRepository<Income, Integer> {

}
