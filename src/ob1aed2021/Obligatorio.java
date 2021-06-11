/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ob1aed2021;

import java.util.Calendar;
import java.util.HashSet;

/**
 *
 * @author 4815s
 */
public class Obligatorio implements IObligatorio {

//    static private Obligatorio singleton = null;
// 
//     private Obligatorio() { }
// 
//     static public Obligatorio getSingleton() {
// 
//         if (singleton == null) {
//             singleton = new Obligatorio();
//         }
//         return singleton;\\
//     }
// 
//     public String metodo() {\\
//         return "Singleton instanciado bajo demanda";
//     }
//    HAY QUE USAR SINGLETON, COMO SE MANTIENEN LAS LISTAS EN MEMORIA
//      DESTRUIR SISTEMA ES PONER TODO EN NULL
//    LOS METODOS ESTAN EN LA INTERFACE OBLIGATORIO Y EN CADA LISTA
//    CIUDAD PAIS QUE RELACION HAY
//    FECHA ES LA FORMA CORRECTA CON CALENDAR GREG
//     EN DONDE SE USARIA RECURSIVIDAD
//    SERVICIOS Y COMENTARIOS SON LISTAS DENTRO DE VUELO
//    SOLO UNA AEROLINEA PUEDE OFRECER UN VUELO CON MISMA CIUDAD ORIGEN Y DESTINO
//    CREAR NODOS DENTRO DEL RETORNO !!!!
//    ListaCiudades lCiudades = new ListaCiudades();
//    ListaVuelo lVuelos = new ListaVuelo();
    public ListaCiudades lCiudades;
    public ListaVuelo lVuelos;
    int[][] mapa;
    int cantidadCiudades;

    @Override
    public Retorno crearSistemaReservas() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        this.lCiudades = new ListaCiudades();
        this.lVuelos = new ListaVuelo();

        ret.valorbooleano = true;
        return ret;
    }

    public Obligatorio() {
        crearSistemaReservas();
    }

    public void setlCiudades(ListaCiudades lCiudades) {
        this.lCiudades = lCiudades;
    }

    public void setlVuelos(ListaVuelo lVuelos) {
        this.lVuelos = lVuelos;
    }

    public ListaCiudades getlCiudades() {
        return lCiudades;
    }

    public ListaVuelo getlVuelos() {
        return lVuelos;
    }

    @Override
    public Retorno destruirSistemaReservas() {

        Retorno ret = new Retorno(Retorno.Resultado.OK);
        this.lCiudades = null;
        this.lVuelos = null;
        this.mapa = null;
        this.cantidadCiudades = 0;

        ret.valorbooleano = true;
        return ret;
    }

    @Override
    public Retorno registrarCiudad(int NroCiudad, String Ciudad) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        ret.valorbooleano = lCiudades.agregarciudad(Ciudad, NroCiudad).valorbooleano;

        return ret;
    }

    @Override
    public Retorno eliminarCiudad(int NroCiudad, String Ciudad) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        ret.valorbooleano = lCiudades.eliminarElemento(Ciudad, NroCiudad).valorbooleano;

        return ret;
    }

    @Override
    public Retorno registrarVuelo(int numero, String aerolinea, String ciudadOrigen, String ciudadDestino, int estrellas, int capacidad, Calendar fechaHoraSalida, int duracion) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        ret.valorbooleano = lVuelos.agregarVuelo(numero, aerolinea, ciudadOrigen, ciudadDestino, estrellas, capacidad, fechaHoraSalida, duracion, this).valorbooleano;

        return ret;
    }

    @Override
    public Retorno ingresarServicio(String aerolinea, int numero, String servicio) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
//       chequear que lVuelos.buscarElemento(numero, aerolinea) no sea null

        ret.valorbooleano = lVuelos.buscarElemento(numero, aerolinea).unNodoVuelo.getLs().agregarServicio(servicio, this).valorbooleano;

        return ret;
    }

    @Override
    public Retorno borrarServicio(String aerolinea, int numero, String servicio) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano = false;
        ret.valorString = "No se encontro el Vuelo";

        NodoVuelo unNodoVuelo = lVuelos.buscarElemento(numero, aerolinea).unNodoVuelo;

        if (unNodoVuelo != null) {
            ret.valorString = "Se encontro el Vuelo pero no se borro servicio por que no existe el servicio";
            if (unNodoVuelo.getLs().borrarServicio(aerolinea, numero, servicio, this).valorbooleano) {
                ret.valorString = "Se borro el servicio";
                ret.valorbooleano = true;
            }

        }

        return ret;
    }

    @Override
    public Retorno ingresarComentario(String aerolinea, int numero, String comentario, int ranking) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorbooleano = false;
        ret.valorString = "No se encontro el Vuelo";

        NodoVuelo unNodoVuelo = lVuelos.buscarElemento(numero, aerolinea).unNodoVuelo;
//        IMPORTATNE DONDE DA EL ERROR COMO SE MUESTRA
        if (unNodoVuelo != null && ranking >= 0 && ranking <= 5) {
            ret.valorbooleano = unNodoVuelo.getLc().agregarComentario(comentario, ranking).valorbooleano;

            ret.valorString = "Se agrego su comentario al vuelo";
        }
        return ret;
    }

    @Override
    public Retorno realizarReserva(int cliente, int numero, String aerolinea) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        ret.valorbooleano = this.lVuelos.buscarElemento(numero, aerolinea).unNodoVuelo.getLr().agregarReserva(cliente, numero, aerolinea).valorbooleano;
        if (!ret.valorbooleano) {
            ret.valorbooleano = this.lVuelos.
                    buscarElemento(numero, aerolinea).unNodoVuelo.getLcola().Encolar(cliente, numero, aerolinea).valorbooleano;
        }

        return ret;
    }

    @Override
    public Retorno cancelarReserva(int cliente, int numero, String aerolinea) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        boolean esLlenaReservas = this.lVuelos.buscarElemento(numero, aerolinea).unNodoVuelo.getLr().esLlena().valorbooleano;
        boolean esVaciaCola = this.lVuelos.buscarElemento(numero, aerolinea).unNodoVuelo.getLcola().esVacia().valorbooleano;
        ret.valorbooleano = true;
        if (esLlenaReservas && !esVaciaCola) {
            NodoCola unNodoCola = this.lVuelos.buscarElemento(numero, aerolinea).unNodoVuelo.getLcola().buscarElemento(cliente, numero, aerolinea).unNodoCola;
            NodoReserva unNodoReserva = this.lVuelos.buscarElemento(numero, aerolinea).unNodoVuelo.getLr().buscarElemento(cliente, numero, aerolinea).unNodoReserva;
            if (unNodoCola == null && unNodoReserva == null) {
                ret.valorbooleano = false;
                return ret;
            } else if (unNodoReserva != null) {
                this.lVuelos.buscarElemento(numero, aerolinea).unNodoVuelo.getLr().
                borrarReserva(cliente, numero, aerolinea);
                NodoCola otroNodoCola = this.lVuelos.buscarElemento(numero, aerolinea).unNodoVuelo.
                getLcola().desencolar().unNodoCola;
                this.lVuelos.buscarElemento(numero, aerolinea).unNodoVuelo.getLr()
                .agregarReserva(otroNodoCola.getCliente(), otroNodoCola.getNumero(), otroNodoCola.getAerolinea());

            } else if (unNodoCola != null && unNodoReserva == null) {
                this.lVuelos.buscarElemento(numero, aerolinea).unNodoVuelo.getLcola().borrarEnCola(cliente, numero, aerolinea);
            }

        } else if (esVaciaCola) {
            ret.valorbooleano = this.lVuelos.buscarElemento(numero, aerolinea).unNodoVuelo.getLr().borrarReserva(cliente, numero, aerolinea).valorbooleano;
        }

        return ret;
    }

    @Override
    public Retorno listarServicios(int numero, String aerolinea) {
          Retorno ret = new Retorno(Retorno.Resultado.OK);
        NodoVuelo unVuelo = lVuelos.buscarElemento(numero, aerolinea).unNodoVuelo;
        ret.valorString = unVuelo.getLs().mostrar().valorString;
        if (ret.valorString.equals("\n")) {
            ret.valorString = "No se han agregado servicios al vuelo numero " + numero + " de la aerolinea " + aerolinea + ".";
        }
        return ret;
    }

    @Override
    public Retorno listarVuelosAerolinea(String aerolinea) {
        Retorno ret = new Retorno(Retorno.Resultado.OK); 
        ListaVuelo lVuelosBuscada = new ListaVuelo();
        NodoVuelo nodoVueloAux = lVuelos.getInicio();
         while(nodoVueloAux!=null){
             if(nodoVueloAux.getAerolinea().equals(aerolinea)){
                 lVuelosBuscada.agregarVuelo(
                         nodoVueloAux.getNumero(),
                         aerolinea,
                         nodoVueloAux.getCiudadOrigen(),
                         nodoVueloAux.getCiudadDestino(),
                         nodoVueloAux.getCantidadEstrellas(),
                         nodoVueloAux.getCapacidadPasajeros(),
                         nodoVueloAux.getFechaHoraSalida(),
                         nodoVueloAux.getDuracion(),                        
                         this);
                 
                lVuelosBuscada.buscarElemento(nodoVueloAux.getNumero(), aerolinea).unNodoVuelo.setLc(nodoVueloAux.getLc());
                 
             }
             
             nodoVueloAux = nodoVueloAux.getSiguiente();
         }
         ret.valorString = lVuelosBuscada.MostrarVuelosXAerolineaXCiudadXRanking(aerolinea).valorString;
        
        return ret;
    }

    @Override
    public Retorno listarAerolineasRanking() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Retorno listarComentarios(int numero, String aerolinea) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        NodoVuelo unVuelo = lVuelos.buscarElemento(numero, aerolinea).unNodoVuelo;
        ret.valorString = unVuelo.getLc().mostrar().valorString;
        if (ret.valorString.equals("\n")) {
            ret.valorString = "No se han agregado comentarios al vuelo numero " + numero + " de la aerolinea " + aerolinea + ".";
        }
        return ret;
    }

    @Override
    public Retorno listarEspera(int numero, String aerolinea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Retorno mostrarDuraciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Retorno CargarDistancias(int[][] Mapa, String ciudadOrigen, String Ciudaddestino, int duracion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Retorno BuscarCamino(int[][] Mapa, String origen, String destino) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
