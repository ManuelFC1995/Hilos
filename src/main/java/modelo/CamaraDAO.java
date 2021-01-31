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
    
    

 // ---------------------------------------------
//LOAD CAMARA ID
//--------------------------------------------
public Camara load(int id) {
        // Cargamos la base de datos en el módelo de datos de nuestra aplicación JAVA
        Camara c=new Camara();
        String sql="select * from camara where codigo_camara=?";
        try{
            //establecer conexion
            con=cn.Conectar();
            //preparación de la sentencia SQL
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();

                //Creación de objetos en nuestra Aplicación JAVA con los datos de la tabla
                c.setCodigo_camara(rs.getInt(1));
                c.setTempMaxima(rs.getInt(2));
                c.setValorS1(rs.getInt(3));
                c.setValorS2(rs.getInt(4));
                c.setPuerta(rs.getInt(5));
                c.setMotor(rs.getInt(6));

            con.close();
            }catch(SQLException ex) {
            Logger.getLogger(CamaraDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return c;
    }
 


        public void modificarS1(int valor,int id) throws SQLException {
        Statement st = null;
        Camara c = new Camara();
           con=cn.Conectar();
        try {
            if (con != null) {

                st = con.createStatement();
               
                c.setValorS1(valor);
             
                st.executeUpdate("UPDATE  Camara "
               + "SET " 
               + "ValorS1="+c.getValorS1()+","
              
               +"WHERE ID="+id);
            }

        } finally {
            if (con != null) {
                st.close();
            
        }
                
    }
 }
//----------------------------------
//METODO CREATE CAMARA
//-----------------------------------
public int create(Object element) {
        int r=0;
        if(element instanceof Camara){
            Camara c=(Camara) element;

            String sql="insert into camara (codigo_camara, tempMaxima, valorS1, valorS2, puerta, motor) values(?, ?, ?, ?, ?, ?)";
            try{
                //establecemos conexion
                con=cn.Conectar();
                //preparamos la sentencia SQL
                ps=con.prepareStatement(sql);
                //asignamos valores a los distintos argumentos
                ps.setInt(1,c.getCodigo_camara());
                ps.setInt(2,c.getTempMaxima());
                ps.setInt(3,c.getValorS1());
                ps.setInt(4,c.getValorS2());
                ps.setInt(5,c.GetPuerta());
                ps.setInt(6,c.getMotor());
                //ejecutar
                r=ps.executeUpdate();
                con.close();

            }catch(SQLException ex) {
            Logger.getLogger(CamaraDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return r;
    }


//-------------------------------------------------------
//UPDATE CAMARA
//--------------------------------------------------------
public int update(Object element) {
        int r=0;
        if(element instanceof Camara){
        Camara c=(Camara) element;

        String sql="update camara set tempMaxima=?, valorS1=?, valorS2=?, puerta=?, motor=? where codigo_camara=?";
        try{
            //conexion
            con=cn.Conectar();
            //preparamos la sentencia SQL
            ps=con.prepareStatement(sql);
            //asignamos valores a los argumentos
            ps.setInt(1,c.getTempMaxima());
            ps.setInt(2,c.getValorS1());
            ps.setInt(3,c.getValorS2());
            ps.setBoolean(4,c.isPuerta());
            ps.setBoolean(5,c.isMotor());
            ps.setInt(6,c.getCodigo_camara());

            //ejecutamos
            r=ps.executeUpdate();
            con.close();

        }catch(SQLException ex) {
            Logger.getLogger(CamaraDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return r;
    }
}
