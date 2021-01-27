/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import data.Conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manue
 */
public class CamaraDAO extends Camara {
  Connection con;
  Conection cn=new Conection();
    PreparedStatement ps;
    ResultSet rs;

    public CamaraDAO() {
    }
    
    public List load() {
        // Cargamos la base de datos en el módelo de datos de nuestra aplicación JAVA
        List <Camara> elementos=new ArrayList<>();
        String sql="select * from camara";
        try{
            //establecer conexion
            con=cn.Conectar();
            //preparación de la sentencia SQL
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            
            //Recorremos el conjunto de resultados de la QUERY
            while (rs.next()){
                //Creación de objetos en nuestra Aplicación JAVA con los datos de la tabla
                Camara c=new Camara();
                c.setCodigo_camara(rs.getInt(1));
                c.setTempMaxima(rs.getInt(2));
                c.setValorS1(rs.getInt(3));
                c.setValorS2(rs.getInt(4));
                c.setPuerta(rs.getInt(5));
                c.setMotor(rs.getInt(6));
                
                elementos.add(c);
            
            }con.close();
            }catch(SQLException ex) {
            Logger.getLogger(CamaraDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return elementos;
    }
   
    
   // Elegid//Metodo read camaras (traer las dos camaras) y devolver un Array de tres camaras
    
    
  // Manu //metodos read de 1 camara por id ( nos trae la camara con toda su info) where id= 1 2 y 3
   
  //Elegid  //metodo update(actualizar valores de la camara)
    
}
