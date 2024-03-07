package com.banana.bananamint.services;

import com.banana.bananamint.domain.Budget;
import com.banana.bananamint.domain.Category;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Income;
import com.banana.bananamint.exception.BudgetException;
import com.banana.bananamint.exception.IncomeExpenseException;
import com.banana.bananamint.persistence.CategoryRepositoryData;
import com.banana.bananamint.persistence.CustomerRepositoryData;
import com.banana.bananamint.persistence.ExpenseRepositoryData;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public interface IBudgetService {



    Budget create(Budget budget);

  //  public List<Budget> showAll(Long idCustomer, String id) throws BudgetException {

    //    List<> presu = BudgetRepo.findAll();
    //    return null;
//
   // }


    public Budget add(Long idCustomer, String categoryName) throws BudgetException;
}
