/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import java.util.Scanner;

/**
 *
 * @author PAUDA
 */
public class MaxComunDivisor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String c = "";
        int num1, num2, resto1, resto2 = 0, mcd = 0;
        Scanner teclado = new Scanner(System.in);

        do {
            try {
                System.out.println("Introduzca un primer número por teclado");
                num1 = teclado.nextInt();
                System.out.println("Introduzca un segundo número por teclado");
                num2 = teclado.nextInt();
                if (num1 == num2) {
                    mcd=num1;
                } else if (num1 > num2) {
                    resto1 = num1 % num2;
                    if (resto1 == 0) {
                        mcd = num2;
                    } else {
                        resto2 = num2 % resto1;

                        if (resto2 == 0) {
                            mcd = resto1;
                        } else {

                            mcd = resto1 % resto2;
                        }
                    }
                } else {
                    resto1 = num2 % num1;
                    if (resto1 == 0) {
                        mcd = num1;
                    } else {
                        resto2 = num1 % resto1;

                        if (resto2 == 0) {
                            mcd = resto1;
                        } else {

                            mcd = resto1 % resto2;
                        }
                    }
                }
                System.out.println("El MCD de " + num1 + " y " + num2 + " es " + mcd);
                System.out.println("Desea introducir otros números S/N");
                c = teclado.next();

            } catch (Exception e) {
                System.out.println("Carácter introducido no válido");
                //teclado.next();
            }
        } while (c.contentEquals("s") || c.contentEquals("S"));
    }

}
