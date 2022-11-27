<%-- 
    Document   : countryList
    Created on : 24 paź 2022, 12:48:57
    Author     : student
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="backend.CountryBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Country List</h1>
      
        <%
            ArrayList<CountryBean> list = (ArrayList<CountryBean>)session.getAttribute("list");
            if(list == null) {
                out.println("Brak danych <br />");
            }
            else {
                out.println("<table>"
                + "<tr>"
                + "<th>Name</th>"
                + "<th>Code</th>"
                + "<th>Population</th>"
                + "</tr>");
                for(CountryBean country:list){
                    out.println("<tr><td>" + country.getName() + "</td>");
                    out.println("<td>" + country.getCode() + "</td>");
                    out.println("<td>" + country.getPopulation() + "</td>");
                    out.println("<td><a href='details.jsp?i=" + list.indexOf(country) + "'>Details</a></td></tr>");

                }
            }
        %>
        </table>
    </body>
</html>
