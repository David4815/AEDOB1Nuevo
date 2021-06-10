/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ob1aed2021;

/**
 *
 * @author 4815s
 */
public interface IListaCiudades {
    
    public Retorno esVacia();
    public Retorno agregarciudad(String nombreCiudad, int id);
    public Retorno borrarInicio();
    public Retorno borrarUltimo();
    public Retorno mostrar();
    public Retorno cantidadciudades();
    public Retorno buscarElemento(String unNombreCiudad);
    public Retorno buscarElemento2(int id);
    public Retorno eliminarElemento(String unNombreCiudad, int id);
    
    
}
