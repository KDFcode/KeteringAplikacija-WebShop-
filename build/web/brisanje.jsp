<%-- 
    Document   : brisanje
    Created on : Feb 21, 2023, 2:23:59 AM
    Author     : Aca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form action="BrisanjeServlet" method="post"> <!-- ime metode, vrsta get/post metode -->
        <pre>
        
        <input type="text" name="id" placeholder="unesite id korisnika"/>
        <!-- inace ovde hoces da imas i mozda username,nesto nesto itd. ali sustinski samo id je dovoljan -->
        <br>
        <input type="submit" value="obrisi korisnika"/>
        </pre>
        </form>
    </body>
</html>
