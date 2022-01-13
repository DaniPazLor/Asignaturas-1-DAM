package aplicacionBancaria;

import java.util.*;//Importamos todas las clases del paquete java.util

/**
 * Clase pricipal del programa que al ejecutarse nos proporcionará por pantalla
 * un menú con las distintas opciones de nuestra aplicación
 *
 * @author dani
 * @version 1.0
 */
public class AplicacionCuenaBancaria {

    public static void main(String[] args) {

        //Bloque declaración de variables globales y del objeto teclado
        byte menuElige;
        boolean b = true, c = true, d = true, e;//Bits de control
        int ingreso, retirada;
        String nombreTitular, numeroCCC;
        Scanner teclado = new Scanner(System.in);//Generamos instancia teclado de la clase Scanner

        //Recogemos por teclado nombre del titular
        do {
            System.out.println("----------- APLICACIÓN CUENTA BANCARIA -----------");
            System.out.println("Nombre del titular de la cuenta: ");
            nombreTitular = teclado.nextLine();
            b = CuentaBancaria.validarTitular(nombreTitular);
        } while (b);

        /**
         * Recogemos por teclado el número CCC y validamos su formato y si es
         * válido o no.
         */
        do {
            System.out.println("Introduzca código cuenta cliente completo (CCC): ");
            numeroCCC = teclado.next();
            b = CuentaBancaria.validarFormatoCCC(numeroCCC);
            c = CuentaBancaria.validarNumeroCCC(numeroCCC);
        } while (b || c);//Si el número no es válido repite bucle

        //Generamos el objeto datosCuenta con los parámetros de numero de cuenta y titular
        CuentaBancaria datosCuenta = new CuentaBancaria(nombreTitular, numeroCCC);

        /**
         * Imprimimos por pantalla el menú general de la aplicación
         */
        do {
            System.out.println("----------- MENÚ PRINCIPAL DE CUENTA BANCARIA -----------");
            System.out.println("1. Ver el número de cuenta completo");
            System.out.println("2. Ver el titular de la cuenta");
            System.out.println("3. Ver el código de la entidad");
            System.out.println("4. Ver el código de la oficina");
            System.out.println("5. Ver el número de la cuenta");
            System.out.println("6. Ver los dígitos de control de la cuenta");
            System.out.println("7. Realizar un ingreso");
            System.out.println("8. Retirar efectivo");
            System.out.println("9. Consultar saldo");
            System.out.println("10. Salir de la aplicación");
            System.out.print("\nElija una opción: ");

            do {
                try {
                    e = false;
                    menuElige = teclado.nextByte();

                    switch (menuElige) {
                        case 1:
                            System.out.println("El número de cuenta corriente completo (CCC) es " + datosCuenta.numeroCCC + "\n\n");
                            break;
                        case 2:
                            System.out.println("El nombre del titular de la cuenta es " + datosCuenta.nombreTitular + "\n\n");
                            break;
                        case 3:
                            System.out.println("El número de entidad es " + datosCuenta.informacionEntidad() + "\n\n");
                            break;
                        case 4:
                            System.out.println("EL número de la oficina es " + datosCuenta.informacionOficina() + "\n\n");
                            break;
                        case 5:
                            System.out.println("El número de la cuenta es " + datosCuenta.informacionNumCuenta() + "\n\n");
                            break;
                        case 6:
                            System.out.println("Los digitos de control son " + datosCuenta.informacionDigitosControl() + "\n\n");
                            break;
                        case 7:
                            System.out.println("Que cantidad desearía ingresar: ");
                            do {
                                try {//Excepción para controlar que el número introducido sea entero
                                    e = false;
                                    ingreso = teclado.nextInt();
                                    datosCuenta.realizarIngreso(ingreso);
                                } catch (InputMismatchException ex1) {
                                    System.out.println("Ha introducido un carácter o número no válido");
                                    System.out.print("\nPor favor, introduzca una cantidad a ingresar valida: ");
                                    teclado.next();
                                    e = true;
                                }
                            } while (e);
                            break;
                        case 8:
                            System.out.println("Que cantidad desearía retirar: ");
                            do {
                                try {//Excepción para controlar que el número introducido sea entero
                                    e = false;
                                    retirada = teclado.nextInt();
                                    datosCuenta.realizarRetirada(retirada);
                                } catch (InputMismatchException ex1) {
                                    System.out.println("Ha introducido un carácter o número no válido");
                                    System.out.print("\nPor favor, introduzca una cantidad a retirar valida: ");
                                    teclado.next();
                                    e = true;
                                }
                            } while (e);

                            break;
                        case 9:
                            System.out.println("Su saldo en este momento es de: " + datosCuenta.consultaSaldo() + "Euros\n\n");
                            break;
                        case 10:
                            System.out.println("Hasta la próxima!!");
                            d = false;
                            break;
                        default:
                            System.out.println("Por favor seleccione una opción del 1 al 10\n\n");
                            break;
                    }
                } catch (InputMismatchException ex) {//Excepción para controlar que el número introducido sea entero tipo byte
                    System.out.println("Ha introducido un carácter o número no válido");
                    System.out.println("Por favor, vuelva a intentarlo: ");
                    teclado.next();
                    e = true;
                }

            } while (e);
        } while (d);
    }//Fin clase main

}//Fin clase AplicacionCuentaBancaria
