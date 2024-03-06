package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.SQLException;
import java.util.List;

public interface AccountRepositoryData extends JpaRepository<Account, Long> {

}
