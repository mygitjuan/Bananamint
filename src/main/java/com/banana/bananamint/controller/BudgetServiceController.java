package com.banana.bananamint.controller;

import com.banana.bananamint.persistence.BudgetJPARepository;
import com.banana.bananamint.services.BudgetService;
import com.banana.bananamint.services.IBudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/budge")
@Validated
public class BudgetServiceController {
    @Autowired
    BudgetJPARepository BudgetRepo;

    @Autowired
    BudgetService service;

}
