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
public interface IListaComentarios {
    
    public Retorno esVacia();
    public Retorno agregarComentario(String comentario,int ranking);   
    public Retorno mostrar();

}
