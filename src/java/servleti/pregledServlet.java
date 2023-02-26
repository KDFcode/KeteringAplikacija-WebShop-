/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
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
public class pregledServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
            
        response.setContentType("text/html;charset=UTF-8");
        
         ArrayList<korisnik> lista= new ArrayList<>();
        request.setAttribute("lista", lista);
        
         ResultSet rs;
        
        String dbUrl="jdbc:mysql://localhost:3306/mydb",
                user="root", 
                pass="";
       
        String upit="SELECT * FROM   user2; "; //pretvoriti u prepared statement
        //pazi za ove insert varijante da stavljas kraj zagrade i ;,jer izgleda to pravi probleme nekad
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con= DriverManager.getConnection(dbUrl,user,pass); 
            
            Statement st=con.createStatement() ; 
            rs=st.executeQuery(upit);
            
            while(rs.next())
                {
                lista.add(new korisnik(Integer.parseInt(rs.getString("id")),rs.getString("name"),rs.getString("pass"))); //odavde skakao jer nije bilo ime kao u tabeli u bazi nego kao ovde za parametre,pazi to!!!!
                }
            request.getRequestDispatcher("pregled.jsp").forward(request,response); 
           
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
        return "servlet za select!!!";
    }// </editor-fold>

}
