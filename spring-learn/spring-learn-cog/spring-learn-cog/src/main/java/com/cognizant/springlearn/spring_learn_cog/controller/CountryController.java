package com.cognizant.springlearn.spring_learn_cog.controller;

import com.cognizant.springlearn.spring_learn_cog.model.Country;
import com.cognizant.springlearn.spring_learn_cog.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        return countryService.getCountry(code.toUpperCase());
    }
}
