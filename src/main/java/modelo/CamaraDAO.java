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
public class CamaraDAO extends Camara {

    public CamaraDAO(String codigo_camara, int tempMaxima, int valorS1, int valorS2, boolean puerta, boolean motor) {
        super(codigo_camara, tempMaxima, valorS1, valorS2, puerta, motor);
    }

    public CamaraDAO() {
    }
    
    //Metodo read camaras (traer las dos camaras) y devolver un Array de tres camaras
    //metodos read de 1 camara por id ( nos trae la camara con toda su info) where id= 1 2 y 3
    //metodo update(actualizar valores de la camara)
    
}
