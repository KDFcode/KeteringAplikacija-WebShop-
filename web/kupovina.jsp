<%-- 
    Document   : kupovina
    Created on : Feb 21, 2023, 9:33:29 AM
    Author     : Aca
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelBean_ovi.korisnik"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
     <%-- <% //ArrayList<korisnik> lista= (ArrayList<korisnik>)request.getAttribute("lista");       %>  --%> 
    <!-- uzmi posle sredi sesije i uloge pa ubaci ovde da ti to prenosi-->
    
    trenutno_ulogovani
    <body>
         
        <% ArrayList<korisnik> listaUlogovan= (ArrayList<korisnik>)request.getAttribute("listaUlogovan");       %>
        
        <h1> podaci ulogovanog korisnika </h1>
        <table>
            <tr>
                 <th> id </th>
                <th> ime </th>
                <th> lozinka </th>
            </tr>
            <%--ovaj deo ces obrisati/staviti u neku drugu stranicu kad doradis posle jos--%>
            
            
            <%-- pokusaj ipak da dovuces celu listu, pa da onda ovde odradis for petlju gde proverava je li to taj,pa ga onda teraj dalje--%>
             <% for (korisnik pom:listaUlogovan) {%>
            <tr>   
                <%--odraditi preko expression language-a  takodje--%>
                <th> <%=  pom.getId()%> </th>
                <th> <%= pom.getIme()%>   </th>
                <th> <%= pom.getLozinka()%> <%--{lozinka}--%></th>
            </tr>
            <% } %>
        </table>  
            
            <%--<h1> nasa lista proizvoda </h1>
        <table> 
            
            <tr>
                 <th> id </th>
                <th> naziv </th>
                <th> opis </th>
                <th> cena </th>
            </tr>
             <!-- ovde posle uzmi da ti lista automatski sve proizvode //odradi to u loginservletu ako treba //da ti salje kao parametar listu-->
            <% //for (korisnik pom:lista) {%>
            <tr>   
                 <!-- odraditi preko expression language prica {naziv},{opis} itd. umesto pom.getNaziv() itd.-->
                <th> <%=// pom.getId()%> </th>
                <th> <%= //pom.getNaziv()%>   </th>
                <th> <%= //pom.getOpis()%> </th>
                <th> <%= //pom.getCena()%> </th>
            </tr>
            <% //} %>
            <tr>
                <td colspan="4">
                    <a href="index.jsp" > Povratak na pocetnu stranu </a>
                </td>
            </tr>
        </table>  --%>
           <%--   <%@page import="java.util.ArrayList"%>
<%@page import="modelBean_ovi.korisnik"%>
<%@page import="modelBean_ovi.proizvodBean"%>
              <% korisnik trenutno_ulogovani= (korisnik)request.getAttribute("trenutno_ulogovani");       %>
        <% ArrayList<proizvodBean> listaProizvoda= (ArrayList<proizvodBean>)request.getAttribute("listaProizvoda");       %>
           
           --%>
          <%--  <h1> nasa lista proizvoda </h1>
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
        </table>    --%>
            
            <br>
             <a href="index.jsp" > Povratak na pocetnu stranu </a>
     </body>
</html>
