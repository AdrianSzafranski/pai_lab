package com.mycompany.lab5.controllers;
import com.mycompany.lab5.repositories.CountryRepository;
import com.mycompany.lab5.entities.Country;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
    
   @Autowired
   public CountryRepository rep;
    
    @RequestMapping("/")
    @ResponseBody
    public String listaPanstw() {
       
        StringBuilder odp = new StringBuilder();
        
        //korzystając z repozytorium pobieramy wszystkie zadania z bazy
        for(Country i: rep.findAll()) {
            odp.append(i).append("<br>");
        }
        return odp.toString();
    } 

    @RequestMapping("/kontynent/{continent}")
    @ResponseBody
    public String wykonane(@PathVariable("continent") String continent) {
          StringBuilder odp = new StringBuilder();
       
        for(Country i: rep.findByContinent(continent)) {
            odp.append(i).append("<br>");
        }
       
        return odp.toString();
    }
    
    
    @RequestMapping("/populacja/{min}/{max}")
    @ResponseBody
    public String populacja(@PathVariable("min") long min ,@PathVariable("max") long max) {
          StringBuilder odp = new StringBuilder();
       
        for(Country i: rep.findByPopulationBetween(min, max)) {
            odp.append(i).append("<br>");
        }
       
        return odp.toString();
    }
    
    @RequestMapping("/kontynent/{continent}/powierzchnia/{min}/{max}")
    @ResponseBody
    public String powierzchnia(@PathVariable("continent") String continent, @PathVariable("min") double min ,@PathVariable("max") double max) {
          StringBuilder odp = new StringBuilder();
       
        for(Country i: rep.findByContinentAndSurfaceAreaBetween(continent, min, max)) {
            odp.append(i).append("<br>");
        }
       
        return odp.toString();
    }
    
} 