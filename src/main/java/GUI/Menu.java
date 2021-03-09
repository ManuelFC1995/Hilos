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
import modelo.ArranquePuerta;
import modelo.Camara;
import modelo.CamaraDAO;
import modelo.InstalarCamara;
import modelo.Log;
import modelo.Supuesto4;
import utilities.Utilidades;

public class Menu {

    public static void principal() throws SQLException {

        int opciones;
        System.out.println("App Hilos Sensores");
        System.out.println("");
        do {
            System.out.println("1. Sensor de temperatura");
            System.out.println("2. Sensor de puerta abierta");
            System.out.println("3.Terminal de administración.");
            System.out.println("4.Salir");
            opciones = utilities.Utilidades.getInt();
            switch (opciones) {
                case 1:
                    utilities.Utilidades.clearScreen();
                    Supuesto1();
                    break;
                case 2:
                    utilities.Utilidades.clearScreen();
                    Supuesto2();

                    break;

                case 3:
                    utilities.Utilidades.clearScreen();
                    Supuesto3();
                    break;

                case 4:
                    System.out.println("Hasta Pronto");

                    break;
                default:
                    utilities.Utilidades.clearScreen();
                    System.out.println("Introduzca una opcion correcta");
            }
        } while (opciones != 4);
    }

    public static void Supuesto1() throws SQLException {
        int opciones;
        int camara;
        int sensor;
        do {
            System.out.println("Seleccione camara 1, 2, 3");

            camara = utilities.Utilidades.getInt();
        } while (camara < 1 || camara > 3);
        do {
            System.out.println("Seleccione sensor 1 ,2");
            sensor = utilities.Utilidades.getInt();
        } while (sensor > 2 || sensor < 1);

        CamaraDAO cdao = new CamaraDAO();
        ArrayList<Camara> camaras = new ArrayList<>();
        camaras = (ArrayList<Camara>) cdao.load();
        for (Camara c : camaras) {

            if (c.getCodigo_camara() == camara) {

                cdao.update(c);
            }
        }
        Arranque ArranqueS1 = new Arranque(camara, sensor);

        ArranqueS1.start();

        System.out.println("App Hilos Sensores");
        System.out.println("");
        System.out.println("Supuesto 1 ejecutandose... ");
        do {
            System.out.println("1.Salir");

            opciones = utilities.Utilidades.getInt();
            switch (opciones) {
                case 1:
                    utilities.Utilidades.clearScreen();
                    ArranqueS1.Detener();

                    System.out.println("Hilo Arranque detenido,vuelva pronto");
                    break;

                default:

            }
        } while (opciones != 1);
    }

    public static void Supuesto2() throws SQLException {
        int opciones;
        int camara;
        int sensor;
        do {
            System.out.println("Seleccione camara 1, 2, 3");

            camara = utilities.Utilidades.getInt();
        } while (camara < 1 || camara > 3);

        CamaraDAO cdao = new CamaraDAO();
        ArranquePuerta ArranqueS1 = new ArranquePuerta(camara);

        ArranqueS1.start();

        ArrayList<Camara> camaras = new ArrayList<>();
        camaras = (ArrayList<Camara>) cdao.load();
        for (Camara c : camaras) {
            if (c.getCodigo_camara() == camara) {

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
                case 1:
                    utilities.Utilidades.clearScreen();
                    ArranqueS1.Detener();

                    break;

                default:

            }
        } while (opciones != 1);
    }

    public static void Supuesto3() throws SQLException {
        int opciones;

        System.out.println("1.Ver el estado de los sensores, de la puerta y del motor de una cámara frigorífica. ");
        System.out.println("2.Ingresar una nueva cámara frigorífica. ");
        System.out.println("3.Salir ");
        do {
            System.out.println("3.Salir ");

            opciones = utilities.Utilidades.getInt();
            switch (opciones) {
                case 1:
                    utilities.Utilidades.clearScreen();
                    Supuesto3_1();
                    break;
                case 2:
                    utilities.Utilidades.clearScreen();
                    InstalarCamara i = new InstalarCamara();
                    i.start();
                    break;
                case 3:
                    utilities.Utilidades.clearScreen();

                    break;
                default:

            }
        } while (opciones != 3);
    }

    public static void Supuesto3_1() throws SQLException {
        Supuesto4 s4 = new Supuesto4();
         s4.start();
        int opciones;
        System.out.println("App Hilos Sensores");
        System.out.println("");
         System.out.println("1.Salir");
       
        do {
           

            opciones = utilities.Utilidades.getInt();
            switch (opciones) {
                case 1:
                    utilities.Utilidades.clearScreen();
                    s4.detener();
                    break;

                default:

            }
        } while (opciones != 1);
    }
}
