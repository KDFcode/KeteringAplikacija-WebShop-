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

/**
 *
 * @author Aca
 */
public class KupovinaServlet extends HttpServlet {

    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
         
        HttpSession sesija = request.getSession();
        
        
        ArrayList<KorpaStavkaBean> lista_stvari_u_korpi = (ArrayList<KorpaStavkaBean>) sesija.getAttribute("lista_stvari_u_korpi");
        korisnik trenutno_ulogovani = (korisnik) sesija.getAttribute("trenutno_ulogovani");
        ResultSet rs; 
        
        int cena=0;
        int idNaru= trenutno_ulogovani.getId();
        String ime_kupca= trenutno_ulogovani.getIme();
        String lista_proizvoda="";
        for(KorpaStavkaBean korpa_stavka :lista_stvari_u_korpi)
        {
        cena= cena+korpa_stavka.getUkupnaCena();
        lista_proizvoda=lista_proizvoda+korpa_stavka.getNaziv_proizvoda();
        
        }
         String dbUrl="jdbc:mysql://localhost:3306/mydb",
                user="root", 
                pass="";
            
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
           Connection con= DriverManager.getConnection(dbUrl,user,pass);  
           String upit = "INSERT INTO `narudzbina_proizvod`(`idNaru`, `ukupna_cena`, `lista_proizvoda`, `korisnicko_ime_kupca`) VALUES (" + idNaru + "," + cena  + "," + lista_proizvoda + "," + ime_kupca + ")";
                        
            Statement st=con.createStatement() ; 
            rs=st.executeQuery(upit); //sredi poeni pricu naknadno
            
         
            //vidi da ubacis poene u korisnik bean i onda ovo odradis kako treba
                sesija.setAttribute("lista_stvari_u_korpi", new ArrayList<KorpaStavkaBean>());
                request.setAttribute("cena", cena);
                request.setAttribute("ID_narudzbine", idNaru);
                request.getRequestDispatcher("izvestaj_O_Kupovini.jsp").forward(request, response);
            }
        catch (SQLException ex) {
            request.setAttribute("msg", "Greska prilikom konekcije s  bazom" + ex.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
            
        catch (Exception ex) {
            request.setAttribute("msg", ex.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
     }
     
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { processRequest(request, response);
    }

    
    
    @Override
    public String getServletInfo() {
        return "Servlet za izvrsavanje kupovine od strane korisnika";
    }// </editor-fold>
}
