package com.example.springbootcountryservice.controller;

import com.example.springbootcountryservice.beans.Country;
import com.example.springbootcountryservice.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {
    @Autowired
    CountryService countryService;

    @GetMapping("/getcountries")
    public List<Country> getCountries(){
       return countryService.getAllCountries();

    }
    @GetMapping("/getcountries/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable(value="id") int id){
        try {
            Country country = countryService.getCountrybyId(id);
            return new ResponseEntity<Country>(country, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getCountries/countryName")
    public ResponseEntity<Country>  getCountryByName(@RequestParam(value = "countryName") String countryName){
        try {
            Country country = countryService.getCountrybyName(countryName);
            return new ResponseEntity<Country>(country, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addCountry")
    public Country addCountry(@RequestBody Country country){
        return countryService.addCountry(country);
    }

    @PutMapping("/updateCountry/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable(value = "id") int id,@RequestBody Country country){
        try {
            Country existCountry =  countryService.getCountrybyId(id);
            existCountry.setCapital(country.getCapital());
            existCountry.setCountryName(country.getCountryName());
            Country updated_country = countryService.updateCountry(existCountry);
            return new ResponseEntity<Country>(updated_country, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }


    }
    @DeleteMapping("/deleteCountry/{id}")
    public AddResponse deleteCountry(@PathVariable int id){
        return countryService.deleteCountry(id);
    }





}
