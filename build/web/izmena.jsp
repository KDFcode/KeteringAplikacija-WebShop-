<%-- 
    Document   : izmena
    Created on : Feb 21, 2023, 1:03:43 AM
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
        <form action="IzmenaServlet" method="post"> <!-- ime metode, vrsta get/post metode -->
        <pre>
        
        <input type="text" name="id" placeholder="unesite id korisnika"/>
        <br>
        <input type="text" name="staroIme" placeholder="trenutno korisnicko ime"/>
        <br>
        <input type="text" name="uname" placeholder="novo korisnicko ime"/>
        <br>
        <input type="text" name="upassword" placeholder="nova lozinka"/>
        <br>
        <br>
        <input type="submit" value="unesi izmenu"/>
        </pre>
        </form>
    </body>
</html>
