/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flairsteck.workshop.model;

import lombok.Data;

/**
 *
 * @author hanan.ayman
 */

/*
    "name": "Bahrain" -> country
    "continent": "Asia" -> country
    "population":617000 -> country
    "life_expectancy":73 -> country
    "country_language":"Arabic" ->countrylanguage
 */
@Data
public class Country {

    String name;
    String continent;
    int population;
    int life_expectancy;
    String country_language;

    public Country() {
    }

    public Country(String name, String continent, int population, int life_expectancy, String country_language) {
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.life_expectancy = life_expectancy;
        this.country_language = country_language;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
    public String getCountry_language() {
        return country_language;
    }

    public void setCountry_language(String country_language) {
        this.country_language = country_language;
    }
    
}
