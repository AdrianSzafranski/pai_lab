/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package r;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author student
 */
public class LoanBean implements Serializable{
    private double kwota = 1000;
    private double pr = 10;
    private int nr = 10;

    public double getKwota() {
        return kwota;
    }

    public double getPr() {
        return pr;
    }

    public int getNr() {
        return nr;
    }

    public void setKwota(double kwota) {
        this.kwota = kwota;
    }

    public void setPr(double pr) {
        this.pr = pr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }
    
    public String getRata() {
     
        if(kwota <= 0 || pr <= 0 || nr <=0) {
            return "Dane muszą być większe od zera!";
        } else {
            double rata = (kwota*(pr/1200))/(1 - (1/Math.pow((1+pr/1200),nr)));
            DecimalFormat df = new DecimalFormat("#.00");
            String rataf = df.format(rata);

            return rataf;
        }
    }
    
    public String getDate() {
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        String date = dateFormat.format(now);
        
        return date;
    }

}
