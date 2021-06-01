/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ob1aed2021;

public class NodoCiudad {

    private String nombre;
    private int id;
    NodoCiudad siguiente;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSiguiente(NodoCiudad siguiente) {
        this.siguiente = siguiente;
    }

    public NodoCiudad getSiguiente() {
        return siguiente;
    }

    public NodoCiudad(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.siguiente = null;
    }

}
