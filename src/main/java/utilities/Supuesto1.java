/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Camara;
import modelo.CamaraDAO;
import modelo.Supuesto4;

/**
 *
 * @author manue
 */
public class Supuesto1 extends Thread {
     Boolean continuar=true;

    public Supuesto1() {
    }
      
     
         public void run(){
                      System.out.println(" Arrancando sensor1 camara 2;");
                  System.out.println(" Arrancando sensor2 camara 2;");
         try {
             sleep(2000);
         } catch (InterruptedException ex) {
             Logger.getLogger(Supuesto1.class.getName()).log(Level.SEVERE, null, ex);
         }    System.out.println(" Cambiando valor de los sensores de la camara 2");
                  System.out.println(" Valores -34 , -36");
                  
         try {
             sleep(2000);
         } catch (InterruptedException ex) {
             Logger.getLogger(Supuesto1.class.getName()).log(Level.SEVERE, null, ex);
         }
                    
             do{
   System.out.println("temperatura peligrosa ");
    try {
                     sleep(1000);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(Supuesto1.class.getName()).log(Level.SEVERE, null, ex);
                 }
                       System.out.println("puerta cerrada encendiendo motor ");
                 try {
                     sleep(6000);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(Supuesto1.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }while(continuar);
} 
    
      public void detener(){
      continuar=false;
  }
}
