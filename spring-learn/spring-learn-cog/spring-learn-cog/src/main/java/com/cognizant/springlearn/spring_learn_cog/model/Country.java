package com.cognizant.springlearn.spring_learn_cog.model;

import java.io.Serializable;

public class Country implements Serializable {
    private String code;
    private String name;

    // Default Constructor (required for Spring XML and Jackson)
    public Country() {}

    // Parameterized Constructor (optional but useful for testing)
    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Getters and Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Optional: toString() for easier logging/debugging
    @Override
    public String toString() {
        return "Country{code='" + code + "', name='" + name + "'}";
    }
}
