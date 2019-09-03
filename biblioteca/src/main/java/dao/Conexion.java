/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author estua
 */
public class Conexion {
     private static Connection con;
    private static String stringConexion;
    private static boolean conected = false;
    
    public static Connection getConexion() {
        try{
           
            stringConexion = "jdbc:mysql://localhost:3306/biblioteca?useSSL=false";
            
            con = DriverManager.getConnection(stringConexion,"root", "Cortez1234");
            conected = true;
            return con;
        } catch (SQLException ex) {
            System.out.println("Error en la coneccion: " + ex.getMessage());
             return null;
             
        }
        
    }
    
public static void close() throws SQLException{
        if (conected== true){
            con.close();
        }
    }
    
}
