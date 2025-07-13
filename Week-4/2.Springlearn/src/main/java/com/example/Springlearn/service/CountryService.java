package com.example.Springlearn.service;

import com.example.Springlearn.model.Country;
import com.example.Springlearn.repository.CountryRepository;
import com.example.Springlearn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    public Country getCountry(String code) throws CountryNotFoundException {
        return repository.findById(code.toUpperCase())
                .orElseThrow(() -> new CountryNotFoundException("Country not found"));
    }

    public List<Country> getAllCountries() {
        return repository.findAll();
    }
}
