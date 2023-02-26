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
public class loginServlet2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        String uname=request.getParameter("uname");
            String upass=request.getParameter("upassword"); //ovde ga lepo pokupi,vidi screenshot-ove 222-225
        int id=Integer.parseInt( request.getParameter("id"));
        String dbUrl="jdbc:mysql://localhost:3306/mydb",
                user="root", 
                pass="";
       
        String upit="INSERT  INTO user2(id,name,pass) VALUES( ' "+id+" ', ' "+uname+" ', ' "+upass+" '); "; //pretvoriti u prepared statement
        //pazi za ove insert varijante da stavljas kraj zagrade i ;,jer izgleda to pravi probleme nekad
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //sto sve posle ovoga preskoci????
            
            Connection con= DriverManager.getConnection(dbUrl,user,pass); //sto sad ne zna con?????
            //https://stackoverflow.com/questions/6291937/is-not-a-known-variable-in-the-current-context sustinski kaze da to ne treba da pravi problem i da ga samo teram dalje???
           // ovo samo lici? https://bz.apache.org/netbeans/show_bug.cgi?id=248620
            
            Statement st=con.createStatement() ; //sto preskoci sve posle class-for-name-a pravo do catch-a pa van????
            st.executeUpdate(upit);
            st.close();
            con.close(); //a ne puca???
            }
        catch(ClassNotFoundException e) //ovde izadje?
        {}
        catch(SQLException ex)
            {
            request.setAttribute("poruka", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        request.setAttribute("msg","uspesno unesen korisnik");
        request.getRequestDispatcher("dodat.jsp").forward(request,response);
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
        return "Servlet za insert!!!!";
    }// </editor-fold>

}
