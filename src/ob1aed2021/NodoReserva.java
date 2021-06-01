/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ob1aed2021;

public class NodoReserva {

    private int cliente;
    private int numero;
    private String aerolinea;

    public NodoReserva(int cliente, int numero, String aerolinea) {
        this.cliente = cliente;
        this.numero = numero;
        this.aerolinea = aerolinea;
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
