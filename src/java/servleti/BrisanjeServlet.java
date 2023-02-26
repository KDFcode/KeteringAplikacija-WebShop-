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
import modelBean_ovi.korisnik;

/**
 *
 * @author Aca
 */
public class BrisanjeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        response.setContentType("text/html;charset=UTF-8");
        
         String ID=request.getParameter("id");
        int idBroj= Integer.parseInt(ID);
       // ResultSet rs;
        
        String dbUrl="jdbc:mysql://localhost:3306/mydb",
                user="root", 
                pass="";
       
        String upit="DELETE FROM user2 WHERE id='"+idBroj+"'; "; //pretvoriti u prepared statement
        //pazi za ove delete varijante da stavljas kraj zagrade i ;,jer izgleda to pravi probleme nekad
        //a i da bude ovaj id='"+idBroj+"' fazon,kad nema ' za sam MySQL ume da jebava kad ide preko netbeans-a
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con= DriverManager.getConnection(dbUrl,user,pass); 
            
            Statement st=con.createStatement() ; 
           // rs=st.executeQuery(upit);   //proveri naknadno mozes li ovime nesto jos da dobijes korisno
             st.executeUpdate(upit);
           
            request.getRequestDispatcher("index.jsp").forward(request,response); 
           
            }
        catch(ClassNotFoundException e) 
        {}
        catch(SQLException ex)
            {
            request.setAttribute("poruka", ex.getMessage());
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
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "servlet za brisanje!!!";
    }// </editor-fold>

}
