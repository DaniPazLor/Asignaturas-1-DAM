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
public class ComprobarNumero {

    boolean d = false;
    private String num;
    Scanner teclado = new Scanner(System.in);

    public void OpMenu1() {
        do {
            try {
                System.out.println("Introduzca un número: ");
                num = teclado.next();
                Integer.parseInt(num);
                if (ComprobarSiDivisible(num)) {
                    System.out.println("El número introducido si es divisible por 3");
                } else {
                    System.out.println("El número introducido no es divisible por 3");
                }
                d = false;
            } catch (Exception e) {
                System.out.println("El número o carácteres introducido no son correctos");
                d = true;
            }
        } while (d);
    }

    public static boolean ComprobarSiDivisible(String num) {
        int i = 0, suma = 0;
        boolean correcto = false;
        for (i = 0; i < num.length(); i++) {
            suma += num.charAt(i);
        }
        if (suma % 3 == 0) {
            correcto = true;
        }
        return correcto;
    }
}
