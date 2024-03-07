package com.banana.bananamint.services;

import com.banana.bananamint.domain.Budget;
import com.banana.bananamint.domain.Expense;
import com.banana.bananamint.exception.BudgetException;
import com.banana.bananamint.persistence.BudgetJPARepository;
import com.banana.bananamint.persistence.CategoryRepositoryData;
import com.banana.bananamint.persistence.CustomerRepositoryData;
import com.banana.bananamint.persistence.ExpenseRepositoryData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public abstract class BudgetService implements IBudgetService {

    @Autowired
    private ExpenseRepositoryData BudgetRepo;
    @Autowired
    private CustomerRepositoryData custRepo;
    @Autowired
    private CategoryRepositoryData categRepo;

    @PersistenceContext
    EntityManager em;

    private Logger logger = LoggerFactory.getLogger(BudgetService.class);

    @Autowired
    private BudgetJPARepository budgetJPARepository;

    // @Override
    //public Budget create(Budget budget){
    //    Long amount = new ;
    //   budget.getAmount();
    //   return BudgetJPARepository.class
    //}

    @Override
    public List<Budget> showAll(Long idCustomer, String categoryName) throws BudgetException {

        List<Budget> lpresup = BudgetRepo.findAll();


    }

    @Override
    public Budget add(Long idCustomer, String categoryName) throws BudgetException {
        return null;
    }
}
