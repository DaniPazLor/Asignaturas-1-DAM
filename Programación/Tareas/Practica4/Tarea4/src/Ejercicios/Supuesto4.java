package Ejercicios;

import java.util.Scanner;

/**
 * Lee nombre y edad por teclado calcula la edad dentro de una decada clasifica
 * la edad en su grupo y muestra por pantalla resultado
 *
 * @author: Daniel Paz Lorenzo
 * @version: 1.0
 */
public class Supuesto4 {

    public static void main(String[] args) {
        /*Declaración de variables y objetos*/
        String nombre;
        int edad;
        Scanner teclado = new Scanner(System.in);
        /*Recoge datos por teclado*/
        System.out.print("Introduzca nombre: ");
        nombre = teclado.nextLine();
        System.out.print("\nIntroduzca edad: ");
        edad = teclado.nextInt();

        Supuesto4.clasificacion_Edad(edad, nombre);//Llamada a método
    }//Fin de la clase main

    /**
     * Metodo que recoge nombre y edad como parámetros cálcula la edad dentro de
     * 10 años y la clasifica según al grupo al que pertenece
     *
     * @param edad
     * @param nombre
     */
    public static void clasificacion_Edad(int edad, String nombre) {
        edad += 10;
        System.out.printf("\nLa edad de %s dentro de una decada será de %d años\n", nombre, edad);
        if (edad >= 0 && edad < 26) {
            System.out.println("y estará clasificado dentro del grupo A[0-25]");
        } else if (edad > 25 && edad < 51) {
            System.out.println("y estará clasificado dentro del grupo B[26-50]");
        } else {
            System.out.println("y estará clasificado dentro del grupo C[51-...]");
        }
    }//Fin método clasificación_Edad
}//Fin de la clase Supuesto4
