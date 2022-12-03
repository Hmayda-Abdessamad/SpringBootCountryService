package com.example.springbootcountryservice.services;

import com.example.springbootcountryservice.beans.Country;
import com.example.springbootcountryservice.controller.AddResponse;
import com.example.springbootcountryservice.repositories.CountryRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@Service
public class CountryService {
    @Autowired
    CountryRepositorie countryRepositorie;


    public List<Country> getAllCountries() {
        return  countryRepositorie.findAll();
    }

    public Country getCountrybyId(int id) {
        return countryRepositorie.findById(id).get();

    }

    public Country getCountrybyName(String name) {
        List<Country> countries = countryRepositorie.findAll();
        Country country = null;
        for (Country con :countries){
            if (con.getCountryName().equalsIgnoreCase(name)){
                country=con;
               }
        }
        return country;
    }
    public Country addCountry(Country country){
        country.setId(getMaxId());
        countryRepositorie.save(country);
        return country;
    }
    public int getMaxId(){
        return countryRepositorie.findAll().size()+1;

    }
    public Country updateCountry(Country country){
        countryRepositorie.save(country);
        return country;
    }
    public AddResponse deleteCountry(int id){
        countryRepositorie.deleteById(id);
        AddResponse res = new AddResponse();
        res.setId(id);
        res.setMsg("deleted succesfully");
        return res;
    }
}
