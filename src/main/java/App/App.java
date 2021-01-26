/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import GUI.Menu;
import data.Conection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Camara;
import modelo.CamaraDAO;

/**
 *
 * @author manue
 */
public class App {
    public static void main(String[] args) throws SQLException {
    
        CamaraDAO c=new CamaraDAO();
        Camara cm = new Camara();
        List<Camara> camaras=new ArrayList();
        
        
        camaras=c.load();
        System.out.println(camaras);
    
    }
}
