/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ob1aed2021;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author 4815s
 */
public class OblMarzo2021 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        Prueba p = new Prueba();
        Obligatorio o = new Obligatorio();
        juegodeprueba(p, o);

    }

    public static void juegodeprueba(Prueba p, Obligatorio o) {
//        

        Calendar cal = new GregorianCalendar(2016, 7, 5);

        p.ver(o.registrarCiudad(1, "Montevideo").resultado, Retorno.Resultado.OK, "Se registro Montevideo");
        p.ver(o.registrarCiudad(2, "Buenos Aires").resultado, Retorno.Resultado.OK, "Se registro Buenos Aires");
        p.ver(o.registrarCiudad(3, "San Pablo").resultado, Retorno.Resultado.OK, "Se registro San Pablo");
        p.ver(o.registrarCiudad(4, "Lima").resultado, Retorno.Resultado.OK, "Se registro Lima");
        p.ver(o.registrarCiudad(5, "La Paz").resultado, Retorno.Resultado.OK, "Se registro La Paz");
        p.ver(o.registrarCiudad(6, "Panama").resultado, Retorno.Resultado.OK, "Se registro Panama");
        p.ver(o.registrarCiudad(7, "New York").resultado, Retorno.Resultado.OK, "Se registro New York");

        p.ver(o.registrarCiudad(2, "Buenos Aires").resultado, Retorno.Resultado.ERROR, "Se intenta registrar Buenos Aires que ya existe");

        p.ver(o.registrarVuelo(3, "Copa Airlines", "Montevideo", "Panama", 5, 230, cal, 8).resultado, Retorno.Resultado.OK, "Se registro vuelo  Montevideo-San Pablo ");
        p.ver(o.registrarVuelo(2, "Gol", "Montevideo", "San Pablo", 3, 250, cal, 1).resultado, Retorno.Resultado.OK, "Se registro vuelo  Montevideo-San Pablo ");
        p.ver(o.registrarVuelo(1, "Latam", "Montevideo", "Buenos Aires", 4, 4, cal, 2).resultado, Retorno.Resultado.OK, "Se registro vuelo Montevideo-Buenos aires");
        p.ver(o.registrarVuelo(4, "Latam", "Montevideo", "La Paz", 4, 4, cal, 2).resultado, Retorno.Resultado.OK, "Se registro vuelo Montevideo-Buenos aires");
         p.ver(o.registrarVuelo(5, "Latam", "Panama", "La Paz", 4, 4, cal, 2).resultado, Retorno.Resultado.OK, "Se registro vuelo Montevideo-Buenos aires");
         p.ver(o.registrarVuelo(6, "Latam", "Panama", "La Paz", 4, 4, cal, 2).resultado, Retorno.Resultado.OK, "Se registro vuelo Montevideo-Buenos aires");
//                p.ver(o.lVuelos.buscarElemento(1, "Latam").unNodoVuelo.getLr().agregarReserva(2, 1, "Latam").resultado,
//                Retorno.Resultado.OK, 
//               o.lVuelos.buscarElemento(1, "Latam").unNodoVuelo.getLr().agregarReserva(2, 1, "Latam").valorString);
//                p.ver(o.lVuelos.buscarElemento(1, "Latam").unNodoVuelo.getLr().agregarReserva(1, 1, "Latam").resultado,
//                Retorno.Resultado.OK, 
//               o.lVuelos.buscarElemento(1, "Latam").unNodoVuelo.getLr().agregarReserva(1, 1, "Latam").valorString);
        
               
                
        
        p.ver(o.ingresarServicio("Latam", 1, "Mascostas").resultado, Retorno.Resultado.OK, "Se agrego el servicio Mascostas al Vuelo 1 de LATAM");
        p.ver(o.ingresarServicio("Latam", 1, "Aire Acondicionado").resultado, Retorno.Resultado.OK, "Se agrego el servicio Aire Acondicionado al Vuelo 1 de LATAM");
        p.ver(o.ingresarServicio("Latam", 1, "Equipaje Extra").resultado, Retorno.Resultado.OK, "Se agrego el servicio Equipaje Extra al Vuelo 1 de LATAM");
        p.ver(o.ingresarServicio("Latam", 1, "Comida Vegana").resultado, Retorno.Resultado.OK, "Se agrego el servicio Comida Vegana al Vuelo 1 de LATAM");
        
        p.ver(o.ingresarComentario("Latam", 1, "Un gran viaje1",4).resultado, Retorno.Resultado.OK, "Se un comentario un gran viaje");
        p.ver(o.ingresarComentario("Latam", 1, "Un gran viaje2",2).resultado, Retorno.Resultado.OK, "Se un comentario un gran viaje2");
        p.ver(o.ingresarComentario("Latam", 1, "Un gran viaje3",1).resultado, Retorno.Resultado.OK, "Se un comentario un gran viaje3");
         p.ver(o.ingresarComentario("Latam", 4, "Un gran viaje3",1).resultado, Retorno.Resultado.OK, "Se un comentario un gran viaje3");
        
        
        p.ver(o.ingresarComentario("Gol", 2, "Un gran viaje4",1).resultado, Retorno.Resultado.OK, "Se un comentario un gran viaje4");
        p.ver(o.ingresarComentario("Gol", 2, "Un gran viaje5",2).resultado, Retorno.Resultado.OK, "Se un comentario un gran viaje5");
        p.ver(o.ingresarComentario("Gol", 2, "Un gran viaje6",3).resultado, Retorno.Resultado.OK, "Se un comentario un gran viaje6");
         
        p.ver(o.borrarServicio("Latam", 1, "Aire Acondicionado").resultado, Retorno.Resultado.OK, "Se borro el servicio Aire Acondicionado del Vuelo 1 de LATAM ");
        p.ver(o.lVuelos.getInicio().getLs().mostrar().resultado, Retorno.Resultado.OK, "Lista servicios vuelo LATAM: " + o.lVuelos.getInicio().getLs().mostrar().valorString);
        p.ver(o.lCiudades.mostrar().resultado, Retorno.Resultado.OK, "\n\nLista ciudades : \n" + o.lCiudades.mostrar().valorString);
        p.ver(o.lVuelos.getInicio().getLc().mostrar().resultado, Retorno.Resultado.OK, "\n\nLista Comentarios : \n" + o.lVuelos.getInicio().getLc().mostrar().valorString);
        
        
        
        //----------------------------
//        p.ver(o.crearSistemaReservas().resultado, Retorno.Resultado.OK, "se creo el sistema de reservas");
        p.ver(o.registrarCiudad(1, "A").resultado, Retorno.Resultado.OK, "Se registro A");
        p.ver(o.registrarCiudad(0, "B").resultado, Retorno.Resultado.OK, "Se registro B");
        p.ver(o.registrarCiudad(2, "C").resultado, Retorno.Resultado.OK, "Se registro C");
        p.ver(o.registrarCiudad(3, "D").resultado, Retorno.Resultado.OK, "Se registro D");
        p.ver(o.registrarCiudad(4, "E").resultado, Retorno.Resultado.OK, "Se registro E");

        p.ver(o.registrarCiudad(5, "F").resultado, Retorno.Resultado.ERROR, "Se intenta registrar F - excede limite");
        p.ver(o.registrarCiudad(6, "G").resultado, Retorno.Resultado.ERROR, "Se intenta registrar g - excede limite");
        
         
         p.ver(o.realizarReserva(1, 1, "Latam").resultado,
                Retorno.Resultado.OK,"Se registro reserva");     
         p.ver(o.realizarReserva(2, 1, "Latam").resultado,
                Retorno.Resultado.OK,"Se registro reserva");
           p.ver(o.realizarReserva(3, 1, "Latam").resultado,
                Retorno.Resultado.OK,"Se registro reserva");
             p.ver(o.realizarReserva(4, 1, "Latam").resultado,
                Retorno.Resultado.OK,"Se registro reserva");
             
             
             p.ver(o.realizarReserva(5, 1, "Latam").resultado,
                Retorno.Resultado.OK,"Se registro reserva");   
         p.ver(o.realizarReserva(4, 1, "Latam").resultado,
                Retorno.Resultado.OK,"Se registro reserva");
           p.ver(o.realizarReserva(7, 1, "Latam").resultado,
                Retorno.Resultado.OK,"Se registro reserva");
             p.ver(o.realizarReserva(8, 1, "Latam").resultado,
                Retorno.Resultado.OK,"Se registro reserva");
           
           
            p.ver(o.cancelarReserva(4, 1, "Latam").resultado,
                Retorno.Resultado.OK,"Se registro reserva");
//            p.ver(o.cancelarReserva(2, 1, "Latam").resultado,
//                Retorno.Resultado.OK,"Se registro reserva");
//             p.ver(o.cancelarReserva(4, 1, "Latam").resultado,
//                Retorno.Resultado.OK,"Se registro reserva");
//             p.ver(o.cancelarReserva(7, 1, "Latam").resultado,
//                Retorno.Resultado.OK,"Se registro reserva");
//          p.ver(o.lVuelos.buscarElemento(1, "Latam").unNodoVuelo.getLr().borrarReserva(1, 1, "Latam").resultado,
//                Retorno.Resultado.OK,"Se registro reserva");
        
        //-----------------------------
        // ver si agrega bien las ciudades al sistema de reservas  
        System.out.println("Listado de ciudades ingresadas");
         p.ver(o.lCiudades.mostrar().resultado, Retorno.Resultado.OK, "\n\nLista ciudades : \n" + o.lCiudades.mostrar().valorString);
         p.ver(o.lVuelos.mostrar().resultado, Retorno.Resultado.OK, "\n\nLista ciudades : \n" + o.lVuelos.mostrar().valorString);
        p.ver(o.listarComentarios(1,"Latam").resultado, Retorno.Resultado.OK,o.listarComentarios(1,"Latam").valorString);
          p.ver(o.lVuelos.buscarElemento(1, "Latam").unNodoVuelo.getLr().mostrar().resultado,
                Retorno.Resultado.OK, 
               o.lVuelos.buscarElemento(1, "Latam").unNodoVuelo.getLr().mostrar().valorString);
          
          p.ver(o.lVuelos.buscarElemento(1, "Latam").unNodoVuelo.getLcola().mostrar().resultado,
                Retorno.Resultado.OK, 
               o.lVuelos.buscarElemento(1, "Latam").unNodoVuelo.getLcola().mostrar().valorString);
          
          
          p.ver(o.listarServicios(1,"Latam").resultado, Retorno.Resultado.OK,o.listarServicios(1,"Latam").valorString);
          p.ver(o.lVuelos.buscarElemento(1, "Latam").unNodoVuelo.calcularRanking().resultado,
                Retorno.Resultado.OK, 
               Integer.toString(o.lVuelos.buscarElemento(1, "Latam").unNodoVuelo.calcularRanking().valorEntero));
          
          p.ver(o.listarVuelosAerolinea("Latam").resultado, Retorno.Resultado.OK,o.listarVuelosAerolinea("Latam").valorString);
          
             
//         NodoVuelo n = o.lVuelos.getInicio();
//         while(n!=null){
//             System.out.println(n.getLc().mostrar().valorString); 
//             n = n.getSiguiente();
//             
//         }
//         o.lVuelos.getUltimo().getLc().mostrar();
         p.inicializarResultadosPrueba();
    
    }

}
