package Ejercicios;

import java.util.Scanner;

/**
 * Lee número por teclado, lo descompone en factores primos y muestra por
 * pantalla el resultado
 *
 * @author: Daniel Paz Lorenzo
 * @version: 1.0
 */
public class Supuesto3 {

    public static void main(String[] args) {
        int num;
        //float cociente;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduzca un numero: ");
        num = teclado.nextInt();
        if (num == 1) {
            System.out.printf("\nLa descomposición en factores primos del número %d es: 1", num);
        } else if (num < 1) {
            System.out.println("El número introducido es negativo o 0");
        } else {
            System.out.printf("\nLa descomposición en factores primos del número %d son: ", num);
            Supuesto3.factores_Primos(num);//Llamada a método
        }

    }//Fin clase main

    /**
     * El método factores_Primos descompone nuestro num en factores primos y los
     * muestra por pantalla
     *
     * @param num
     */
    public static void factores_Primos(int num) {
        int num2 = num;
        int i;

        do {
            for (i = 2; i <= num2; i++) {

                if (num2 % i == 0) {
                    System.out.printf("%d ", i);
                    num2 /= i;
                    break;
                }
            }
        } while (num2 >= 2);
    }//Fin del método
}//Fin clase Supuesto3
