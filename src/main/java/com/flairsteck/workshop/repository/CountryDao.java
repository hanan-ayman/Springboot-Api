/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flairsteck.workshop.repository;

import com.flairsteck.workshop.exception.DBDownException;
import com.flairsteck.workshop.model.Country;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author hanan.ayman
 */
@Component
public class CountryDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CountryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Country getAllCountryInfoByCode(String code) {
        return jdbcTemplate.query("SELECT c.Code, c.name, c.continent, c.population, c.LifeExpectancy, cl.Language FROM world.country c "
                + "inner join  world.countrylanguage cl "
                + "on c.Code = cl.CountryCode "
                + "and cl.IsOfficial='T' Where c.Code ='" + code + "'",
                (ResultSet rs) -> {
                    Country c = null;
                    try {
                        while (rs.next()) {
                            c = new Country();
                            c.setName(rs.getString("name"));
                            c.setContinent(rs.getString("continent"));
                            c.setPopulation(rs.getInt("population"));
                            c.setLife_expectancy(rs.getInt("LifeExpectancy"));
                            c.setCountry_language(rs.getString("Language"));
                        }
                    } catch (SQLException ex) {
                        throw new DBDownException(ex.getMessage());
                    }
                    return c;
                });
    }
}
