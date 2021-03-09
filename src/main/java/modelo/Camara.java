/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 *
 * @author manue
 */
public class Camara extends Thread {

    private int codigo_camara;

    private int tempMaxima;

    private int valorS1;

    private int valorS2;

    //true abierta
//false cerrada
    private boolean puerta;
//true encendido
//false apagado
    private boolean motor;

    Calendar fecha = new GregorianCalendar();
    int año = fecha.get(Calendar.YEAR);
    int mes = fecha.get(Calendar.MONTH);
    int dia = fecha.get(Calendar.DAY_OF_MONTH);
    int hora = fecha.get(Calendar.HOUR_OF_DAY);
    int minuto = fecha.get(Calendar.MINUTE);
    int segundo = fecha.get(Calendar.SECOND);

    public Camara(int codigo_camara, int tempMaxima, int valorS1, int valorS2, boolean puerta, boolean motor) {
        super();
        this.codigo_camara = codigo_camara;
        this.tempMaxima = tempMaxima;
        this.valorS1 = valorS1;
        this.valorS2 = valorS2;
        this.puerta = puerta;
        this.motor = motor;
    }

    public Camara() {
        super();
    }

    public int getCodigo_camara() {
        return codigo_camara;
    }

    public void setCodigo_camara(int codigo_camara) {
        this.codigo_camara = codigo_camara;
    }

    public int getTempMaxima() {
        return tempMaxima;
    }

    public void setTempMaxima(int tempMaxima) {
        this.tempMaxima = tempMaxima;
    }

    public int getValorS1() {
        return valorS1;
    }

    public void setValorS1(int valorS1) {
        this.valorS1 = valorS1;
    }

    public int getValorS2() {
        return valorS2;
    }

    public void setValorS2(int valorS2) {
        this.valorS2 = valorS2;
    }

    public boolean isPuerta() {
        return puerta;
    }

    public int GetPuerta() {
        int valor = 0;
        if (puerta = true) {
            valor = 1;
        }
        if (puerta = false) {
            valor = 0;
        }

        return valor;
    }

    public void setPuerta(int puerta) {
        if (puerta == 1) {
            this.puerta = true;

        } else {
            this.puerta = false;
        }
    }

    public boolean isMotor() {
        return motor;
    }

    public int getMotor() {
        int valor = 0;
        if (this.motor = true) {
            valor = 1;
        }
        if (this.motor = false) {
            valor = 0;
        }

        return valor;
    }



    public void BotonPuerta() {
        if (puerta == true) {
            puerta = false;
        } else {
            puerta = true;
        }
    }

    public void setMotor(int motor) {
        if (motor == 0) {
            this.motor = false;

        } else {
            this.motor = true;
        }
    }

    public void ComprobarSensor(int sensor) {
        if (sensor > this.tempMaxima) {
            while (this.motor == false) {
                System.out.println("temperatura peligrosa");
                // Esperar a motor
                if (this.puerta == true) {
                    System.out.println("Puerta abierta");
                    this.puerta = false;
                    System.out.println("Cerrando puerta");
                    System.out.println("Encendiendo motor");
                    this.motor = true;
                } else {
                    System.out.println("Encendiendo motor");
                    this.motor = true;
                }
            }
        }

    }

  

    @Override
    public String toString() {
        return "Numero de camara:" + codigo_camara + "           " + dia + "/" + (mes + 1) + "/" + año + "          " + hora + ":" + minuto + ":" + segundo + ",\n tempMaxima=" + tempMaxima + ", \n "
                + "valorS1=" + valorS1
                + ",\n valorS2=" + valorS2 + ", \n puerta=" + puerta + ", \n motor=" + motor + "]";
    }

}
