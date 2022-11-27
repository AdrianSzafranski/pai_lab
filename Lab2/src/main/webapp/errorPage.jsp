<%-- 
    Document   : errorPage
    Created on : 18 paź 2022, 11:33:06
    Author     : Adrian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"
%>
<!DOCTYPE html>
<html>
    <head>...</head>
    <body>
        <h2>Wprowadzono błędne dane!</h2>
        <p>Pojawił się następujący błąd:
        <%= exception.getMessage() %>. <br />
        </p>
    </body>
</html>