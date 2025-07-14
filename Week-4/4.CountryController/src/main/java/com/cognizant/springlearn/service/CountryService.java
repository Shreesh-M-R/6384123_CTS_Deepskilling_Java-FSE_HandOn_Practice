package com.cognizant.springlearn.service;

import com.cognizant.springlearn.dao.CountryDao;
import com.cognizant.springlearn.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryDao countryDao;

    public List<Country> getAllCountries() {
        return countryDao.getAllCountries();
    }

    public Country getCountryByCode(String code) {
        return countryDao.getCountryByCode(code);
    }

    public void addCountry(Country country) {
        countryDao.addCountry(country);
    }

    public void updateCountry(Country country) {
        countryDao.updateCountry(country);
    }

    public void deleteCountry(String code) {
        countryDao.deleteCountry(code);
    }
}
