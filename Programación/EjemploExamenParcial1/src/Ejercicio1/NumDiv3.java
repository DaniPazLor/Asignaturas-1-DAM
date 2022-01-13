/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.util.Scanner;

/**
 *
 * @author PAUDA
 */
public class NumDiv3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String num;
        boolean c;
        byte op;
        Scanner teclado = new Scanner(System.in);
        ComprobarNumero numDiv = new ComprobarNumero();

        do {
            c=true;
            try {
                System.out.println("---------MENÚ NÚMERO DIVISIBLE POR 3---------");
                System.out.println("1.-Comprobar si número es divisible por 3");
                System.out.println("2.-Salir del programa");
                System.out.println("Elegir opción: ");
                op = teclado.nextByte();
                switch (op) {
                    case 1:
                        numDiv.OpMenu1();
                        c = true;
                        break;
                    case 2:
                        System.out.println("Hasta la próxima");
                        c = false;
                        break;
                    default:
                        System.out.println("Elija opción 1 o 2, gracias");
                }
            } catch (Exception e) {
                System.out.println("El caracter introducido no es correcto");
                teclado.next();
                c = true;
            }
        } while (c);
    }

}
