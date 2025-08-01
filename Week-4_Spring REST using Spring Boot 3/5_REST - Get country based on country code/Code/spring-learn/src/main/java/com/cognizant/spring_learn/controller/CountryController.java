package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Nation;
import com.cognizant.spring_learn.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NationController {

    @Autowired
    private NationService nationService;

    @GetMapping("/country/{id}")
    public Nation fetchNation(@PathVariable String id) {
        return nationService.fetchNationById(id);
    }
}