package com.flairsteck.workshop.controller;

/**
 *
 * @author hanan.ayman
 */
import com.flairsteck.workshop.exception.CodeNotFoundException;
import com.flairsteck.workshop.model.Country;
import com.flairsteck.workshop.repository.CountryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hanan.ayman
 */
@RestController
@RequestMapping("/")
public class webController{

    @Autowired
    private CountryDao countryDao;

    @GetMapping(path = "/{code}")
    public ResponseEntity<Country> getCountryInfo(@PathVariable("code") String code) throws CodeNotFoundException {

        Country country = countryDao.getAllCountryInfoByCode(code);
        if (country == null) {
           throw new CodeNotFoundException(code);
        } else {
            return ResponseEntity.ok().body(country);
        }

    }
}
