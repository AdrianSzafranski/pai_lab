/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4.beans;

/**
 *
 * @author student
 */
public class Pracownik {
    private int id;
    private String nazwisko;
    private float pensja;
    private String firma; 

    public int getId() {
        return id;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public float getPensja() {
        return pensja;
    }

    public String getFirma() {
        return firma;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setPensja(float pensja) {
        this.pensja = pensja;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }
    
    
    
}
