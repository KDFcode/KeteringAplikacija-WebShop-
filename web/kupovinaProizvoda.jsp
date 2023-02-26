<%-- 
    Document   : kupovinaProizvoda
    Created on : Feb 21, 2023, 12:31:04 PM
    Author     : Aca
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelBean_ovi.korisnik"%>
<%@page import="modelBean_ovi.proizvodBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista proizvoda</title>
    </head>
    <body>
        <% korisnik trenutno_ulogovani= (korisnik)request.getAttribute("trenutno_ulogovani");       %>
        <% ArrayList<proizvodBean> listaProizvoda= (ArrayList<proizvodBean>)request.getAttribute("listaProizvoda");       %>
        
        
        <h1> nasa lista proizvoda </h1>
        <table> 
            
            <tr>
                 <th> id </th>
                <th> naziv </th>
                <th> opis </th>
                <th> cena </th>
            </tr>
             <!-- ovde posle uzmi da ti lista automatski sve proizvode //odradi to u loginservletu ako treba //da ti salje kao parametar listu-->
            <% for (proizvodBean pom2:listaProizvoda) {%>
            <tr>   
                 <!-- odraditi preko expression language prica {naziv},{opis} itd. umesto pom.getNaziv() itd.-->
                 <!-- vidi vezba za ispit korisnik konto toga-->
                <th> <%= pom2.getId()%> </th>
                <th> <%= pom2.getNaziv()%>   </th>
                <th> <%= pom2.getOpis()%> </th>
                <th> <%= pom2.getCena()%> </th>
            </tr>
            <% //} %>
            <tr>
                <td colspan="4">
                    <a href="index.jsp" > Povratak na pocetnu stranu </a>
                </td>
            </tr>
        </table>  
    </body>
</html>
