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
public class ListaServicios implements IListaServicios {

    NodoServicio inicio;
    NodoServicio ultimo;
    int cantServicios;

    public ListaServicios() {
        this.inicio = null;
        this.ultimo = null;
        this.cantServicios = 0;
    }

    public NodoServicio getInicio() {
        return inicio;
    }

    public NodoServicio getUltimo() {
        return ultimo;
    }

    public int getCantServicios() {
        return cantServicios;
    }

    public void setInicio(NodoServicio inicio) {
        this.inicio = inicio;
    }

    public void setUltimo(NodoServicio ultimo) {
        this.ultimo = ultimo;
    }

    public void setCantServicios(int cantServicios) {
        this.cantServicios = cantServicios;
    }

    @Override
    public Retorno esVacia() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano = this.getInicio() == null;
        return ret;
    }

    @Override
    public Retorno agregarServicio(String servicio, Obligatorio ob) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano = false;
        NodoServicio nuevo = new NodoServicio(servicio);
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
        cantServicios++;
        return ret;
    }

    @Override
    public Retorno mostrar() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        int cont=1;
        ret.valorString = "\n";
        NodoServicio aux = this.getInicio();
        while (aux != null) {
           
            ret.valorString = ret.valorString + cont + " - " + aux.getServicio() + "\n";
            aux = aux.getSiguiente();
            cont++;
        }
        return ret;
    }


    @Override
    public Retorno buscarElemento(String servicio) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        NodoServicio aux = this.getInicio();
        while (aux != null) {
            if (aux.getServicio().equals(servicio)) {
                ret.unNodoServicio = aux;
                return ret;
            }
            aux = aux.getSiguiente();
        }
        return ret;

    }

    @Override
//   IMPORTANTE aerolinea,numero y Obligatoiro estan de mas 
    public Retorno borrarServicio(String aerolinea, int numero, String servicio, Obligatorio ob) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        NodoServicio aux = this.inicio;
        
        NodoServicio buscado = buscarElemento(servicio).unNodoServicio;

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
                    this.cantServicios = this.cantServicios - 1;
                }
            }

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
            this.cantServicios = this.cantServicios - 1;
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
                NodoServicio aux = this.getInicio();
                while (aux.getSiguiente() != this.getUltimo()) {
                    aux = aux.getSiguiente();
                }

                aux.setSiguiente(null); // aux.siguiente= null
                this.setUltimo(aux);   // this.ultimo=aux
            }
            this.cantServicios = this.cantServicios - 1;
        }
        return ret;
    }

}
