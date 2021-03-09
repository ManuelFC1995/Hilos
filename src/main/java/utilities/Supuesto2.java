/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author manue
 */
import static java.lang.Thread.sleep;
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
public class Supuesto2 extends Thread {
     Boolean continuar=true;

    public Supuesto2() {
    }
      
     
         public void run(){
                      System.out.println(" Arrancando sensor1 camara 1;");
                 
         try {
             sleep(2000);
         } catch (InterruptedException ex) {
             Logger.getLogger(Supuesto1.class.getName()).log(Level.SEVERE, null, ex);
         }    System.out.println(" Cambiando valor de los sensores de la camara 1");
                  System.out.println(" Valores -27 , puerta abierta");
                  
         try {
             sleep(2000);
         } catch (InterruptedException ex) {
             Logger.getLogger(Supuesto1.class.getName()).log(Level.SEVERE, null, ex);
         } System.out.println("temperatura peligrosa ");
          try {
                     sleep(1000);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(Supuesto1.class.getName()).log(Level.SEVERE, null, ex);
                 }
                     System.out.println("Puerta abierta....cerrando puerta ");
                       try {
                     sleep(1000);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(Supuesto1.class.getName()).log(Level.SEVERE, null, ex);
                 }
                          System.out.println("encendiendo motor "); 
             do{
   System.out.println("temperatura peligrosa ");
    try {
                     sleep(1000);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(Supuesto1.class.getName()).log(Level.SEVERE, null, ex);
                 }
                       System.out.println("Puerta cerrada....encendiendo motor");
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