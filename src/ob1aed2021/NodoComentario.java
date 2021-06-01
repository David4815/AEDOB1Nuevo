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
public class NodoComentario {
    
    
   
    private String Comentario;
    private int ranking;
    NodoComentario siguiente;

     public NodoComentario(String Comentario, int ranking) {    
        this.Comentario = Comentario;
        this.ranking = ranking;
        this.siguiente = null;
    }
    
    
    

    public String getComentario() {
        return Comentario;
    }

    public int getRanking() {
        return ranking;
    }

    public NodoComentario getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoComentario siguiente) {
        this.siguiente = siguiente;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

   
    
    
}
