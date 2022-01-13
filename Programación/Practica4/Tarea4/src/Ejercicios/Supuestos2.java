package Ejercicios;

import java.util.Scanner;

/**
 * Lee número de mes y año por teclado y nos devuelve número de días que tiene
 * dicho mes
 *
 * @author: Daniel Paz Lorenzo
 * @version: 1.0
 */
public class Supuestos2 {

    public static void main(String[] args) {

        int mes, anno;

        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("Introduzca un número de mes: ");
            mes = teclado.nextInt();
        } while (mes < 1 || mes > 12);//Controla que el número introducido este en el rango de 1-12

        do {
            System.out.println("Introduzca un año: ");
            anno = teclado.nextInt();
            if (anno == 0) {
                System.out.println("El año 0 no existe en el calendario gregoriano\n");
            }
        } while (anno == 0);//Si el año introducido es 0 repite bucle

        /*Bloque para mostrar por pantalla el número de días que tiene dicho mes*/
        if (mes == 2) {
            if (Supuestos2.anno_Bisiesto(anno)) {
                System.out.printf("\nEl mes número %d del año %d tiene 29 días", mes, anno);
            } else {
                System.out.printf("\nEl mes número %d del año %d tiene 28 días", mes, anno);
            }
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            System.out.printf("\nEl mes número %d del año %d tiene 30 días", mes, anno);
        } else {
            System.out.printf("\nEl mes número %d del año %d tiene 31 días", mes, anno);
        }

    }//Fin clase main

    /**
     * El método anno_Bisiesto comprueba si un año es bisiesto o no comprueba
     * tanto años negativos como positivos
     *
     * @param anno
     * @return bisiesto
     */
    public static boolean anno_Bisiesto(int anno) {
        boolean bisiesto = false;
        if (anno % 4 == 0) {
            if (anno < 100 && anno > -100) {//Controla el rango de -100 a 100
                bisiesto = true;
            }
            if (anno % 100 == 0 && anno % 400 == 0) {
                bisiesto = true;
            }
        }
        return bisiesto;
    }//Fin del método
}//Fin clase Supuestos2 
