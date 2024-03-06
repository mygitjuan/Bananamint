package com.banana.bananamint.services;

import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Goal;
import com.banana.bananamint.exception.GoalException;
import com.banana.bananamint.payload.Debt;
import com.banana.bananamint.payload.GoalApproximation;
import com.banana.bananamint.persistence.CustomerRepositoryData;
import com.banana.bananamint.persistence.GoalRepositoryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GoalServiceImp implements GoalService{

    @Autowired
    private GoalRepositoryData repoGoal;

    @Autowired
    private CustomerService repoCustomer;

    @Override
    public List<Goal> showAll(Long idCustomer) throws GoalException {
        Customer usuario = repoCustomer.findByCustomerId(idCustomer);

        //List<Goal> listGoal = repoGoal.getClass();

        return null;
    }

    @Override
    public List<Goal> add(Long idCustomer, Goal goal) throws GoalException {
        return null;
    }

    @Override
    public List<GoalApproximation> generateReport(Long idCustomer, LocalDate initDate, LocalDate finalDate) throws GoalException {
        return null;
    }

    @Override
    public List<Debt> accumulatedDebt(Long idCustomer, LocalDate initDate, LocalDate finalDate) throws GoalException {
        return null;
    }
}
