/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2examen;

import java.util.Scanner;

/**
 *
 * @author Jose
 */
public class Ejercicio2Examen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.printf("Prueba de salida");
        
        Scanner escaner = new Scanner(System.in);
        
        int numero1, numero2, resto, aux;
        
        System.out.printf("Introduzca el número 1:");
        
        numero1 = escaner.nextInt();
        
        System.out.print("Introduzca el número 2:");
        
        numero2 = escaner.nextInt();
        
        System.out.printf("El máximo común divisor de %d y %d es ",numero1, numero2);
        
        if(numero1<numero2){                // INTERCAMBIO DE LOS NÚMEROS PARA PONERLOS EN ORDEN
            aux = numero2;
            numero2 = numero1;
            numero1 = aux;
        }
        
        do{
            resto = numero1%numero2;       // OBTENCIÓN DEL RESTO
            if(resto==0)                   // SI EL RESTO ES CERO SOLUCIÓN OBTENIDA
                System.out.printf("%d\n", numero2);
            else if (resto!=1){                     // SI EL RESTO ES IGUAL A 1 NO HACE FALTA INTERCAMBIARLOS
                numero1 = numero2;
                numero2 = resto;
            }
        }
        while(resto!=1 && resto!=0);    // LAS CONDICIONES POSIBLES SIN TRANSFORMACIÓN

        if(resto==1)
            System.out.println("1");
        
    }
    
}
