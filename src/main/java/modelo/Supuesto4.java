/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manue
 */
public class Supuesto4 extends Thread{
         Boolean continuar=true;
    public void run(){
       CamaraDAO cdao= new CamaraDAO();
             ArrayList<Camara> Camaras = new  ArrayList<>();
             do{
              Camaras= (ArrayList<Camara>) cdao.load();
              
               for (Camara c :Camaras){
                   System.out.println(c);
                   System.out.println("   \n"+"   \n"+"   \n");
        }
           try {
               Thread.sleep(30000);
               utilities.Utilidades.clearScreen();
           } catch (InterruptedException ex) {
               Logger.getLogger(Supuesto4.class.getName()).log(Level.SEVERE, null, ex);
           }
             }while(continuar);
} 
    
      public void detener(){
      continuar=false;
  }
}
