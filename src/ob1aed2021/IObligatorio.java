
package ob1aed2021;

import java.util.Calendar;


public interface IObligatorio {
    
////    2.1
//    public Retorno crearSistemaReservas();
////    2.2
//    public Retorno destruirSistemaReservas();
////    2.3
//    public Retorno registrarCiudad(String Ciudad);
////    2.4
//    public Retorno eliminarCiudad(String Ciudad);
////    2.5
//    public Retorno registrarVuelo(int numero,String aerolinea,String ciudadOrigen,String ciudadDestino, int estrellas, int capacidad, Calendar fechaSAlida, int duracion);
////    2.6
//    public Retorno ingresarServicio(String aerolinea,int numero,String servicio);
////    2.7
//    public Retorno borrarServicio(String aerolinea,int numero,String servicio);
////    2.8
//    public Retorno ingresarComentario(String aerolinea,int numero,String comentario, int ranking);
////    2.9
//    public Retorno realizarReserva(int cliente,int numero,String aerolinea);
////    2.10
//    public Retorno cancelarReserva(int cliente, int numero, String aerolinea);
////    2.11
//    public Retorno listarServicios(int numero, String aerolinea);
////    2.12
//    public Retorno listarVuelosAerolinea(String aerolinea);
////    2.13
//    public Retorno listarAerolineasRanking();
////    2.14
//    public Retorno listarComentarios(int numero, String aerolinea);
////    2.15
//    public Retorno listarEspera(int numero, String aerolinea);
////    2.16
//    public Retorno mostrarDuraciones();
//
////    2.17
////    Cargar mapa con duraciones de los vuelos para calcular el mejor camino.
//    
////    2.18
//    public Retorno CargarDistancias(int[][] Mapa, String ciudadOrigen, String CiudadDestino, int duracion);
////    2.19
//   public Retorno BuscarCamino ( int [][] Mapa, String origen, String destino);
    
   
    Retorno crearSistemaReservas();  
  Retorno destruirSistemaReservas();
  Retorno registrarCiudad(int NroCiudad, String Ciudad);
  Retorno eliminarCiudad(int NroCiudad, String Ciudad);
  Retorno registrarVuelo(int numero, String aerolinea, String ciudadOrigen, String ciudadDestino, int estrellas, int capacidad, Calendar fechaHoraSalida, int duracion); 
  Retorno ingresarServicio(String aerolinea, int numero, String servicio); 
  Retorno borrarServicio(String aerolinea, int numero, String servicio); 
  Retorno  ingresarComentario(String aerolinea, int numero, String comentario, int ranking); 
  Retorno realizarReserva(int cliente, int numero, String aerolinea); 
  Retorno cancelarReserva(int cliente, int numero, String aerolinea); 
  Retorno listarServicios(int numero, String aerolinea); 
  Retorno listarVuelosAerolinea(String aerolinea);
  Retorno listarAerolineasRanking();
  Retorno listarComentarios(int numero, String aerolinea);
  Retorno listarEspera(int numero, String aerolinea);
  Retorno mostrarDuraciones();
  Retorno CargarDistancias(int[][] Mapa, String ciudadOrigen, String Ciudaddestino, int duracion);
  Retorno  BuscarCamino ( int [][] Mapa, String origen, String destino);
    
    
}
