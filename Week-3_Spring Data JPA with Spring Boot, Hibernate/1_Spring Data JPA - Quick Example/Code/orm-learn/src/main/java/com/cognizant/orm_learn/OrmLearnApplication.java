package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * DatabaseLearningApplication - Main entry point for ORM demonstration
 * This Spring Boot application showcases JPA functionality through
 * country data retrieval and logging operations
 */
@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger APPLICATION_LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService nationService;

	/**
	 * Application startup method - initializes Spring context and demonstrates data access
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		ApplicationContext springContext = SpringApplication.run(OrmLearnApplication.class, args);
		APPLICATION_LOGGER.info("Inside main");

		nationService = springContext.getBean(CountryService.class);
		demonstrateCountryRetrieval();
	}

	/**
	 * Demonstrates country data retrieval functionality
	 * Fetches and logs all nation records from the database
	 */
	private static void demonstrateCountryRetrieval() {
		APPLICATION_LOGGER.info("Start");
		List<Country> countries = nationService.getAllCountries();
		APPLICATION_LOGGER.debug("countries={}", countries);
		APPLICATION_LOGGER.info("End");
	}
}