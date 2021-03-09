/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author manue
 */
public class InstalarCamara extends Thread{
    
    public void run(){
        Scanner sc = new Scanner(System.in);
        Socket cliente = null;
        ObjectInputStream entrada = null;
        ObjectOutputStream salida = null;
        String ipServidor = "localhost";
        int option = 2;
        boolean respuesta;
        Camara cam = new Camara();


        System.out.println("Introduce la id de la cámara");
        int id=sc.nextInt();
        System.out.println("Introduce la temperatura máxima");
        int max=sc.nextInt();
        System.out.println("Introduce la tempertura del sensor 1");
        int sensor1=sc.nextInt();
        System.out.println("Introduce la tempertura del sensor 2");
        int sensor2=sc.nextInt();
        cam.setMotor(0);
        cam.setCodigo_camara(id);
        cam.setPuerta(0);
        cam.setTempMaxima(max);
        cam.setValorS1(sensor1);
        cam.setValorS2(sensor2);





        try {
            cliente = new Socket(ipServidor, 55000);
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
           salida.writeObject(3);
            salida.flush();
            salida.writeInt(option);
            salida.flush();
            salida.writeObject(cam);
            salida.flush();
            respuesta = entrada.readBoolean();


            if (respuesta == true) {
                System.out.println("Cámara creada");

            } else {
                System.out.println("Error, no se pudo crear correctamente");
            }

            salida.close();
            entrada.close();
            cliente.close();


        } catch (UnknownHostException excepcion) {
            System.err.println("No encuentro el servidor en la dirección" + ipServidor);
        } catch (IOException excepcion) {
            System.err.println("Error de entrada/salida");
            excepcion.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }

    }
}
