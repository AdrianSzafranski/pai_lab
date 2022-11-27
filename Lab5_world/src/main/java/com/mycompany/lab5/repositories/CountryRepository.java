package com.mycompany.lab5.repositories;
import com.mycompany.lab5.entities.Country;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
public interface CountryRepository
 extends CrudRepository<Country, String>{
    
    List<Country> findByContinent(String continent);
    List<Country> findByPopulationBetween(long min, long max);
    List<Country> findByContinentAndSurfaceAreaBetween(String continent, double min, double max);
} 
