/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manue
 */
public class Arranque extends Thread {

    boolean activado = true;
    int id;
    int sensor;

    public Arranque(int id, int sensor) {
        this.id = id;
        this.sensor = sensor;
    }

    @Override
    public void run() {
        CamaraDAO cdao = new CamaraDAO();
        ArrayList<Camara> camaras = new ArrayList<>();
        camaras = (ArrayList<Camara>) cdao.load();
        do {
            if (this.sensor == 1) {
                try {
                    sleep(10000);
                    LeerSensor1(this.id);
                    for (Camara c : camaras) {
                        if (c.getCodigo_camara() == id) {

                            cdao.update(c);
                        }
                    }

                } catch (IOException ex) {
                    Logger.getLogger(Arranque.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Arranque.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (this.sensor == 2) {
                try {
                    sleep(3000);
                    LeerSensor2(this.id);
                    for (Camara c : camaras) {
                        if (c.getCodigo_camara() == id) {

                            cdao.update(c);
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Arranque.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Arranque.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("Elija un sensor valido");
            }
        } while (activado);
    }

    public void LeerSensor1(int id_camara) throws IOException {

        CamaraDAO cdao = new CamaraDAO();
        ArrayList<Camara> Camaras = new ArrayList<>();
        Camaras = (ArrayList<Camara>) cdao.load();

        for (Camara c : Camaras) {
            if (c.getCodigo_camara() == id_camara) {
                c.ComprobarSensor(c.getValorS1());
                cdao.update(c);
                break;
            }

        }

    }

    public int LeerSensor2(int id_camara) throws IOException {

        CamaraDAO cdao = new CamaraDAO();
        ArrayList<Camara> Camaras = new ArrayList<>();
        Camaras = (ArrayList<Camara>) cdao.load();
        int Valor = 0;
        for (Camara c : Camaras) {
            if (c.getCodigo_camara() == id_camara) {
                c.ComprobarSensor(c.getValorS2());
                cdao.update(c);
                break;
            }

        }

        return Valor;

    }

    public void Detener() {
        activado = false;
    }
}
