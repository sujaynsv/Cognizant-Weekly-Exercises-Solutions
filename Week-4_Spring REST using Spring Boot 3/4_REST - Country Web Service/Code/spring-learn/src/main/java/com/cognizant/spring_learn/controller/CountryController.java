package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.Nation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NationController.class);

    @RequestMapping("/country")
    public Nation fetchNationIndia() {
        LOGGER.debug("START - getCountryIndia()");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("country.xml");
        Nation nation = ctx.getBean("country", Nation.class);
        LOGGER.debug("END - getCountryIndia()");
        return nation;
    }
}