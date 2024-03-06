package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface GoalRepositoryData  extends JpaRepository<Goal, Long> {

    //public List<Goal> findAllByCustomerId(Long idCustomer) throws SQLException;

}
