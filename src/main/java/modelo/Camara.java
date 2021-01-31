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
	
private int valorS1 ;
	
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

public  Camara(int codigo_camara, int tempMaxima, int valorS1, int valorS2, boolean puerta, boolean motor) {
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
    int valor=0;
	if(puerta=true)valor= 1;
        if(puerta=false)valor=0;
        
        return valor;
}
public void setPuerta(int puerta) {
	if(puerta==1){
           this.puerta=true;
                    
                    } else{
            this.puerta=false;
        }
}
public boolean isMotor() {
	return motor;
}
public int getMotor(){
     int valor=0;
	if(motor=true)valor= 1;
        if(motor=false)valor=0;
        
        return valor;
}

public boolean Arranque(){
    if (motor== false){
        if(puerta==false){
            motor=true;
            return true;
            
        }else{
            return false;
        }
        
    }else{
        return false;
    }
}

public void BotonPuerta(){
    if (puerta==true){
        puerta=false;
    }else{
        puerta=true;
    }
}
public void setMotor(int motor) {
		if(motor==1){
           this.motor=true;
                    
                    } else{
            this.motor=false;
        }
}
  public synchronized void ComprobarSensor1(int sensor) {


      //motor apagado
     while (sensor > tempMaxima) {
            try {
                // Esperar a Puerta
                wait();
            } catch (InterruptedException e) { }
        }
      notifyAll();
    }

//true abierta

  public synchronized void ActivarMotor() {
    

      //motor apagado
     while (motor == true) {
         System.out.println("Puerta abierta, cerrando puerta");
            try {
                // Esperar a Puerta
                wait();
            } catch (InterruptedException e) { }
        }
      notifyAll();
    }

 
    public synchronized void ComprobarPuerta() {
        if(puerta=true){
            System.out.println("Puerta abierta, apagando motor");
            motor=false;
        }

     while ( puerta== false) {
            try {
                // Esperar a Motor
                wait();
            } catch (InterruptedException e) { }
        }
        puerta = false;
        notifyAll();
    }

public synchronized void ComprobarSensor(int sensor) {
        while (sensor > tempMaxima && motor==false) {
            try {
                System.out.println("temperatura peligrosa");
                // Esperar a motor
                wait();
            } catch (InterruptedException e) { }
        }
       
        notifyAll();
    }
 
    public synchronized void motor() {
      if(puerta==false){
          System.out.println("Puerta cerrada....encendiendo motor");
          motor=true;
      }
      
        if(puerta==true){
               System.out.println("Puerta abierta....cerrando puerta");
            puerta=false;
                System.out.println("encendiendo motor");
          motor=true;
      }
        notifyAll();
    }
    
    
    
    

@Override
public String toString() {
	return "Numero de camara:" + codigo_camara +"           "+ dia + "/" + (mes+1) + "/" + año+"          " +hora+":"+minuto+":"+segundo+  ",\n tempMaxima=" + tempMaxima + ", \n "
                + "valorS1=" + valorS1 
			+ ",\n valorS2=" + valorS2 + ", \n puerta=" + puerta + ", \n motor=" + motor + "]";
}


}
