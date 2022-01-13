package FicherosEmpresa;

import java.io.*;
import java.util.*;

/**
 *Clase que contiene el método principal main  para mostrarnos el
 * menú de la aplicación
 * 
 * @author Daniel Paz Lorenzo
 */
public class MenuGestion {

    public static void main(String[] args) {

        //Bloque declaración de variables globales e instanciación de objetos
        byte op;
        boolean m, e, c, d;
        Scanner teclado = new Scanner(System.in);
               
        //DatosCliente fichero=new DatosCliente();
        //ArrayList clienteArray = new ArrayList();

        do {
            m = true;

            System.out.println("----------MENÚ DE DATOS DE CLIENTE----------");
            System.out.println("1.- Añadir clientes");
            System.out.println("2.- Listar clientes");
            System.out.println("3.- Buscar cliente");
            System.out.println("4.- Borrar cliente");
            System.out.println("5.- Borrar fichero de clientes completamente");
            System.out.println("6.- Salir de la aplicación");
            System.out.println("Introduzca una opción: ");
            do {
                try {
                    e = false;
                    op = teclado.nextByte();

                    switch (op) {
                        case 1:                            
                            MetodosFicheros.añadirCliente();                            
                            break;
                        case 2:
                            MetodosFicheros.listarClientes();
                            break;
                        case 3:                            
                            MetodosFicheros.buscarCliente();
                            break;
                        case 4:
                            MetodosFicheros.borrarCliente();
                            break;
                        case 5:
                            MetodosFicheros.borrarFichero();
                            break;
                        case 6:
                            System.out.println("Hasta la próxima!!");
                            m = false;
                            break;
                        default:
                            System.out.println("Introduzca una opción válida del 1 al 6: ");
                        
                    }
                } catch (InputMismatchException ex) {//Excepción para controlar que el número introducido sea entero tipo byte
                    System.out.println("Caracter o valor introducido incorrecto");
                    System.out.println("Por favor, introduzca opción valida del 1 al 6: ");
                    teclado.next();
                    e = true;
                }
            } while (e);
        } while (m);
  }//Fin clase main  

}//Fin clase MenuFicherosCliente
