/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manue
 */
public class Log extends Thread {

    Boolean continuar = true;

    public void run() {
        do {
            try {
                Escribir();
                Thread.sleep(30000);
            } catch (IOException ex) {
                Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (continuar);

    }

    public void Escribir() throws IOException {
        try {
            CamaraDAO cdao = new CamaraDAO();
            ArrayList<Camara> Camaras = new ArrayList<>();
            Camaras = (ArrayList<Camara>) cdao.load();
            FileWriter escritura = new FileWriter("C:/Users/manue/OneDrive/Escritorio/Registro.log");
            for (Camara c : Camaras) {
                escritura.write(c.toString());
                escritura.write("   \n" + "   \n" + "   \n");
            }
            escritura.write("-----------------------------------------");
            escritura.close();
        } catch (IOException e) {

        }
    }

    public void detener() {
        continuar = false;
    }

}
