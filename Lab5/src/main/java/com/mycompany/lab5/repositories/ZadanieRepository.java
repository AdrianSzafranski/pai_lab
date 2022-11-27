package com.mycompany.lab5.repositories;
import com.mycompany.lab5.entities.Zadanie;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
public interface ZadanieRepository
 extends CrudRepository<Zadanie, Long>{
    
    List<Zadanie> findByWykonane(boolean wykonane);
    List<Zadanie> findByKosztLessThan(double max);
    List<Zadanie> findByKosztBetween(double min, double max);
} 
