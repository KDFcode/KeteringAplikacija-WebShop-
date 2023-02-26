<%-- 
    Document   : index
    Created on : Feb 21, 2023, 12:28:34 AM
    Author     : Aca
--%>

<%@page import="modelBean_ovi.korisnik"%>
<%-- --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>unos za korisnike</title>
    </head>
    <body>
        
       <% HttpSession sesija=request.getSession();
        korisnik trenutno_ulogovaniNalog=(korisnik)sesija.getAttribute("trenutno_ulogovani");  %>
        
        
      <%--  <form action="loginServlet2" method="post"> <!-- ime metode, vrsta get/post metode -->
        <pre>
        <input type="text" name="uname" placeholder="username"/>
        <br>
        
        <input type="text" name="upassword" placeholder="password"/>
        <br>
        <br>
        <input type="submit" value="insert"/>
        </pre>
        </form>  --%>
        
        
        <a href="login.jsp"> kliknite ovde za login</a>
        <br><br>
        <%
        if (trenutno_ulogovaniNalog != null) {
    %>
       <%--   <%if(nalog.getUloga().equals("admin")){%> --%>
      <br>
      
     <%-- <% if (trenutno_ulogovaniNalog.getUloga().equals("admin") { %>  --%>
        <a href="unosKorisnikaAdmin.jsp"> kliknite ovde za unos korisnika</a>
        <br>
        <br>
        <% } %>
        
       <%--  <% if (trenutno_ulogovaniNalog.getUloga().equals("menadzer") { %> --%>
        <a href="izmena.jsp"> kliknite ovde za izmenu korisnika</a>
        <br>
        
         <% } %>
        <br>
        <a href="brisanje.jsp"> kliknite ovde za brisanje korisnika</a>
        <br>
        <br>
       <%--   <%} else if(nalog.getUloga().equals("manager")){%> --%>
        <a href="pregledServlet"> kliknite ovde za pregled korisnika</a>
        
        <!-- ubaci i menadzerske opcije tipa izmena/dodavanje/brisanje proizvoda i narudzbenica -->
   
        <%
        }
    %>
            <%-- uzmi posle ispomeraj ove linkove u messendzer/admin jsp-ove kad odradis ostale servlete lepo --%>

        
        
    </body>
</html>
