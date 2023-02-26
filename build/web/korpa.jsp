<%-- 
    Document   : korpa
    Created on : Feb 21, 2023, 1:49:24 PM
    Author     : Aca
--%>

<%@page import="modelBean_ovi.KorpaStavkaBean"%>
<%@page import="modelBean_ovi.korisnik"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Korpa</title>
    </head>
    <%
        HttpSession sesija=request.getSession();
        ArrayList<KorpaStavkaBean>lista_stvari_u_korpi=(ArrayList<KorpaStavkaBean>)sesija.getAttribute("lista_stvari_u_korpi");
        korisnik noviKorisnik=new korisnik();
    %>
    <body  >
        <h1>Lista odabranih proizvoda</h1><br>
        <%
            String poruka=(String)request.getParameter("poruka");
            if(poruka!=null){
        %>
        <h3><%=poruka%></h3><br>
        <%}%>
        <%
            if(lista_stvari_u_korpi!=null && lista_stvari_u_korpi.size()>0){
        %>
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Naziv           </th>
                <th scope="col">Opis            </th> 
                <th scope="col">Cena            </th> 
                <th scope="col">Kolicina        </th> 
                <th scope="col">Ukupna cena     </th> 
                
            </tr>
            </thead>
            <%for(KorpaStavkaBean ln : lista_stvari_u_korpi){%>
            <tr>
                
                <td><%=ln.getProizvod_stavke_korpe().getNaziv()%>       </td>
                <td><%=ln.getProizvod_stavke_korpe().getOpis()%>        </td>
                <td><%=ln.getProizvod_stavke_korpe().getCena()%> dinara         </td>
                <td>x<%= ln.getKolicina() %>        </td>
                <td><%= ln.getProizvod_stavke_korpe().getCena() * ln.getKolicina() %>       </td>
                
            </tr>
            <%}%>
        </table>
        <%}else{%>
            <p>Vasa korpa je prazna</p>
        <%}%>    
            <a href="index.jsp"><button type="button" class="btn" style="background-color: green; margin-left: 40%; margin-top: 10%;">Kliknite ovde da se vratite na pocetnu stranicu</button></a>
            <a href="KorpaServletKontroler?remove=all"><button type="button" class="btn" style="background-color: green; margin-left: 2%; margin-top: 10%;">Uklonite proizvode</button></a>
            <a href="KupovinaServlet"><button type="button" class="btn" style="background-color: green; margin-left: 2%; margin-top: 10%;">Kliknite da kupite</button></a>
         
     </body>
</html>
