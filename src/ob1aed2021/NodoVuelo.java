/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ob1aed2021;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.logging.Logger;

public class NodoVuelo {

    NodoVuelo anterior;
    NodoVuelo siguiente;
    private ListaServicios ls;
    private ListaComentarios lc;
    private ListaReservas lr;
    private ListaCola lcola;

    public ListaCola getLcola() {
        return lcola;
    }

    public void setLcola(ListaCola lcola) {
        this.lcola = lcola;
    }

    public NodoVuelo getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoVuelo anterior) {
        this.anterior = anterior;
    }

    public ListaReservas getLr() {
        return lr;
    }

    public void setLr(ListaReservas lr) {
        this.lr = lr;
    }
    
    

    private int numero;
    private String aerolinea;
    private String ciudadOrigen;
    private String ciudadDestino;
    private int cantidadEstrellas;
    private int capacidadPasajeros;
    private Calendar fechaHoraSalida;
    private int duracion;

    public int getCantidadEstrellas() {
        return cantidadEstrellas;
    }

    public NodoVuelo(int numero, String aerolinea, String ciudadOrigen, String ciudadDestino, int cantidadEstrellas, int capacidadPasajeros, Calendar fechaHoraSalida, int duracion) {
        this.numero = numero;
        this.aerolinea = aerolinea;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.cantidadEstrellas = cantidadEstrellas;
        this.capacidadPasajeros = capacidadPasajeros;
        this.fechaHoraSalida = fechaHoraSalida;
        this.duracion = duracion;
        this.ls = new ListaServicios();
        this.lc = new ListaComentarios();
        this.lr = new ListaReservas(capacidadPasajeros);
        this.lcola = new ListaCola(capacidadPasajeros);
        this.siguiente = null;
    }

    public ListaComentarios getLc() {
        return lc;
    }

    public void setLc(ListaComentarios lc) {
        this.lc = lc;
    }

    public void setSiguiente(NodoVuelo siguiente) {
        this.siguiente = siguiente;
    }

    public NodoVuelo getSiguiente() {
        return siguiente;
    }

    public void setLs(ListaServicios ls) {
        this.ls = ls;
    }

    public ListaServicios getLs() {
        return ls;
    }

    public int getNumero() {
        return numero;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public void setCantidadEstrellas(int cantidadEstrellas) {
        this.cantidadEstrellas = cantidadEstrellas;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public void setFechaHoraSalida(Calendar fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public Calendar getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public int getDuracion() {
        return duracion;
    }

    public Retorno calcularRanking(){
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        int suma = 0;
        NodoComentario unNodoComentario = lc.getInicio();
        while(unNodoComentario!=null){
            
            suma = suma + unNodoComentario.getRanking();         
            
            unNodoComentario = unNodoComentario.getSiguiente();
        }
        ret.valorEntero = suma / this.lc.getCantComentarios();
        
        return ret;
    }
    
}
