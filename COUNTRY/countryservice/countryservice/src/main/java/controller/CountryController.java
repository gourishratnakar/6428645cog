package com.example.countryservice.controller;

import com.example.countryservice.model.Country;
import com.example.countryservice.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping("/{code}")
    public Country getByCode(@PathVariable String code) {
        return service.getCountryByCode(code).orElse(null);
    }

    @PostMapping
    public Country add(@RequestBody Country country) {
        return service.addCountry(country);
    }

    @PutMapping
    public Country update(@RequestBody Country country) {
        return service.updateCountry(country);
    }

    @DeleteMapping("/{code}")
    public void delete(@PathVariable String code) {
        service.deleteCountry(code);
    }

    @GetMapping("/search")
    public List<Country> search(@RequestParam String name) {
        return service.searchByPartialName(name);
    }
}
