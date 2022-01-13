/**
 * Lee un número por teclado y nos dice si es par o impar
 *
 * @author: Daniel Paz Lorenzo
 * @version: 1.0
 */
package Ejercicios;

import java.util.Scanner;

public class Supuesto1 {

    public static void main(String[] args) {
        //Declaración de variables y objetos
        int numero;
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduzca un número entero: ");
        numero = teclado.nextInt();

        //Si el resto de la división por 2 es 0 el número es par, sino impar
        if (numero % 2 == 0) {
            System.out.println("\nEl número introducido es par");
        } else {
            System.out.println("\nEl número introducido es impar");
        }

    }//Fin clase main

}//Fin clase supuesto1
