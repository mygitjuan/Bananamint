package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepositoryData extends JpaRepository<Expense, Integer> {

}
