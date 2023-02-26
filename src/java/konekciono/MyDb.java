/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konekciono;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aca
 */
public class MyDb {
                Connection con;
                
                public Connection getCon()
                {
                    //vidi dodavanje albuma sto ima drugaciji presek s bazom da li to moze da bude uzrok?
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(MyDb.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(MyDb.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                return con;
                }
                
}
