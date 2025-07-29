package com.cognizant.springlearn.spring_learn_cog.service;

import com.cognizant.springlearn.spring_learn_cog.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    public Country getCountry(String code) {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        // Convert code to lowercase or uppercase to match XML bean id
        return (Country) context.getBean(code.toLowerCase());
    }
}
