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
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryApplication.class);

	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private CountryService countryService;

	public static void main(String[] args) {
		SpringApplication.run(CountryApplication.class, args);
	}

	@Override
	public void run(String... args) {
		testUpdateCountry();
	}

	private void testUpdateCountry() {
		LOGGER.info("Start testUpdateCountry");

		try {
			countryService.updateCountry("IN", "Bharat");
			Country updated = countryService.findCountryByCode("IN");
			LOGGER.debug("Updated Country: {}", updated);
		} catch (CountryNotFoundException e) {
			LOGGER.error("Country not found: {}", e.getMessage());
		}

		LOGGER.info("End testUpdateCountry");
	}

}
