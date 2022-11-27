<%-- 
    Document   : calc
    Created on : 17 paź 2022, 12:27:28
    Author     : student
--%>

<%@page import="java.text.DecimalFormat"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        String date = dateFormat.format(now);
        // skorzystanie z predefiniowanego obiektu strumienia out,
        // znanego z serwletów:
        %>
        <%= date %>
        <h1>Kalkulator rat</h1>
        <form method="post" action="calc.jsp">
            Kwota pożyczki: <input name='kwota' type="text" /><br />
            Procent roczny: <input name='procent' type="text" /><br />
            Liczba rat:  <input name='liczbaRat' type="text" /><br />
            <input type="submit" name="wyslij" value="wyslano" /><br />
            Rata miesięczna: 
        </form>
        <% if (request.getParameter("wyslij")!=null){
                String res="";
                String kwota = request.getParameter("kwota");
                String procent = request.getParameter("procent");
                String liczbaRat = request.getParameter("liczbaRat");
                double k, p, lr;
                
                
                 if ((kwota == null) || (kwota.trim().equals("")) || (procent == null) || (procent.trim().equals("")) || (liczbaRat == null) || (liczbaRat.trim().equals(""))) {
                    res = "Uzupełnij wszystkie pola!";
                 } 
                 else {
                    
                    try {
                         k = Double.parseDouble(request.getParameter("kwota"));
                         p = Double.parseDouble(request.getParameter("procent"));
                         lr = Integer.parseInt(request.getParameter("liczbaRat"));

                        if(k <= 0 || p <= 0 || lr <=0) {
                            res = "Dane muszą być większe od zera!";
                        }
                        else {
                         
                            double rata = (k*(p/1200))/(1 - (1/Math.pow((1+p/1200),lr)));
                            DecimalFormat df = new DecimalFormat("#.00");
                            res = df.format(rata);
                        }
                    }
                    catch (Exception ex) { 
                        res = "Wszystkie dane muszą być liczbami!";
                    }
                }
                
                out.println(res);
                }
               
                  
           %>
    </body>
</html>
