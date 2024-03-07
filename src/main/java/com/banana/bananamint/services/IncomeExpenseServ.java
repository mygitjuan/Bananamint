package com.banana.bananamint.services;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.domain.Expense;
import com.banana.bananamint.domain.Income;
import com.banana.bananamint.exception.IncomeExpenseException;
import com.banana.bananamint.payload.IncomeExpenseComparison;
import com.banana.bananamint.persistence.AccountRepositoryData;
import com.banana.bananamint.persistence.CustomerRepositoryData;
import com.banana.bananamint.persistence.ExpenseRepositoryData;
import com.banana.bananamint.persistence.IncomeRepositoryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IncomeExpenseServ implements IncomeExpenseService{
    @Autowired
    private CustomerRepositoryData custRepo;
    @Autowired
    private AccountRepositoryData accoRepo;
    @Autowired
    private ExpenseRepositoryData gastRepo;
    @Autowired
    private IncomeRepositoryData ingrRepo;
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Income> showAllIncomes(Long idCustomer) throws IncomeExpenseException {
        List<Income> ingrTot = ingrRepo.findAll();
        List<Income> ingUsu = new ArrayList<>();

        Customer cust = custRepo.findById(idCustomer).orElseThrow(() -> new IncomeExpenseException("No existe el customer" + idCustomer));
        em.detach(cust);

        for (Income income: ingrTot){
            if(income.getUser() == cust){ingUsu.add(income);}
        }
        return ingUsu;
    }

    @Override
    public Income addIncome(Long idCustomer, Income income) throws IncomeExpenseException {
        Customer cust = custRepo.findById(idCustomer).orElseThrow(() -> new IncomeExpenseException("No existe el customer" + idCustomer));

        income.setUser(cust);
        return ingrRepo.save(income);
    }

    @Override
    public List<Expense> showAllExpenses(Long idCustomer) throws IncomeExpenseException {
        List<Expense> gastTot = gastRepo.findAll();
        List<Expense> gastUsu = new ArrayList<>();

        Customer cust = custRepo.findById(idCustomer).orElseThrow(() -> new IncomeExpenseException("No existe el customer" + idCustomer));

        for (Expense expense: gastTot){
            if(expense.getUser() == cust){gastUsu.add(expense);}
        }
        return gastUsu;
    }

    @Override
    public Expense addExpense(Long idCustomer, Expense expense) throws IncomeExpenseException {
        Customer cust = custRepo.findById(idCustomer).orElseThrow(() -> new IncomeExpenseException("No existe el customer" + idCustomer));
        expense.setUser(cust);
        return gastRepo.save(expense);
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
