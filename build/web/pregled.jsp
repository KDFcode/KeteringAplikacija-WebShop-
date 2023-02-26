<%-- 
    Document   : pregled
    Created on : Feb 21, 2023, 12:45:45 AM
    Author     : Aca
--%>

<%@page import="modelBean_ovi.korisnik"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>lista korisnika</title>
    </head>
    <body>
        <% ArrayList<korisnik> lista= (ArrayList<korisnik>)request.getAttribute("lista"); %>
        <h1> podaci o korisnicima </h1>
        <table>
            <tr>
                 <th> id </th>
                <th> ime </th>
                <th> lozinka </th>
            </tr>
            
            <% for (korisnik pom:lista) {%>
            <tr>   
                <%--odraditi preko useBean prica--%>
                <th> <%= pom.getId()%> </th>
                <th> <%= pom.getIme()%>  <%--{ime}  ako radimo s ovime  ne treba nam ovo arraylist prvi izraz <% %> tipa --%> </th>
                <th> <%= pom.getLozinka()%> <%--{lozinka}--%></th>
            </tr>
            <% } %>
            <tr>
                <td colspan="4">
                    <a href="index.jsp" > Povratak na pocetnu stranu </a>
                </td>
            </tr>
        </table>
        
    </body>
</html>
