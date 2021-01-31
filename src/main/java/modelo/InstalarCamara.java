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
public class InstalarCamara extends Thread{
    
    public void run(){
        CamaraDAO cdao= new CamaraDAO();
        Camara c = new Camara(4, -15, 20, 18, false, false);
        cdao.create(c);
    }
}
