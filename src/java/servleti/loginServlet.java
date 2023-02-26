/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import konekciono.MyDb;

/**
 *
 * @author Aca
 */
public class loginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String uname=request.getParameter("uname");
            String pass=request.getParameter("upassword");
            MyDb db= new MyDb();
            Connection con = db.getCon();
            Statement stmt= con.createStatement();
            stmt.executeUpdate("insert into user (name,pass) values('"+uname+"','"+pass+"');"); //zasto ga vrati na pocetak try-catch blocka posle statement-a a
            //pre execute update-a?
             //vidi dodavanje albuma sto ima drugaciji presek s bazom da li to moze da bude uzrok?
            out.println("everything fine and data is inserted");
        } catch (SQLException ex) { //da li on fazon uvek hvata ovu gresku? ako da zasto pobogu?
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        return "Servlet za login";
    }// </editor-fold>

}
