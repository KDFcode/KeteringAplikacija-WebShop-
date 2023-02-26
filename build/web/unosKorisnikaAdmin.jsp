<%-- 
    Document   : unosKorisnikaAdmin
    Created on : Feb 21, 2023, 9:20:49 AM
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
       <form action="loginServlet2" method="post"> <!-- ime metode, vrsta get/post metode -->
        <pre>
        <input type="text" name="id" placeholder="id korisnika"/>
        <br>
        <input type="text" name="uname" placeholder="username"/>
        <br>
        
        <input type="text" name="upassword" placeholder="password"/>
        <br>
        <br>
        <input type="submit" value="insert"/>
        </pre>
        </form>
        
        
        <a href="login.jsp"> kliknite ovde za login</a>
        <a href="index.jsp"> kliknite ovde za pocetnu stranicu</a> 
    </body>
</html>
