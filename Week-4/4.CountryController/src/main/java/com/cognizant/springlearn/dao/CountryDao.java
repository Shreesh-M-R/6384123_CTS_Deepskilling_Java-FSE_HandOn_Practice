package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Country;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CountryDao {

    private static List<Country> countryList = new ArrayList<>();

    static {
        countryList.add(new Country("IN", "India"));
        countryList.add(new Country("US", "United States"));
    }

    public List<Country> getAllCountries() {
        return countryList;
    }

    public Country getCountryByCode(String code) {
        return countryList.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }

    public void addCountry(Country country) {
        countryList.add(country);
    }

    public void updateCountry(Country updatedCountry) {
        Country existing = getCountryByCode(updatedCountry.getCode());
        if (existing != null) {
            existing.setName(updatedCountry.getName());
        }
    }

    public void deleteCountry(String code) {
        countryList.removeIf(country -> country.getCode().equalsIgnoreCase(code));
    }
}
