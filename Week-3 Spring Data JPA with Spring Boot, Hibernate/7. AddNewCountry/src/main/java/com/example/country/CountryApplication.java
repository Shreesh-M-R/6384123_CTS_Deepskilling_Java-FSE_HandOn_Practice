package com.example.country;

import com.example.country.entity.Country;
import com.example.country.repository.CountryRepository;
import com.example.country.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.country.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class CountryApplication implements CommandLineRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(com.example.country.CountryApplication.class);

	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private CountryService countryService;

	public static void main(String[] args) {
		SpringApplication.run(com.example.country.CountryApplication.class, args);
	}

	@Override
	public void run(String... args) {
		testAddCountry();
	}

	private void testAddCountry() {
		LOGGER.info("Start testAddCountry");

		Country newCountry = new Country();
		newCountry.setCode("SS");
		newCountry.setName("TestLand");

		countryService.addCountry(newCountry);

		try {
			Country fetched = countryService.findCountryByCode("SS");
			LOGGER.debug("Fetched Country: {}", fetched);
		} catch (CountryNotFoundException e) {
			LOGGER.error("Country not found: {}", e.getMessage());
		}

		LOGGER.info("End testAddCountry");
	}
}
