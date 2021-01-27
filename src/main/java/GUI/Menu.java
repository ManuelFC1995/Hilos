/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.Controller;
import java.sql.SQLException;
import java.util.Scanner;
import utilities.Utilidades;


public  class Menu {
    public static void principal() throws SQLException{
        int opciones;
        System.out.println("App Hilos Sensores");
                System.out.println("");
    do{    
        System.out.println("1. Simular la lectura de dos sensores de la misma cámara de manera simultánea." );
        System.out.println("2.Simular la lectura de un sensor con valor superior a la temperatura máxima y una apertura de puerta simultánea.");
         System.out.println("3.Ingreso de una nueva cámara frigorífica y lectura de los sensores de temperatura de las cámaras restantes");
         System.out.println("4. Resumen del estado de las cámaras.");
         System.out.println("5.Salir");
         opciones = utilities.Utilidades.getInt();
               switch (opciones) {
                case 1:
                  
                    break;
                case 2:
           
                 
                 break;
              
                case 3:
                 

                    break;
                      case 4:
                 

                    break;
                      case 5:
                 

                    break;
                default:
                
            

        } }
    while (opciones != 5);
    }
}
