/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ob1aed2021;


public class NodoServicio {
   
    private String servicio;
    NodoServicio siguiente;

    public void setSiguiente(NodoServicio siguiente) {
        this.siguiente = siguiente;
    }

    public NodoServicio getSiguiente() {
        return siguiente;
    }        

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public NodoServicio(String servicio) {

        this.servicio = servicio;
        this.siguiente = null;
    }
 
    
    
}
