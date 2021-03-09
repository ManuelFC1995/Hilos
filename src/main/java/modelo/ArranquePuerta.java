/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Thread.sleep;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.jvm.hotspot.runtime.Threads;

/**
 *
 * @author manue
 */
public class ArranquePuerta extends Thread {
    public final static String SUBVERDE="\u001B[42;30m";
public final static String SUBROJO="\033[41;34m";
public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String SUBBLANCO="\u001B[47;30m";
    boolean activado = true;
    int id;
    int sensor;

    public ArranquePuerta(int id) {
        this.id = id;
       
    }

  @Override
    public void run() {
 Scanner sc = new Scanner(System.in);
        Socket cliente = null;
        ObjectInputStream entrada = null;
        ObjectOutputStream salida = null;
        String ipServidor = "localhost";
        boolean valid = false;
        boolean updated = false;
        String yesorno = "";
        int id_camara = -1;
        boolean v_puerta = false;

        while (id_camara <= 0) {
            System.out.println("Introduce la Id del Chamber");
            id_camara = sc.nextInt();
        }

        do {
            try {
                System.out.println("Introduce el valor de Sensor 'True' o 'False': ");
                v_puerta = sc.nextBoolean();
                valid = true;


                do {
                    System.out.println("¿Quieres cambiar otra vez el valor del sensor de la puerta?");
                    System.out.println("----------------------------------------");
                    System.out.println("Pulse y para cambiar el valor del sensor");
                    System.out.println("Cualquier otra letra/numero para no cambiar el valor del sensor");
                    yesorno = sc.next();


                } while (yesorno == "y");


            } catch (InputMismatchException e) {
                sc = new Scanner(System.in);
                e.printStackTrace();
                System.out.println("¡Cuidado! Solo puedes insertar números.");
            }
        } while (valid == false);

        try {

            cliente = new Socket(ipServidor, 55000);
            //asignamos este numero de puerto
            //entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            // será lo que enviaremos al servidor
            //salida = new DataOutputStream(cliente.getOutputStream());
            salida = new ObjectOutputStream(cliente.getOutputStream());
            entrada = new ObjectInputStream(cliente.getInputStream());
            // será lo que nos devuelva el servidor

        } catch (UnknownHostException excepcion) {
            excepcion.printStackTrace();
            System.err.println("El servidor no está levantado");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error: " + e);

        }

        try {
            salida.writeObject(2);
            salida.flush();
            salida.writeInt(id_camara);
            salida.flush();
            salida.writeBoolean(v_puerta);
            salida.flush();
            updated = entrada.readBoolean();


            salida.close();
            entrada.close();
            cliente.close();

            if (updated) {
                System.out.println("Se ha actualizado correctamente");

            } else {
                System.out.println("No se ha podido actualizar correctamente");
            }
        } catch (UnknownHostException excepcion) {
            System.err.println("No encuentro el servidor en la dirección" + ipServidor);
        } catch (IOException excepcion) {
            System.err.println("Error de entrada/salida");
            excepcion.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    public void LeerSensorPuerta(int id_camara) throws IOException {

  
   CamaraDAO cdao = new CamaraDAO();
       Camara c = new Camara();
       c=CargarCamara(id_camara);
        System.out.println(ANSI_BLACK+c+ANSI_RESET);
  
                if (c.getValorS1() > c.getTempMaxima() && c.isMotor()==false) {
                   
                    System.out.println(SUBROJO+"Temperatura inadecuada  en el Sensor 1"+ANSI_RESET);
                    System.out.println("Comprobando puerta");
                    if (c.isPuerta()==true) {
                        System.out.println(" La puerta esta abierta,Cerrando puerta");
                        c.setPuerta(0);
                        System.out.println("Arrancando motor");
                        c.setMotor(1);
                             cdao.update(c);
                    } else {

                        System.out.println(" La puerta esta cerrada,Arrancando motor");
                        c.setMotor(1);
                             cdao.update(c);
                    }
                } else {
                    System.out.println(SUBVERDE+"Situacion correcta S1"+ANSI_RESET);
                }

                cdao.update(c);
            

    }

   
    public Camara CargarCamara(int id){
        Camara c = new Camara();
         CamaraDAO cdao = new CamaraDAO();
        ArrayList<Camara> Camaras = new ArrayList<>();
        Camaras = (ArrayList<Camara>) cdao.load();
         for (Camara ca : Camaras) {
           if (ca.getCodigo_camara() == id) {
               c=ca;
            }
         }
            
        return c;
    }

    public void Detener() {
        activado = false;
    }
}
