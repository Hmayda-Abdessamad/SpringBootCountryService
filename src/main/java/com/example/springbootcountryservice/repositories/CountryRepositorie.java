package com.example.springbootcountryservice.repositories;

import com.example.springbootcountryservice.beans.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepositorie extends JpaRepository<Country,Integer> {

}
