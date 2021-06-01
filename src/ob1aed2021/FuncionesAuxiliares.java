
package ob1aed2021;

import java.util.Scanner;


public class FuncionesAuxiliares {
          
              
     //Controlar @ en mail
    public boolean controlarArroba(String palabra) {
        
        char arroba = '@';
        int largo = palabra.length();
        int contador = 0;
//        arranco de i=1 por que el primer caracter no puede ser un @
        for (int i = 1; i < largo; i++) {
            if (palabra.charAt(i) == arroba) {
                contador++;
            }
        }
        return contador == 1;
    }


    //METODO PARA INGRESAR STRING
    public String entradaString(String explicacion) {
        String entrada;
        do {

            System.out.println(explicacion);
            Scanner in = new Scanner(System.in);
            entrada = in.nextLine();

        } while (entrada.equals(""));
        return entrada;

    }

    //METODO PARA INGRESAR NUMERO entre max y min
    
    public int entradaInt(String explicacion, int min, int max) {
        int entrada;
        do {
            System.out.println(explicacion);
            Scanner in = new Scanner(System.in);
            entrada = in.nextInt();
        } while (entrada < min || entrada > max);
        return entrada;

    }
    
     //metodo para ingresar un numero entre 1 y 2 y retornar un booleano
    public boolean ingresarNumeroEntre(String descripcion) {
        int valor;
        boolean verdadero = true;
        System.out.println(descripcion);
        Scanner in = new Scanner(System.in);
        do {

            valor = in.nextInt();

            switch (valor) {
                case 1:
                    verdadero = false;
                    break;
                case 2:
                    verdadero = true;
                    break;
                default:
                    System.out.println("Ingrese un numero entre 1 y 2");
                    break;
            }

        } while (valor < 1 || valor > 2);
        return verdadero;
    }
    
    public static double sumar(double num1, double num2){
        double resultado = num1 + num2;
        return resultado;
    } 
 
    public String nombreCompleto(String nombre, String apellido){
        String nom = nombre + " " + apellido;
        return nom;
    }
    
//    //mostrar texto no hay controles ingresados y pedir ingresar 1 o 5
//    public void avisoDeNoControl() {
//        System.out.println("\n No hay controles ingresados "
//                + "(Digite: 1 - Para ingresar dos controles o"
//                + " 5 - Para salir del Programa)");
//        menu();
//    }
//
//    //metodo para ver si se creo control
//    public void hayControl(boolean creoControl) {
//        if (!creoControl) {
//            System.out.println("No se creo control");
//            menu();
//
//        }
//    }



    //SUB MENU PARA INDICADORES
//    public void subMenuIndicadores() {
//        System.out.println("Ingrese la opcion deseada");
//        System.out.println("1 - Mostrar Uso De Marca");
//        System.out.println("2 - Mostrar Soporte Comercial");
//        System.out.println("3 - Ir al MENU PRINCIPAL");
//    }

    //mostrar indicadores
//    public void mostrarIndicadores(Control controlA, Control controlB) {
//        int entrada;
//
//        do {
//            subMenuIndicadores();
//            Scanner in = new Scanner(System.in);
//            entrada = in.nextInt();
//
//            switch (entrada) {
//                case 1:
//
//                    System.out.println("\nPrimer control - Uso de Marca : "
//                            + estadoIndicador(controlA.getUsoDeMarca()));
//                    System.out.println("Segundo Control - Uso de Marca : "
//                            + estadoIndicador(controlB.getUsoDeMarca()));
//
//                    break;
//                case 2:
//                    System.out.println("\nPrimer control - Soporte Comercial : "
//                            + estadoIndicador(controlA.getSoporteComercial()));
//                    System.out.println("Segundo control - Soporte Comercial : "
//                            + estadoIndicador(controlB.getSoporteComercial()));
//
//                    break;
//                case 3:
//                    menu();
//                    break;
//
//                default:
//                    System.out.println("Ingrese un numero entre 1 y 3");
//            }
//
//        } while (entrada != 3);
//    }
//Menu principal

//    public void menu() {
//
//        //MENU
//        System.out.println("\nIngrese la opcion deseada");
//        System.out.println("1 - Registrar Gerente");
//        System.out.println("2 - Registrar Inspector");
//        System.out.println("3 - Registrar Franquicia");
//        System.out.println("4 - Control de Franquicia)");
//        System.out.println("5 - Listado de Franquicias(ordenado decrecientemente por costo");
//        System.out.println("6 - Consultar Franquicias sin controlar en un mes dado");
//        System.out.println("6 - Consultar estado indicadores");
//        System.out.println("6 - Salir");
//    }

   


   
    
}
