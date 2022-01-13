/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

import java.util.Scanner;

/**
 *
 * @author PAUDA
 */
public class CombSinRepeticion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int n = 0, p = 0, combinaciones;
        Scanner teclado = new Scanner(System.in);
        do {
            try {
                System.out.println("Introduzca un primer número p del 2 al 6");
                p = teclado.nextInt();
                System.out.println("Introduzca un segundo número n>p y del 2 al 7");
                n = teclado.nextInt();
            } catch (Exception e) {
                System.out.println("Los caracteres introducidos no son correctos");
                p = 0;
                teclado.next();
            }
        } while (p < 2 || p >= n || p > 6 || n > 7);
        combinaciones=factorialNumero(n)/(factorialNumero(p)*factorialNumero(n-p));
        System.out.println("El factorial de p es " + factorialNumero(p));

        System.out.println("El factorial de n es " + factorialNumero(n));
        
        System.out.println("El número de combinaciones sin repetición será de "+combinaciones);
    }
    
    /**
     * Método recursivo para calcular el factorial de un número
     * @param num
     * @return 
     */
    static int factorialNumero(int num){
        
        int resultado;
        if(num==1) return 1;
        resultado=factorialNumero(num-1)*num;
        return resultado;
    }

}
