package com.example.springbootcountryservice.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Country")
public class Country {
    @Id
    @Column(name = "id")
    int id;
    @Column(name = "countryName")
    String countryName;
    @Column(name = "capital")
    String capital;

    public Country(int id, String countryName, String capital) {
        this.id = id;
        this.countryName = countryName;
        this.capital = capital;
    }

    public Country() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
