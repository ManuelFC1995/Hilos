/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import data.Conection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author manue
 */
public class CamaraDAO extends Camara {
  Connection con;
   

    public CamaraDAO() {
               this.con = Conection.GetConnection();
    }
    
   // Elegid//Metodo read camaras (traer las dos camaras) y devolver un Array de tres camaras
    
    
  // Manu //metodos read de 1 camara por id ( nos trae la camara con toda su info) where id= 1 2 y 3
   
  //Elegid  //metodo update(actualizar valores de la camara)
    
}
