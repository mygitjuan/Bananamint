package com.banana.bananamint.services;

import com.banana.bananamint.domain.Expense;
import com.banana.bananamint.domain.Income;
import com.banana.bananamint.exception.IncomeExpenseException;
import com.banana.bananamint.payload.IncomeExpenseComparison;
import com.banana.bananamint.persistence.CustomerRepositoryData;
import com.banana.bananamint.persistence.ExpenseRepositoryData;
import com.banana.bananamint.persistence.IncomeRepositoryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Service
public class IncomeExpenseServ implements IncomeExpenseService{
    @Autowired
    private CustomerRepositoryData usuRepo;

    @Autowired
    private ExpenseRepositoryData gastoRepo;
    @Autowired
    private IncomeRepositoryData ingrRepo;

    @PersistenceContext
    EntityManager em;
    @Override
    public List<Income> showAllIncomes(Long idCustomer) throws IncomeExpenseException {
        return ingrRepo.findAll();
    }

    @Override
    public Income addIncome(Long idCustomer, Income income) throws IncomeExpenseException {
        return ingrRepo.save(income);
    }

    @Override
    public List<Income> showAllExpenses(Long idCustomer) throws IncomeExpenseException {
        return ingrRepo.findAll();
    }

    @Override
    public Income addExpense(Long idCustomer, Expense expense) throws IncomeExpenseException {
        return null;
    }

    @Override
    public List<Income> showAllExpensesByDateRange(Long idCustomer, LocalDate initDate, LocalDate finalDate) throws IncomeExpenseException {
        return null;
    }

    @Override
    public List<IncomeExpenseComparison> getFinancialPerspective(Long idCustomer, LocalDate initDate, LocalDate finalDate) throws IncomeExpenseException {
        return null;
    }
}
