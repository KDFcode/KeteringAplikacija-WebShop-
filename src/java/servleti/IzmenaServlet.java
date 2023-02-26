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
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aca
 */
public class IzmenaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        String unameNovo=request.getParameter("uname");
        String ID=request.getParameter("id");
        int idBroj= Integer.parseInt(ID);
        
        String nameStaro=request.getParameter("staroIme");
        
        String upassNovo=request.getParameter("upassword"); //ovde ga lepo pokupi,vidi screenshot-ove 222-225
        
        String dbUrl="jdbc:mysql://localhost:3306/mydb",
                user="root", 
                pass="";
       
        //vidi  https://www.youtube.com/watch?v=UNiYU0NjiQI&ab_channel=SynTech https://stackoverflow.com/questions/20471489/updating-values-netbeans
        //za ubuduce i detaljnije i prepared statement /ps itd.
        
        
        
        String upit="UPDATE  user2 set  name='"+unameNovo+"' , pass= '"+upassNovo+"' WHERE id='"+idBroj+"'; "; //pretvoriti u prepared statement
        //za update pazi da budu navodnici uz x='ono sto ubacujem/proveravam' jer se inace sjebe,a ne sme slucajno ` ili " jer ga to ujebe drugacije
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //sto sve posle ovoga preskoci????
            
            Connection con= DriverManager.getConnection(dbUrl,user,pass); 
            
            Statement st=con.createStatement() ; 
            st.executeUpdate(upit);
            st.close();
            con.close(); 
            }
        catch(ClassNotFoundException e) 
        {}
        catch(SQLException ex)
            {
            request.setAttribute("poruka", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        request.setAttribute("msg","uspesno izmenjen korisnik");
        request.getRequestDispatcher("index.jsp").forward(request,response);
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
        return "Servlet za update!";
    }// </editor-fold>

}
