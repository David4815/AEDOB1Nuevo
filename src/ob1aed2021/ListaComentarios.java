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
public class ListaComentarios implements IListaComentarios {
    
    NodoComentario inicio;
    NodoComentario ultimo;
    int cantComentarios;

    
    public NodoComentario getInicio() {
        return inicio;
    }

    public NodoComentario getUltimo() {
        return ultimo;
    }

    public ListaComentarios() {
        this.inicio = null;
        this.ultimo = null;
        this.cantComentarios = 0;
    }

    public void setInicio(NodoComentario inicio) {
        this.inicio = inicio;
    }

    public void setUltimo(NodoComentario ultimo) {
        this.ultimo = ultimo;
    }

    public void setCantComentarios(int cantCiudades) {
        this.cantComentarios = cantCiudades;
    }

    public int getCantComentarios() {
        return cantComentarios;
    }
    

    @Override
    public Retorno esVacia() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano = this.getInicio() == null;
        return ret;
    }

    @Override
    public Retorno agregarComentario(String comentario, int ranking) {
       Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano = false;
        NodoComentario nuevo = new NodoComentario(comentario,ranking);
        //Control sobre la lista
        if (esVacia().valorbooleano == true) {
            //Si esta vacia setea el elemento en primer y ultimo lugar           
            this.setInicio(nuevo);
            this.setUltimo(nuevo);

        } else {
            //Si no esta vacia setea el elemento del inicio a la segunda posicion
            nuevo.setSiguiente(this.inicio);
            //Setea el elemento recibido a la primera posicion
            this.setInicio(nuevo);
        }
        cantComentarios++;
        return ret;
    }

    @Override
    public Retorno mostrar() {
         Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = "\n";
        int cont = 0;
        NodoComentario aux = this.getInicio();       
        while (aux != null) {
            if(cont==0){
                ret.valorString = ret.valorString + "N" + " - " + "Comentario N" + " - " + "Ranking N" + "  \n";
                cont++;
            }
            
            ret.valorString = ret.valorString + cont + " - " +  aux.getComentario() + " - " + aux.getRanking() + "  \n";
            aux = aux.getSiguiente();
             cont++;
        }
        
        return ret;
    }
    
}
