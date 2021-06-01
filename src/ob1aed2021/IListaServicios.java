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
public interface IListaServicios {
     public Retorno esVacia();
    public Retorno agregarServicio(String servicio,Obligatorio ob);
    public Retorno borrarUltimo();
    public Retorno mostrar();
//   public Retorno cantidadServicios();
    public Retorno buscarElemento(String servicio);
    public Retorno borrarServicio(String aerolinea, int numero, String servicio,Obligatorio ob);
    public Retorno  borrarInicio();
}
