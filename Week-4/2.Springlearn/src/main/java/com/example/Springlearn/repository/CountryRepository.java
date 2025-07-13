package com.example.Springlearn.repository;

import com.example.Springlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
}
