package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * NationBusinessLogic - Service layer for managing country operations
 * Provides business logic and transaction management for country-related
 * database operations through the repository layer
 */
@Service
public class CountryService {

    @Autowired
    private CountryRepository nationRepository;

    /**
     * Fetches all nation records from the database
     * @return Complete list of country entities
     */
    @Transactional(readOnly = true)
    public List<Country> getAllCountries() {
        return nationRepository.findAll();
    }
}