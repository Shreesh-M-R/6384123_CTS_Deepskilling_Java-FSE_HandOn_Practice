package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		CountryRepository countryRepository = context.getBean(CountryRepository.class);

		LOGGER.info("Inside main");

		insertCountries(countryRepository);
		fetchAndPrintCountries(countryRepository);
	}

	private static void insertCountries(CountryRepository countryRepository) {
		LOGGER.info("Start inserting countries");

		Country india = new Country();
		india.setCode("IN");
		india.setName("India");

		Country us = new Country();
		us.setCode("US");
		us.setName("United States of America");

		countryRepository.save(india);
		countryRepository.save(us);

		LOGGER.info("Finished inserting countries");
	}

	private static void fetchAndPrintCountries(CountryRepository countryRepository) {
		LOGGER.info("Start fetching countries");
		List<Country> countries = countryRepository.findAll();
		countries.forEach(country -> LOGGER.debug("Country: {}", country));
		LOGGER.info("Finished fetching countries");
	}
}

