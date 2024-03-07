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
import java.util.ArrayList;
import java.util.List;

@Service
public class GoalServiceImp implements GoalService{

    @Autowired
    private GoalRepositoryData repoGoal;

    @Autowired
    private CustomerService serviceCustomer;

    @Override
    public List<Goal> showAll(Long idCustomer) throws GoalException {
        Customer user = serviceCustomer.findByCustomerId(idCustomer);

        List<Goal> listGoal = repoGoal.findByUserContaining(user);

        return listGoal;

    }

    @Override
    public List<Goal> add(Long idCustomer, Goal goal) throws GoalException {
        return null;
    }

    @Override
    public List<GoalApproximation> generateReport(Long idCustomer, LocalDate initDate, LocalDate finalDate) throws GoalException {
        List<Goal> listaGoal =  showAll(idCustomer);

        List<GoalApproximation> listG = new ArrayList<>();

        for (Goal g:listaGoal) {

            LocalDate tDate = g.getTargetDate();

            if (tDate.isBefore(finalDate) && tDate.isAfter(initDate)) {
                Double tAmount = g.getTargetAmount();
                Integer tendency = 0;
                GoalApproximation gal = new GoalApproximation(g, tAmount, tendency, tDate);
                listG.add(gal);
            }
        }

        return listG;
    }

    @Override
    public List<Debt> accumulatedDebt(Long idCustomer, LocalDate initDate, LocalDate finalDate) throws GoalException {
        return null;
    }

    @Override
    public List<Goal> getGoalsByText(String text) {
        return repoGoal.findByNameContaining(text);
    }
}
