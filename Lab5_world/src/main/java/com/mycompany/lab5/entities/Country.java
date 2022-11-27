
package com.mycompany.lab5.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "country")
public class Country{
    
    @Id
    private String code;
    
    @Column
    private String name;

    @Column
    private String continent;
 
    @Column
    private long population;
    
    @Column
    private double surfaceArea;
    
    //nadpisana metoda toString
    @Override
    public String toString() {
        return "Encja Country{ kod=" + code + ", nazwa=" + name + ", kontynent=" +
        continent + ", populacja=" + population + ", powierzchnia=" + surfaceArea +
        "}";
    }
    //dodaj metody get i set

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public long getPopulation() {
        return population;
    }

    public double getSurfacearea() {
        return surfaceArea;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public void setSurfacearea(double surfacearea) {
        this.surfaceArea = surfacearea;
    }

    
    
}