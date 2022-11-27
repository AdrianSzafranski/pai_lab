/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.io.Serializable;

/**
 *
 * @author student
 */
public class CountryBean implements Serializable {
    private String code;
    private String name; 
    private String region; 
    private long population;
    private double surfacearea;
    

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    
    public long getPopulation() {
        return population;
    }

    public double getSurfacearea() {
        return surfacearea;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    
    

    public void setPopulation(long population) {
        this.population = population;
    }

    public void setSurfacearea(double surfacearea) {
        this.surfacearea = surfacearea;
    }
    
    
    
}
