package com.country.springcountry.model;

public class Country {
    private String code;
    private String name;

    public Country() {
        System.out.println("Inside Country Constructor");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        System.out.println("Setter for code called");
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Setter for name called");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
