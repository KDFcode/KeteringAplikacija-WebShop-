/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelBean_ovi.KorpaStavkaBean;
import modelBean_ovi.korisnik;
import modelBean_ovi.proizvodBean;

/**
 *
 * @author Aca
 */
public class KorpaServletKontroler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String remove = req.getParameter("remove");
        if (remove != null && remove.equals("all")) {
            HttpSession sesija = req.getSession();
            sesija.setAttribute("lista_stvari_u_korpi", new ArrayList<KorpaStavkaBean>());
            resp.sendRedirect("korpa.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        HttpSession sesija = request.getSession();
        ArrayList<KorpaStavkaBean> lista_stvari_u_korpi = (ArrayList<KorpaStavkaBean>) sesija.getAttribute("lista_stvari_u_korpi");
        
        korisnik trenutnoUlogovaniKupac = (korisnik)sesija.getAttribute("trenutno_ulogovani");
//on ga ovde pokupi lepo kao korisnik-a trenutno_ulogovani	
//modelBean_ovi.korisnik@1aa8f461	Edit...
        String korisnicko_ime_kupca=""+trenutnoUlogovaniKupac.getIme();  
//ovde puca??? zasto?
        
        if (lista_stvari_u_korpi == null) {
            lista_stvari_u_korpi = new ArrayList<KorpaStavkaBean>();
        }
        proizvodBean proizvod = null;
        Connection connection = null;
        Statement stm = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");  
            stm=connection.createStatement();
        }
        catch (Exception ex) {
            request.setAttribute("msg", "Greska prilikom povezivanja sa bazom");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        String id = request.getParameter("id");
        String kolicina = request.getParameter("kol");
        int kolicina_ove_stavke_u_korpi = -1;
        try {
           kolicina_ove_stavke_u_korpi = Integer.parseInt(kolicina);
            String query = "SELECT * FROM `proizvod2` WHERE `id`=" + id;
            ResultSet res = stm.executeQuery(query);
            if (res.next()) {
                proizvod = new proizvodBean(
                    res.getInt("id"),
                    res.getString("naziv"),
                    res.getString("opis"),
                    res.getInt("cena"),
                    res.getString("tip_programa")
                );
               proizvodBean proizvod_stavke_korpe=proizvod;
                
                int idProizvoda=proizvod.getId();
              int  cena=proizvod.getCena();
              String  naziv_proizvoda=proizvod.getNaziv();
                
                if (proizvod != null && kolicina_ove_stavke_u_korpi > 0) { //odavde skace na ovaj prvi else,tu mu nailazi greska jelte
                KorpaStavkaBean stavka = new KorpaStavkaBean(
                        idProizvoda,
                        cena,
                        kolicina_ove_stavke_u_korpi,
                        naziv_proizvoda,
                        korisnicko_ime_kupca,
                        proizvod_stavke_korpe
                );
                lista_stvari_u_korpi.add(stavka);
                sesija.setAttribute("lista_stvari_u_korpi", lista_stvari_u_korpi);
                response.sendRedirect("korpa.jsp");
            }
            else {
                request.setAttribute("msg", "Greska prilikom popunjavanja informacija");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
            }
            else {
                request.setAttribute("msg", "Proizvod ne postoji");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
           
            
            
        }
        catch (SQLException ex) {
            request.setAttribute("msg", "Greska prilikom konekcije s  bazo" + ex.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        catch (NumberFormatException et) {
            request.setAttribute("msg", "Greska pri prebacivanju iz formata u format");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

@Override
    public String getServletInfo() {
        return "Servlet za punjenje i praznjenje korpe korisnika";
    }// </editor-fold>

}
