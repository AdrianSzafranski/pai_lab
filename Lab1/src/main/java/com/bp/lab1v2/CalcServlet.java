/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.bp.lab1v2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author student
 */
@WebServlet(name = "CalcServlet", urlPatterns = {"/CalcServlet"})
public class CalcServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String wynik = oblicz(request);
        
         HttpSession sesja = request.getSession(true);
         ArrayList<String> historia = (ArrayList) sesja.getAttribute("historia");
            
         String czyszczenie = request.getParameter("par");
         boolean czyWyczyszczono = false;
      
        if ( !(czyszczenie == null) && !(czyszczenie.trim().equals("") )) {
            sesja.invalidate();
            czyWyczyszczono = true;
        }
        else {
        
            if (historia==null) { //nie ma szukanego obiektu w sesji
                historia = new ArrayList();
                sesja.setAttribute("historia",historia);
            } 
        
            historia.add(wynik);
            sesja.setAttribute("historia", historia);
        }
        
       String nazwaCookie = "UserId";
       boolean pierwszaWizyta = true;
       Cookie [ ] cookies = request.getCookies();
       if ( cookies != null ){ 
            for (int i=0; i<cookies.length; i++) {
                Cookie c=cookies[i];
                if (nazwaCookie.equals(c.getName())) {
                    pierwszaWizyta = false;
                    break;
                }
            }
        }
       
       if(pierwszaWizyta) {
           Cookie c = new Cookie(nazwaCookie, "1");
           response.addCookie(c);
       }
        
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //oblicz(request);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalcServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            if(pierwszaWizyta) {
                out.println("<h2>Witaj po raz pierwszy</h2>");
            }
            else {
                 out.println("<h2>Witaj po raz kolejny</h2>");
            }
            out.println("<a href='index.html'>Powrót do formularza</a>");
            out.println("<a href='?par=wyczysc'>Wyczyść historię sesji.</a>");
            if(!czyWyczyszczono) {
                out.println("<h1>Wynik obliczeń:</h1>");
                out.println("<p>" + wynik + "</p>");
                out.println("<h1>Historia obliczeń sesji:</h1>");
            
                for(String w : historia) {
                 out.println("<p>" + w + "</p>");
                }
            } else {
                 out.println("<h1>Historia sesji wyczyszczona!</h1>");
            }
            out.println("</body>");
            out.println("</html>");
            
           
                    }
                }
    
    protected String oblicz(HttpServletRequest request) {
        
        String tekstowaLiczba1 = request.getParameter("liczba1");
        String tekstowaLiczba2 = request.getParameter("liczba2"); 
        float liczba1, liczba2;
        String dzialanie = request.getParameter("dzialanie");
        
        String w = walidacja("Pierwsza", tekstowaLiczba1);
        if(w.equals("poprawna")) {
           liczba1 = Float.parseFloat(tekstowaLiczba1);
        } else {
            return w;
        }
        
        w = walidacja("Druga", tekstowaLiczba2);
        if(w.equals("poprawna")) {
           liczba2 =  Float.parseFloat(tekstowaLiczba2);
        } else {
            return w;
        }
       
        String wynik = liczba1 + " " + dzialanie + " " + liczba2 + " = ";
        
        switch(dzialanie) {
            case "+": 
                wynik += String.valueOf(liczba1 + liczba2);
                break;
            case "-":
                wynik += String.valueOf(liczba1 - liczba2);
                 break;
            case "*":
                wynik += String.valueOf(liczba1 * liczba2);
                break;
            case "/": {
                if (liczba2 == 0) {
                    return "Nie dzielimy przez 0!";
                }
                else {
                    wynik += String.valueOf(liczba1 / liczba2);
                }
                break;
            }
            default:
                return "Coś poszło nie tak. Nawet twórca nie wie co!";
        }
     
        return wynik;
    }
    
    protected String walidacja(String ktoraLiczba, String tekstowaLiczba) {
        
        if ((tekstowaLiczba == null) || (tekstowaLiczba.trim().equals(""))) {
            return ktoraLiczba + " wartość nie została podana!";
        } 
        
        try {
           Float.parseFloat(tekstowaLiczba);
        } catch(NumberFormatException pe) {
            return ktoraLiczba + " wartość nie jest liczbą!";
        }
        
        return "poprawna";
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       processRequest(request, response);
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
