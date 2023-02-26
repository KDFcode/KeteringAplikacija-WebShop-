<%-- 
    Document   : izvestaj_O_Kupovini
    Created on : Feb 21, 2023, 2:35:38 PM
    Author     : Aca
--%>

<%@page import="modelBean_ovi.korisnik"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>izvestaj o kupovini</title>
    </head>
    <body>
      <%
            HttpSession sesija = request.getSession();
            korisnik nalog = (korisnik) sesija.getAttribute("nalog");
      
            Double cena = (Double) request.getAttribute("cena");
        
            Integer ID_narudzbine = (Integer) request.getAttribute("ID_narudzbine");
        %>
        <div class="text-right" style="color: orange;">
        <h1>Uspesno porucivanje</h1>
        <p>Broj narudzbine: <%= ID_narudzbine %></p>
        <p>Cena narudzbine: <%= cena %> dinara</p>
        <p><a href="index.jsp"><button type="button" id="dugme_forma" class="btn" style="background-color: lightcoral">Nazad na pocetnu</button></a></p>
        </div>
    </body>
</html>
