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
        p.ver(o.registrarVuelo(1, "Latam", "Montevideo", "Buenos Aires", 4, 200, cal, 2).resultado, Retorno.Resultado.OK, "Se registro vuelo Montevideo-Buenos aires");

        p.ver(o.ingresarServicio("Latam", 1, "Mascostas").resultado, Retorno.Resultado.OK, "Se agrego el servicio Mascostas al Vuelo 1 de LATAM");
        p.ver(o.ingresarServicio("Latam", 1, "Aire Acondicionado").resultado, Retorno.Resultado.OK, "Se agrego el servicio Aire Acondicionado al Vuelo 1 de LATAM");
        p.ver(o.ingresarServicio("Latam", 1, "Equipaje Extra").resultado, Retorno.Resultado.OK, "Se agrego el servicio Equipaje Extra al Vuelo 1 de LATAM");
        p.ver(o.ingresarServicio("Latam", 1, "Comida Vegana").resultado, Retorno.Resultado.OK, "Se agrego el servicio Comida Vegana al Vuelo 1 de LATAM");
        
        p.ver(o.ingresarComentario("Latam", 1, "Un gran viaje1",1).resultado, Retorno.Resultado.OK, "Se un comentario un gran viaje");
        p.ver(o.ingresarComentario("Latam", 1, "Un gran viaje2",2).resultado, Retorno.Resultado.OK, "Se un comentario un gran viaje2");
        p.ver(o.ingresarComentario("Latam", 1, "Un gran viaje6",6).resultado, Retorno.Resultado.OK, "Se un comentario un gran viaje3");
         
        p.ver(o.borrarServicio("Latam", 1, "Aire Acondicionado").resultado, Retorno.Resultado.OK, "Se borro el servicio Aire Acondicionado del Vuelo 1 de LATAM ");
        p.ver(o.lVuelos.getInicio().getLs().mostrar().resultado, Retorno.Resultado.OK, "Lista servicios vuelo LATAM: " + o.lVuelos.getInicio().getLs().mostrar().valorString);
        p.ver(o.lCiudades.mostrar().resultado, Retorno.Resultado.OK, "\n\nLista ciudades : \n" + o.lCiudades.mostrar().valorString);
        p.ver(o.lVuelos.getInicio().getLc().mostrar().resultado, Retorno.Resultado.OK, "\n\nLista Comentarios : \n" + o.lVuelos.getInicio().getLc().mostrar().valorString);
        p.inicializarResultadosPrueba();
    }

}
