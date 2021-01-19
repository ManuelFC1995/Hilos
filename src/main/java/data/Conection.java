/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;


    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conection {




    private static void cargarDriver() {
 try {
 //Introducimos el driver
 Class.forName("com.mysql.cj.jdbc.Driver");
 } catch (ClassNotFoundException ex) {
 ex.printStackTrace();
 }
 }
    
    public static Connection GetConnection(){
        cargarDriver();
        Connection conexion=null;
        try{
        String Timezone="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String ip="localhost:3306/musicddbb";
        String url="jdbc:mysql://";
        String user="root";
        String pass="";
        conexion=DriverManager.getConnection(url+ip+Timezone, user, pass);
       
   
        return conexion;
          
        } catch (SQLException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        }
       
          return conexion;
    }

    
}

