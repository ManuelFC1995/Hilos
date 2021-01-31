/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.Controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Arranque;
import modelo.Camara;
import modelo.CamaraDAO;
import modelo.InstalarCamara;
import modelo.Log;
import modelo.Supuesto4;
import utilities.Utilidades;

public class Menu {

    public static void principal() throws SQLException {
        Log l= new Log();
        l.start();
        int opciones;
        System.out.println("App Hilos Sensores");
        System.out.println("");
        do {
            System.out.println("1. Simular la lectura de dos sensores de la misma cámara de manera simultánea.");
            System.out.println("2.Simular la lectura de un sensor con valor superior a la temperatura máxima y una apertura de puerta simultánea.");
            System.out.println("3.Ingreso de una nueva cámara frigorífica y lectura de los sensores de temperatura de las cámaras restantes");
            System.out.println("4. Resumen del estado de las cámaras.");
            System.out.println("5.Salir");
            opciones = utilities.Utilidades.getInt();
            switch (opciones) {
                case 1:   utilities.Utilidades.clearScreen();
                    Supuesto1();
                    break;
                case 2:   utilities.Utilidades.clearScreen();
                    Supuesto2();
                       
                    break;

                case 3:   utilities.Utilidades.clearScreen();
                    Supuesto3();
                    break;
                case 4:   utilities.Utilidades.clearScreen();
                    Supuesto4();
                    break;
                case 5:
                    System.out.println("Hasta Pronto");
                    l.detener();
                    break;
                default:   utilities.Utilidades.clearScreen();
                    System.out.println("Introduzca una opcion correcta");
            }
        } while (opciones != 5);
    }

    public static void Supuesto1() throws SQLException {
        int opciones;
       
     
        Arranque ArranqueS1 = new Arranque(2,1);
          Arranque ArranqueS2 = new Arranque(2,2);
          ArranqueS1.start();
          ArranqueS2.start();
            CamaraDAO cdao = new CamaraDAO();
             ArrayList<Camara> camaras = new ArrayList<>();
             camaras=(ArrayList<Camara>) cdao.load();
           for (Camara c :camaras){
           
              if( c.getCodigo_camara()==2){
                 
                  c.setValorS1(-34);
                  c.setValorS2(-36);
                 cdao.update(c); 
              }
          }

       
          
          
       
        
                
        System.out.println("App Hilos Sensores");
        System.out.println("");
        System.out.println("Supuesto 1 ejecutandose... ");
        do {
            System.out.println("1.Salir");

            opciones = utilities.Utilidades.getInt();
            switch (opciones) {
                case 1:  utilities.Utilidades.clearScreen();
ArranqueS1.Detener();
ArranqueS2.Detener();
                    break;

                default:

            }
        } while (opciones != 1);
    }

    public static void Supuesto2() throws SQLException {
        int opciones;
             CamaraDAO cdao = new CamaraDAO();
        Arranque ArranqueS1 = new Arranque(1,1);
          Arranque ArranqueS2 = new Arranque(1,2);
            ArranqueS1.start();
          ArranqueS2.start();
          ArrayList<Camara> camaras = new ArrayList<>();
            camaras=(ArrayList<Camara>) cdao.load();
          for (Camara c :camaras){
              if( c.getCodigo_camara()==1){
                  c.setValorS1(-37);
                  c.setPuerta(1);
                 cdao.update(c); 
              }
          }
        System.out.println("App Hilos Sensores");
        System.out.println("");
        System.out.println("Supuesto 2 ");
        do {
            System.out.println("1.Salir");

            opciones = utilities.Utilidades.getInt();
            switch (opciones) {
                case 1:  utilities.Utilidades.clearScreen();

                    break;

                default:

            }
        } while (opciones != 1);
    }

    public static void Supuesto3() throws SQLException {
        int opciones;
        
      InstalarCamara i = new InstalarCamara();
      i.start();
        System.out.println("App Hilos Sensores");
        System.out.println("");
        System.out.println("Supuesto 3 ");
        do {
            System.out.println("1.Salir");

            opciones = utilities.Utilidades.getInt();
            switch (opciones) {
                case 1:  utilities.Utilidades.clearScreen();

                    break;

                default:

            }
        } while (opciones != 1);
    }

    public static void Supuesto4() throws SQLException {
        Supuesto4 s4= new Supuesto4();
        int opciones;
        System.out.println("App Hilos Sensores");
        System.out.println("");
        s4.start();
        do {
            System.out.println("1.Salir");

            opciones = utilities.Utilidades.getInt();
            switch (opciones) {
                case 1:  utilities.Utilidades.clearScreen();
s4.detener();
                    break;

                default:

            }
        } while (opciones != 1);
    }
}
