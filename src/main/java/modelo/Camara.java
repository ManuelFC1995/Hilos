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
    private String codigo_camara;

private int tempMaxima;
	
private int valorS1 ;
	
private int valorS2; 
	
	
private boolean puerta;

private boolean motor;


public  Camara(String codigo_camara, int tempMaxima, int valorS1, int valorS2, boolean puerta, boolean motor) {
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


public String getCodigo_camara() {
	return codigo_camara;
}
public void setCodigo_camara(String codigo_camara) {
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
public void setPuerta(boolean puerta) {
	this.puerta = puerta;
}
public boolean isMotor() {
	return motor;
}
public void setMotor(boolean motor) {
	this.motor = motor;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((codigo_camara == null) ? 0 : codigo_camara.hashCode());
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Camara other = (Camara) obj;
	if (codigo_camara == null) {
		if (other.codigo_camara != null)
			return false;
	} else if (!codigo_camara.equals(other.codigo_camara))
		return false;
	return true;
}


@Override
public String toString() {
	return "camaras [codigo_camara=" + codigo_camara + ", tempMaxima=" + tempMaxima + ", valorS1=" + valorS1
			+ ", valorS2=" + valorS2 + ", puerta=" + puerta + ", motor=" + motor + "]";
}


}
