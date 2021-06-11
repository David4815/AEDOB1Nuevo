
package ob1aed2021;

public class ListaCola implements ICola {
    int maximo;         // el maximo que aceptado en la cola
    int cantelementos; //la cantidad de elementos que tiene la pila 
    NodoCola primero;
    NodoCola ultimo;

    public ListaCola(int maximo ) {
        if (maximo==0)
           this.maximo = Integer.MAX_VALUE;
        else
           this.setMaximo(maximo);
        
        this.cantelementos = 0;
        this.primero = null;
        this.ultimo = null;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public int getCantelementos() {
        return cantelementos;
    }

    public void setCantelementos(int cantelementos) {
        this.cantelementos = cantelementos;
    }

    public NodoCola getPrimero() {
        return primero;
    }

    public void setPrimero(NodoCola primero) {
        this.primero = primero;
    }

    public NodoCola getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoCola ultimo) {
        this.ultimo = ultimo;
    }

    @Override
    public Retorno Encolar(int cliente, int numero, String aerolinea) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano = false;
        NodoCola nuevo = new NodoCola(cliente,numero,aerolinea);
        if (!this.esllena().valorbooleano){
            if (this.esVacia().valorbooleano){
                this.setPrimero(nuevo);
                this.setUltimo(nuevo);
            }else{
                this.ultimo.setSiguiente(nuevo);
                this.setUltimo(nuevo);
            
            }
             this.cantelementos=this.cantelementos+1; 
             ret.valorbooleano = true;
        }
        return ret;
    }

    @Override
    public Retorno desencolar() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano = false;
        if (!this.esVacia().valorbooleano){
            ret.unNodoCola = this.primero;
            if (this.cantelementos==1){
                this.setPrimero(null);
                this.setUltimo(null);                               
            }
            else{
                this.setPrimero(this.getPrimero().getSiguiente());               
            }
            this.cantelementos=this.cantelementos-1;
          ret.valorbooleano = true;
        }
        return ret;
    }

    @Override
    public Retorno esVacia() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano = this.getPrimero() == null;
        return ret;
    }

    @Override
    public Retorno esllena() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
//        if (this.getMaximo()==0)
//            return false;
        ret.valorbooleano =  this.getCantelementos()==this.getMaximo();
        return ret;
    }

    @Override
    public Retorno cantelementos() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
         ret.valorEntero = this.getCantelementos();
         return ret;
    }
//importante
    @Override
    public Retorno frente() {
         Retorno ret = new Retorno(Retorno.Resultado.OK);
         
        if (!this.esVacia().valorbooleano){
            ret.unNodoCola =  this.getPrimero();
            return ret;
        }
        else
            return null;

    }

    
    @Override
    public Retorno mostrar() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = "\n";
        NodoCola aux = this.getPrimero();
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
        NodoCola aux = this.getPrimero();
        while (aux != null) {
            if (aux.getCliente()==cliente && aux.getNumero()==numero && aux.getAerolinea().equals(aerolinea)) {
                ret.unNodoCola = aux;
                return ret;
            }
            aux = aux.getSiguiente();
        }
        return ret;
    }

    @Override
    public Retorno borrarEnCola(int cliente, int numero, String aerolinea) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        NodoCola aux = this.getPrimero();
        ret.valorbooleano = false;  
        NodoCola buscado = buscarElemento(cliente,numero,aerolinea).unNodoCola;

        if (buscado != null) {
            if (this.primero == buscado) {
                this.borrarInicio();
            } else {
                if (this.ultimo == buscado) {
                    this.borrarUltimo();
                } else {

                    while (aux.getSiguiente() != buscado) {

                        aux = aux.getSiguiente();
                    }
                    aux.setSiguiente(buscado.getSiguiente());
                    this.cantelementos = this.cantelementos - 1;
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
            if (this.getPrimero() == this.getUltimo()) {
                this.setPrimero(null);
                this.setUltimo(null);
            } else {
                this.setPrimero(this.primero.getSiguiente());
            }
            this.cantelementos = this.cantelementos - 1;
        } else {
            System.out.println("La lista esta vacia ");
        }
        return ret;
    }

    @Override
    public Retorno borrarUltimo() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        if (esVacia().valorbooleano == false) {
            if (this.getPrimero() == this.getUltimo()) {
                this.setPrimero(null);
                this.setUltimo(null);
            } else {
                NodoCola aux = this.getPrimero();
                while (aux.getSiguiente() != this.getUltimo()) {
                    aux = aux.getSiguiente();
                }

                aux.setSiguiente(null); // aux.siguiente= null
                this.setUltimo(aux);   // this.ultimo=aux
            }
            this.cantelementos = this.cantelementos - 1;
        }
        return ret;
    }
}
