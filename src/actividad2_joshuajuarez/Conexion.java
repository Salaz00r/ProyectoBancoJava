/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad2_joshuajuarez;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author josua
 */
public class Conexion {
    
    public Connection getConnection(){
        Connection con = null;
        String base = "cajerobd";
        String url = "jdbc:mysql://localhost:3306/" + base + "?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
        return con;
    }    
}
