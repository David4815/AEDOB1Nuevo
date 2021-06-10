
package ob1aed2021;

public class NodoCola {
   
    

    private int cliente;
    private int numero;
    private String aerolinea;
    NodoCola siguiente;

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }

    public NodoCola(int cliente, int numero, String aerolinea) {
        this.cliente = cliente;
        this.numero = numero;
        this.aerolinea = aerolinea;
        this.siguiente = null;
    }

    public int getCliente() {
        return cliente;
    }

    public int getNumero() {
        return numero;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }
    
    
}
