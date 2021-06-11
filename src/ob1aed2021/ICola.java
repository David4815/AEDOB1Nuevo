
package ob1aed2021;
// estructura FiFo
public interface ICola {
   public Retorno Encolar(int cliente, int numero, String aerolinea);  // Encolar, agregar al final 
   public Retorno desencolar() ;  // desencolar, sacar un elemento del inicio
   public Retorno esVacia();
   public Retorno esllena(); 
   public Retorno  cantelementos() ;  // cantidad de elementos
   public Retorno  frente();   //Mostrar el frente de la cola   
   public Retorno mostrar();
   public Retorno buscarElemento(int cliente, int numero, String aerolinea);
   public Retorno borrarEnCola(int cliente, int numero, String aerolinea);
   public Retorno borrarUltimo();
   public Retorno borrarInicio();
}
