package com.mycompany.lab5.controllers;
import com.mycompany.lab5.repositories.ZadanieRepository;
import com.mycompany.lab5.entities.Zadanie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
    
   @Autowired
   public ZadanieRepository rep;
    
    @RequestMapping("/")
    @ResponseBody
    public String mainPage() {
        return "Hello Spring Boot from mainPage() method!";
    }
    @RequestMapping("/hello")
    @ResponseBody
    public String pageTwo() {
        return "Hello Spring Boot from pageTwo() method!";
    }
    
    @RequestMapping("/listaZadan")
    @ResponseBody
    public String listaZadan() {
        StringBuilder odp = new StringBuilder();
        Zadanie zadanie = new Zadanie();
        //korzystając z obiektu repozytorium zapisujemy zadanie do bazy
        rep.save(zadanie);
       

        Zadanie z;
        double k=1000;
        boolean wyk=false;
        for (int i=1;i<=10;i++){
            z = new Zadanie();
            z.setNazwa("zadanie "+i);
            z.setOpis("Opis czynnosci do wykonania w zadaniu "+i);
            z.setKoszt(k);
            z.setWykonane(wyk);
            wyk=!wyk;
            k+=200.50;
            rep.save(z);
        } 
        
        //korzystając z repozytorium pobieramy wszystkie zadania z bazy
        for(Zadanie i: rep.findAll()) {
        odp.append(i).append("<br>");
        }
        return odp.toString();
    } 
    
    @RequestMapping("/listaZadanHurtowo")
    @ResponseBody
    public String listaZadanHurtowo() {
        
        StringBuilder odp = new StringBuilder();
       
        Zadanie z;
        double k=1000;
        boolean wyk=false;
        for (int i=1;i<=10;i++){
            z = new Zadanie();
            z.setNazwa("zadanie "+i);
            z.setOpis("Opis czynnosci do wykonania w zadaniu "+i);
            z.setKoszt(k);
            z.setWykonane(wyk);
            wyk=!wyk;
            k+=200.50;
            rep.save(z);
        } 
        
        //korzystając z repozytorium pobieramy wszystkie zadania z bazy
        for(Zadanie i: rep.findAll()) {
        odp.append(i).append("<br>");
        }
        return odp.toString();
    } 
    
    
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable("id") long id) {
        rep.deleteById(id);
    } 
    
    @RequestMapping("/wykonane/{wyk}")
    @ResponseBody
    public String wykonane(@PathVariable("wyk") boolean wyk) {
          StringBuilder odp = new StringBuilder();
       
        for(Zadanie i: rep.findByWykonane(wyk)) {
        odp.append(i).append("<br>");
        }
       
        return odp.toString();
    }
    
    @RequestMapping("/koszt/{max}")
    @ResponseBody
    public String koszt(@PathVariable("max") double max) {
          StringBuilder odp = new StringBuilder();
       
        for(Zadanie i: rep.findByKosztLessThan(max)) {
            odp.append(i).append("<br>");
        }
       
        return odp.toString();
    }
    
    @RequestMapping("/koszt/{min}/{max}")
    @ResponseBody
    public String koszt2(@PathVariable("min") double min ,@PathVariable("max") double max) {
          StringBuilder odp = new StringBuilder();
       
        for(Zadanie i: rep.findByKosztBetween(min, max)) {
            odp.append(i).append("<br>");
        }
       
        return odp.toString();
    }
    
} 