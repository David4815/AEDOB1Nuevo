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
public class ListaCiudades implements IListaCiudades {

    NodoCiudad inicio;
    NodoCiudad ultimo;
    int cantCiudades;

    public NodoCiudad getInicio() {
        return inicio;
    }

    public NodoCiudad getUltimo() {
        return ultimo;
    }

    public int getCantCiudades() {
        return cantCiudades;
    }

    public void setInicio(NodoCiudad inicio) {
        this.inicio = inicio;
    }

    public void setUltimo(NodoCiudad ultimo) {
        this.ultimo = ultimo;
    }

    public void setCantCiudades(int cantCiudades) {
        this.cantCiudades = cantCiudades;
    }

    public ListaCiudades() {
        this.inicio = null;
        this.ultimo = null;
        this.cantCiudades = 0;
    }

    @Override
    public Retorno esVacia() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano = this.getInicio() == null;
        return ret;
    }

    @Override
    public Retorno agregarciudad(String nombreCiudad, int id) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano = false;
        if (!this.buscarElemento(nombreCiudad).valorbooleano && !this.buscarElemento2(id).valorbooleano) {
            ret.valorbooleano = true;
            NodoCiudad nuevo = new NodoCiudad(nombreCiudad, id);
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
            cantCiudades++;
        }

        return ret;
    }

    @Override
    public Retorno borrarInicio() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano = false;
        //Controlar la lista si tiene elementos o no
        if (esVacia().valorbooleano == false) {
            ret.valorbooleano = true;
            //Si la lista tiene un solo elemento
            if (this.inicio == this.ultimo) {
                this.setInicio(null);
                this.setUltimo(null);
            } else {
                //Si tiene mas de un elemento setea el inicio al segundo elemento             
                this.setInicio(this.inicio.getSiguiente());
            }
            //Borra uno a la cantidad de elementos
            this.cantCiudades--;
        } else {
            ret.valorString = "La lista esta vacia";
        }
        return ret;
    }

    @Override
    public Retorno borrarUltimo() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano = false;
        if (esVacia().valorbooleano != false) {
            ret.valorbooleano = true;
            if (this.getInicio() == this.getUltimo()) {
                this.setInicio(null);
                this.setUltimo(null);
            } else {
                NodoCiudad aux = this.getInicio();
                while (aux.getSiguiente() != this.getUltimo()) {
                    aux = aux.getSiguiente();
                }

                aux.setSiguiente(null); // aux.siguiente= null
                this.setUltimo(aux);   // this.ultimo=aux
            }
            cantCiudades--;
        }
        return ret;
    }

    @Override
    public Retorno mostrar() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        NodoCiudad auxiliar = this.getInicio();
        ret.valorString = "";
        //Control sobre la lista no este vacia
        if (esVacia().valorbooleano == false) {
            //Toma aux como el primer elemento de la lista
            while (auxiliar != null) {
                //Concatena el valor a un string para mostrarlo
                ret.valorString = ret.valorString + auxiliar.getNombre() + " - " + auxiliar.getId() + " - \n";
                //Pasa al siguiente elemento de la lista
                auxiliar = auxiliar.getSiguiente();
            }
        } else {
            ret.valorString = "La lista esta vacia ";
        }
        return ret;
    }

    @Override
    public Retorno cantidadciudades() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorEntero = this.cantCiudades;
        return ret;
    }


//    public Retorno buscarElemento(String unNombreCiudad, int id) {
//        Retorno ret = new Retorno(Retorno.Resultado.OK);
//        NodoCiudad aux = this.getInicio();
//        ret.valorbooleano = false;
//        ret.valorEntero = 3;
//        while (aux != null) {
//            if (aux.getNombre().equals(unNombreCiudad) && aux.getId() == id) {
//                ret.valorbooleano = true;
//                ret.unNodoCiudad = aux;
//                ret.valorEntero = 0;
//                return ret;
//            }else if(aux.getNombre().equals(unNombreCiudad)){
//                ret.valorEntero=1;
//            }else if(aux.getId()==id){
//                ret.valorEntero=2;
//            }
//            aux = aux.getSiguiente();
//        }
//        return ret;
//
//    }
        @Override
     public Retorno buscarElemento(String unNombreCiudad) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        NodoCiudad aux = this.getInicio();
        ret.valorbooleano = false;
       
        while (aux != null) {
          if(aux.getNombre().equals(unNombreCiudad)){
                
                ret.valorbooleano = true;
                ret.unNodoCiudad = aux;            
        }
          aux = aux.getSiguiente();
        }
        return ret;

    }
     @Override
    public Retorno buscarElemento2(int id) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        NodoCiudad aux = this.getInicio();
        ret.valorbooleano = false;        
        while (aux != null) {
            if(aux.getId()==id){
                 ret.valorbooleano = true;                             
            }
            aux = aux.getSiguiente();
        }
        return ret;

    }
     

    
    

    @Override
    public Retorno eliminarElemento(String unNombreCiudad, int id) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano = false;
        NodoCiudad buscado = this.buscarElemento(unNombreCiudad).unNodoCiudad;
        NodoCiudad aux = this.getInicio();
        if (buscado != null) {
            ret.valorbooleano = true;
            if (this.getInicio() == buscado) {
                this.borrarInicio();
            } else {
                if (this.getUltimo() == buscado) {
                    this.borrarUltimo();
                }
                while (aux.getSiguiente() != buscado) {
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(buscado.getSiguiente());
            }
            cantCiudades--;
        }
        return ret;
    }

}
