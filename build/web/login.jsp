<%-- 
    Document   : login
    Created on : Feb 21, 2023, 9:21:41 AM
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
         <form action="loginServletKontroler" method="post"> <!-- ime metode, vrsta get/post metode -->
        <pre>
        <input type="text" name="uname" placeholder="unesite svoje korisnicko ime"/>
        <br>
        
        <input type="text" name="upassword" placeholder="unesite svoju lozinku"/>
        <br>
        <br>
        <input type="submit" value="insert"/>
        </pre>
        </form>
        
        
        
        <a href="index.jsp"> kliknite ovde za pocetnu stranicu</a> 
    </body>
</html>
