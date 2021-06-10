/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ob1aed2021;

import java.util.Calendar;

/**
 *
 * @author 4815s
 */
public class ListaVuelo implements IListaVuelo {

    NodoVuelo inicio;
    NodoVuelo ultimo;
    int cantVuelos;

    public ListaVuelo() {
        this.inicio = null;
        this.ultimo = null;
        this.cantVuelos = 0;
    }

    public void setInicio(NodoVuelo inicio) {
        this.inicio = inicio;
    }

    public void setUltimo(NodoVuelo ultimo) {
        this.ultimo = ultimo;
    }

    public void setCantVuelos(int cantVuelos) {
        this.cantVuelos = cantVuelos;
    }

    public NodoVuelo getInicio() {
        return inicio;
    }

    public NodoVuelo getUltimo() {
        return ultimo;
    }

    public int getCantVuelos() {
        return cantVuelos;
    }

    @Override
    public Retorno esVacia() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano = this.getInicio() == null;
        return ret;
    }

    @Override
    public Retorno agregarVuelo(int numero, String aerolinea, String ciudadOrigen, String ciudadDestino, int cantidadEstrellas,
            int capacidadPasajeros, Calendar fechaHoraSalida, int duracion, Obligatorio ob) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        
        ret.valorbooleano = false;
        if (!this.buscarElemento(numero,aerolinea).valorbooleano && cantidadEstrellas >= 1 && cantidadEstrellas <= 5
                && capacidadPasajeros >= 0 && duracion >= 0 && ob.lCiudades.buscarElemento(ciudadOrigen).valorbooleano 
                && ob.lCiudades.buscarElemento(ciudadDestino).valorbooleano &&
                !this.buscarOrigenDestino(ciudadOrigen, ciudadDestino).valorbooleano) {
            ret.valorbooleano = true;
            NodoVuelo nuevo = new NodoVuelo(numero, aerolinea, ciudadOrigen, ciudadDestino, cantidadEstrellas, capacidadPasajeros,fechaHoraSalida,duracion);
            //Control sobre la lista
            if (this.esVacia().valorbooleano == true) {
                //Si esta vacia setea el elemento en primer y ultimo lugar           
                this.setInicio(nuevo);
                this.setUltimo(nuevo);

            } else {
                //Si no esta vacia setea el elemento del inicio a la segunda posicion
                nuevo.setSiguiente(this.inicio);
                //Setea el elemento recibido a la primera posicion
                this.setInicio(nuevo);
            }
            cantVuelos++;
        }

        return ret;
    }

    @Override
    public Retorno mostrar() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        NodoVuelo auxiliar = this.getInicio();
        ret.valorString = "";
        //Control sobre la lista no este vacia
        if (esVacia().valorbooleano == false) {
            //Toma aux como el primer elemento de la lista
            while (auxiliar != null) {
                //Concatena el valor a un string para mostrarlo
                ret.valorString = ret.valorString
                        + auxiliar.getNumero() + " - "
                        + auxiliar.getAerolinea() + " - "
                        + auxiliar.getCiudadOrigen() + " - "
                        + auxiliar.getCiudadDestino() + " - "
                        + auxiliar.getCantidadEstrellas() + " - "
                        + auxiliar.getCapacidadPasajeros() + " - "
                        + auxiliar.getFechaHoraSalida() + " - "
                        + auxiliar.getDuracion() + " - \n";
                //Pasa al siguiente elemento de la lista
                auxiliar = auxiliar.getSiguiente();
            }
        } else {
            ret.valorString = "La lista esta vacia ";
        }
        return ret;
    }

    @Override
    public Retorno cantidadVuelos() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorEntero = this.cantVuelos;
        return ret;
    }

    @Override
    public Retorno buscarElemento(int numeroVuelo, String aerolinea) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        NodoVuelo aux = this.getInicio();
        ret.valorbooleano = false;
        while (aux != null) {
            if (aux.getNumero() == numeroVuelo && aux.getAerolinea().equals(aerolinea)) {
                ret.unNodoVuelo = aux;
                ret.valorbooleano = true;
                return ret;
            }
            aux = aux.getSiguiente();
        }
        return ret;
    }

    public Retorno buscarOrigenDestino(String unOrigen, String unDestino){
        Retorno ret = new Retorno(Retorno.Resultado.OK);
         NodoVuelo aux = this.getInicio();
        ret.valorbooleano = false;
        while (aux != null) {
            if (aux.getCiudadDestino().equals(unDestino) && aux.getCiudadOrigen().equals(unOrigen)) {               
                ret.valorbooleano = true;
                return ret;
            }
            aux = aux.getSiguiente();
        }
        return ret;
    }
    
}
