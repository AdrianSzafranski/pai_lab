<%-- 
    Document   : calcwithbean
    Created on : 17 paź 2022, 13:36:31
    Author     : student
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 
        <jsp:useBean id="loan" class="r.LoanBean" scope="session" />
        <jsp:setProperty name="loan" property="*" />
        <%= loan.getDate() %>
        <h1>Kalkulator rat</h1>
        <form method="post" action="calcwithbean.jsp">
            Kwota pożyczki: <input name='kwota' value="<%= loan.getKwota() %>" type="text" /><br />
            Procent roczny: <input name='pr' value="<%= loan.getPr() %>" type="text" /><br />
            Liczba rat:  <input name='nr' value="<%= loan.getNr() %>" type="text" /><br />
            <input type="submit" name="Wyślij" /><br />
            Rata miesięczna: <%= loan.getRata() %>
        </form>
    </body>
</html>
