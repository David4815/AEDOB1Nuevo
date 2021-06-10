
package ob1aed2021;


public interface IListaReservas {
    
    public Retorno esLlena();
    public Retorno esVacia();
    public Retorno agregarReserva(int cliente,int numero, String aerolinea);
    public Retorno mostrar();
    public Retorno buscarElemento(int cliente,int numero, String aerolinea);
    public Retorno borrarReserva(int cliente,int numero, String aerolinea);
     public Retorno borrarInicio();
     public Retorno borrarUltimo();
    
  ;
}
