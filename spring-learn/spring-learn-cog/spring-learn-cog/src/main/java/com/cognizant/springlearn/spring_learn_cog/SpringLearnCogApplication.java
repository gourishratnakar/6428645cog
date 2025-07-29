package com.cognizant.springlearn.spring_learn_cog;

import com.cognizant.springlearn.spring_learn_cog.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLearnCogApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country");
		System.out.println("Country Code: " + country.getCode());
		System.out.println("Country Name: " + country.getName());
	}
}
