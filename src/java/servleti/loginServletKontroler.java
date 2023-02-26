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
import modelBean_ovi.korisnik;
import modelBean_ovi.proizvodBean;

/**
 *
 * @author Aca
 */
public class loginServletKontroler extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        String uname=request.getParameter("uname");
        String upass=request.getParameter("upassword"); 
            
        ResultSet rs;
            
        ArrayList<korisnik> lista= new ArrayList<>();
        HttpSession sesija=request.getSession();
        
        String dbUrl="jdbc:mysql://localhost:3306/mydb",
                user="root", 
                pass="";
       
        String upit="SELECT * FROM   user2; "; //pretvoriti u prepared statement
        //pazi za ove insert varijante da stavljas kraj zagrade i ;,jer izgleda to pravi probleme nekad
        
        //ovo moze i da se radi sa specificnim sql upitom koji trazi konkretne stvari iz tabele,ali ovako ne moze da ima SQL injection nikako
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con= DriverManager.getConnection(dbUrl,user,pass); 
            
            Statement st=con.createStatement() ; 
            rs=st.executeQuery(upit);
            
            while(rs.next())
                {
                lista.add(new korisnik(Integer.parseInt(rs.getString("id")),rs.getString("name"),rs.getString("pass")));  
                }
            int i=0;
            while(i<lista.size()) //zasto skace ovde stalno? //breakpoint problem?
            {
            if (lista.get(i).getIme().equals(uname)&& lista.get(i).getLozinka().equals(upass))
            {
            korisnik trenutno_ulogovani = new korisnik(lista.get(i).getId(),lista.get(i).getIme(),lista.get(i).getLozinka());
            
         //   ArrayList<korisnik> listaUlogovan= new ArrayList<>(); //ne mora ovako da se radi,ali moze //samo onda tamo u kupovini takodje kupis listu
          //  listaUlogovan.add(trenutno_ulogovani);
            //posle kad sve bude sljakalo stavi ovde da proverava tipa lista.get(i).getUloga() i dodaje onda i ulogu i da to proveris i mozes da koristis za dozvole
           //request.setAttribute("listaUlogovan", listaUlogovan);
            request.setAttribute("trenutno_ulogovani", trenutno_ulogovani);
             sesija.setAttribute("trenutno_ulogovani", trenutno_ulogovani);
            }
            i++;
            }
            
            
            
            {
            //nakon login-a samog napunimo takodje listu proizvoda koja moze da se onda ispise za kupovinu
            ArrayList<proizvodBean> listaProizvoda= new ArrayList<>();
            ResultSet rs2;
            String upit2="SELECT * FROM   proizvod2; ";
            Statement st2=con.createStatement() ; 
            rs2=st2.executeQuery(upit2);
            while(rs2.next())    //After end of result set -ta greska mi iskoci na prvi prolazak kroz listu proizvoda?
                {
                listaProizvoda.add(new proizvodBean(Integer.parseInt(rs2.getString("id")),rs2.getString("naziv"),rs2.getString("opis"),Integer.parseInt(rs2.getString("cena")),rs2.getString("tip_programa")));  
                }
           request.setAttribute("listaProizvoda", listaProizvoda);
            sesija.setAttribute("listaProizvoda", listaProizvoda);
            }
           
           
           
           // i onda odavde ide request dispatcher na admin/menadzer/kupovina stranicu
            }
        catch(ClassNotFoundException e) 
        {}
        catch(SQLException ex)
            {
            request.setAttribute("poruka", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
            }
         request.getRequestDispatcher("kupovinaKorisnik.jsp").forward(request,response); //sto ne nosi i id sa sobom nego samo ime i lozinku kad kupi sve i ima getere i setere za sve?
         //pa onda ovo ovde obrises
    }
        
    
 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    
    @Override
    public String getServletInfo() {
        return "Servlet za login korisnika";
    }// </editor-fold>

}
