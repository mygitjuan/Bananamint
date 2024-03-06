package com.banana.bananamint.controller;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Goal;
import com.banana.bananamint.exception.StatusMessage;
import com.banana.bananamint.persistence.GoalRepositoryData;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/objetivos")
@Validated
@Tag(name = "Goals", description = "Bananamint-Goals API management APIs")
public class GoalController {
    private static final Logger logger = LoggerFactory.getLogger(GoalController.class);

    @Autowired
    private GoalRepositoryData repoGoal;



    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getAll() {
        List<Goal> listGoal = repoGoal.findAll();
        if (listGoal == null) {
            return new ResponseEntity<>(new StatusMessage(HttpStatus.NOT_FOUND.value(), "No hay objetivos cargados"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>( repoGoal.findAll(), HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/{gid}", method = RequestMethod.GET)
    public ResponseEntity<Object> getOne(@PathVariable("gid") Long id) {
        if (id <= 0L) return new ResponseEntity<>( repoGoal.findById(id).get(), HttpStatus.OK);
        else return new ResponseEntity<>(new StatusMessage(HttpStatus.NOT_FOUND.value(), "No hay objetivos cargados"), HttpStatus.NOT_FOUND);
    }



}
