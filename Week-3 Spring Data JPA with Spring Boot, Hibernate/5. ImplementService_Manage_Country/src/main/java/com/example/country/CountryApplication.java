package com.example.country;

import com.example.country.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountryApplication implements CommandLineRunner {

    @Autowired
    private CountryRepository countryRepository;

    public static void main(String[] args) {
       SpringApplication.run(CountryApplication.class, args);
    }

    @Override
    public void run(String... args) {
       System.out.println("All countries:");
       countryRepository.findAll().forEach(c -> System.out.println(c.getName()));

          }
}

