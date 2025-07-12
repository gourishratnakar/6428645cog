package com.example.countryservice.service;

import com.example.countryservice.model.Country;
import com.example.countryservice.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    private final CountryRepository repo;

    public CountryService(CountryRepository repo) {
        this.repo = repo;
    }

    public Optional<Country> getCountryByCode(String code) {
        return repo.findById(code);
    }

    public Country addCountry(Country country) {
        return repo.save(country);
    }

    public Country updateCountry(Country country) {
        return repo.save(country);
    }

    public void deleteCountry(String code) {
        repo.deleteById(code);
    }

    public List<Country> searchByPartialName(String partialName) {
        return repo.findByCoNameContainingIgnoreCase(partialName);
    }
}
