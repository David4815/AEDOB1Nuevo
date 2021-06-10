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
public class ListaReservas implements IListaReservas {

    NodoReserva inicio;
    NodoReserva ultimo;
    int cantidadReservas;
    int maxCantReservas;
//    NodoReserva anterior;

    public int getCantidadReservas() {
        return cantidadReservas;
    }

    public void setCantidadReservas(int cantidadReservas) {
        this.cantidadReservas = cantidadReservas;
    }

    public NodoReserva getInicio() {
        return inicio;
    }

    public void setInicio(NodoReserva inicio) {
        this.inicio = inicio;
    }

    public NodoReserva getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoReserva ultimo) {
        this.ultimo = ultimo;
    }

    public ListaReservas(int cantidadMax) {
        this.inicio = null;
        this.ultimo = null;
        this.cantidadReservas = 0;
        this.maxCantReservas = cantidadMax;
    }

    public int getMaxCantReservas() {
        return maxCantReservas;
    }

    public void setMaxCantReservas(int maxCantReservas) {
        this.maxCantReservas = maxCantReservas;
    }
    
    
    
    @Override
    public Retorno esLlena() {
         Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano = this.cantidadReservas==this.maxCantReservas;
        return ret;
    }

    @Override
    public Retorno esVacia() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano = this.getInicio() == null;
        return ret;
    }

    @Override
    public Retorno agregarReserva(int cliente, int numero, String aerolinea) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano = true;
        NodoReserva nuevo = new NodoReserva(cliente,numero,aerolinea);
        //Control sobre la lista
        if (esVacia().valorbooleano == true) {
            //Si esta vacia setea el elemento en primer y ultimo lugar           
            this.setInicio(nuevo);
            this.setUltimo(nuevo);
            
            

        } else if (esLlena().valorbooleano == true){             
            ret.valorbooleano = false;
            return ret;
        }else
            {
            //Si no esta vacia setea el elemento del inicio a la segunda posicion
            nuevo.setSiguiente(this.inicio);
            //Setea el elemento recibido a la primera posicion
            this.setInicio(nuevo);
            ret.valorbooleano = true;
            
        }
        cantidadReservas++;
        return ret;
    }

    @Override
    public Retorno mostrar() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = "\n";
        NodoReserva aux = this.getInicio();
        while (aux != null) {
            ret.valorString = ret.valorString + aux.getCliente() + " - "
                    + aux.getNumero() + " - " + aux.getAerolinea() + "\n";
            aux = aux.getSiguiente();
        }
        return ret;
    }

    @Override
    public Retorno buscarElemento(int cliente, int numero, String aerolinea) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        NodoReserva aux = this.getInicio();
        while (aux != null) {
            if (aux.getCliente()==cliente && aux.getNumero()==numero && aux.getAerolinea().equals(aerolinea)) {
                ret.unNodoReserva = aux;
                return ret;
            }
            aux = aux.getSiguiente();
        }
        return ret;
    }

    @Override
    public Retorno borrarReserva(int cliente, int numero, String aerolinea) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        NodoReserva aux = this.getInicio();
        ret.valorbooleano = false;  
        NodoReserva buscado = buscarElemento(cliente,numero,aerolinea).unNodoReserva;

        if (buscado != null) {
            if (this.inicio == buscado) {
                this.borrarInicio();
            } else {
                if (this.ultimo == buscado) {
                    this.borrarUltimo();
                } else {

                    while (aux.getSiguiente() != buscado) {

                        aux = aux.getSiguiente();
                    }
                    aux.setSiguiente(buscado.getSiguiente());
                    this.cantidadReservas = this.cantidadReservas - 1;
                }
            }
              ret.valorbooleano = true;  
        }
        return ret;
    }

    
    @Override
    public Retorno borrarInicio() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        if (esVacia().valorbooleano == false) {
            if (this.getInicio() == this.getUltimo()) {
                this.setInicio(null);
                this.setUltimo(null);
            } else {
                this.setInicio(this.inicio.getSiguiente());
            }
            this.cantidadReservas = this.cantidadReservas - 1;
        } else {
            System.out.println("La lista esta vacia ");
        }
        return ret;
    }

    @Override
    public Retorno borrarUltimo() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        if (esVacia().valorbooleano == false) {
            if (this.getInicio() == this.getUltimo()) {
                this.setInicio(null);
                this.setUltimo(null);
            } else {
                NodoReserva aux = this.getInicio();
                while (aux.getSiguiente() != this.getUltimo()) {
                    aux = aux.getSiguiente();
                }

                aux.setSiguiente(null); // aux.siguiente= null
                this.setUltimo(aux);   // this.ultimo=aux
            }
            this.cantidadReservas = this.cantidadReservas - 1;
        }
        return ret;
    }
    
    
    
}
