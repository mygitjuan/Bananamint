package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface GoalRepositoryData  extends JpaRepository<Goal, Long> {

    List<Goal> findByNameContaining(String name);

    @Query("select g from Goal g where customer_id = ?1")
    List<Goal> findByUserContaining(Customer user);



}
