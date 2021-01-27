/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author manue
 */
public class Camara {
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
public void setMotor(int motor) {
		if(motor==1){
           this.motor=true;
                    
                    } else{
            this.motor=false;
        }
}







@Override
public String toString() {
	return "camaras [codigo_camara=" + codigo_camara + ", tempMaxima=" + tempMaxima + ", valorS1=" + valorS1
			+ ", valorS2=" + valorS2 + ", puerta=" + puerta + ", motor=" + motor + "]";
}


}
