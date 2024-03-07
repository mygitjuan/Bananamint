package com.banana.bananamint.services;

import com.banana.bananamint.domain.Budget;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Income;
import com.banana.bananamint.exception.BudgetException;
import com.banana.bananamint.exception.IncomeExpenseException;

import java.util.ArrayList;
import java.util.List;

public interface IBudgetService {

    Budget create(Budget budget);

     public List<Budget> showAllBudget(String id, Long idCustomer) throws BudgetException {
        List<Budger> presu = new ArrayLi<>();

        return null;
    }



    public Budget add(Long idCustomer, String categoryName) throws BudgetException;
}
