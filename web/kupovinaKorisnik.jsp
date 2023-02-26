<%-- 
    Document   : kupovinaKorisnik
    Created on : Feb 21, 2023, 10:28:15 AM
    Author     : Aca
--%>


<%@page import="modelBean_ovi.KorpaStavkaBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelBean_ovi.korisnik"%>
<%@page import="modelBean_ovi.proizvodBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>kupovina i podaci korisnika</title>
    </head>
    <body>
      
        
         <% 
         
     //   korisnik trenutno_ulogovani= (korisnik)request.getAttribute("trenutno_ulogovani");  
         %>
        <% ArrayList<proizvodBean> listaProizvoda= (ArrayList<proizvodBean>)request.getAttribute("listaProizvoda");       %>
        
        <% HttpSession sesija=request.getSession();
       
        korisnik trenutno_ulogovaniNalog=(korisnik)sesija.getAttribute("trenutno_ulogovani");  
        ArrayList<KorpaStavkaBean>korpa=(ArrayList<KorpaStavkaBean>)sesija.getAttribute("korpa");
        ArrayList<proizvodBean> listaProizvodaSvihSesija= (ArrayList<proizvodBean>)sesija.getAttribute("listaProizvoda"); 

        // korisnik trenutno_ulogovaniNalogZaKorpu = (korisnik)sesija.setAttribute("trenutno_ulogovaniNalogZaKorpu");
%>
         
        <h1> podaci ulogovanog korisnika </h1>
        <table>
            <tr>
                 <th> id </th>
                <th> ime </th>
                <th> lozinka </th>
            </tr>
            <%--ovaj deo ces obrisati/staviti u neku drugu stranicu kad doradis posle jos--%>
            
            
            <%-- pokusaj ipak da dovuces celu listu, pa da onda ovde odradis for petlju gde proverava je li to taj,pa ga onda teraj dalje--%>
             <% korisnik pom = trenutno_ulogovaniNalog;%>
            <tr>   
                <%--odraditi preko expression language-a  takodje--%>
                <th> <%=  pom.getId()%> </th>
                <th> <%= pom.getIme()%>   </th>
                <th> <%= pom.getLozinka()%> <%--{lozinka}--%></th>
            </tr>
            <!-- Vidi naruci.jsp i kupiservlet sta si ranije pokusavao,iz ketering projekta,pa iskoristi ovde -->
            
            
        </table>  
            
          
            
            <div>
                                            <%for(proizvodBean ln:listaProizvoda){%>
                                             <div class="col-md-5">
                                                 <div class="thumbnail" style="background-color: rgba(245, 225, 235, 0.7);  padding: 40px; border: 3px solid lightblue; margin-top: 10px;">
                                                    <h4><%= ln.getNaziv()%></h4>
                                                   <div class="caption">
                                                        <p><%=ln.getCena()%></p>
                                                    <div class="caption">
                                                        <p><%=ln.getOpis()%></p>
                                                        <form action="KorpaServletKontroler" method="post">
                                                            <input type="number" name="kol" min="1" max="10" value="1"><input type="hidden" name="id" value="<%= ln.getId() %>"><br>
                                                            <input type="submit" value="Dodaj u korpu">
                                                        </form>
                                                    </div>
                                                </div>
                                             </div> 
                                            <%}%>        
                                        </div>
            </div>
            <br>
             
              <!-- <a href="kupovinaProizvoda.jsp" > Kliknite ovde radi narucivanja slatkog i slanog programa </a> -->
            
            
            <br>
             <a href="index.jsp" > Povratak na pocetnu stranu </a>
    </body>
</html>
