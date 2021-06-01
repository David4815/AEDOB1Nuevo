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
public interface IListaVuelo {
    
    public Retorno esVacia();
    public Retorno agregarVuelo(int numero, String aerolinea, String ciudadOrigen, String ciudadDestino, int cantidadEstrellas, int capacidadPasajeros, Calendar fechaHoraSalida, int duracion, Obligatorio ob);
//    public Retorno borrarInicio();
//    public Retorno borrarUltimo();
    public Retorno mostrar();
    public Retorno cantidadVuelos();
    public Retorno buscarElemento(int numeroVuelo, String aerolinea);
//    public Retorno eliminarElemento(String unNombreCiudad, int id);
    
}
 