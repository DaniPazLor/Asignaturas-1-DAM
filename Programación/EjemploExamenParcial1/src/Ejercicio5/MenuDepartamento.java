/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio5;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author PAUDA
 */
public class MenuDepartamento {

    public static void main(String[] args) throws IOException {

        byte op;
        Scanner teclado = new Scanner(System.in);
        DirectoriosDepartamento directorios = new DirectoriosDepartamento();
        ProcesarArchivos procesador = new ProcesarArchivos();

        System.out.println("MENÚ DE ORGANIZACIÓN DE DIRECTORIOS");
        System.out.println("1.- Creación de ficheros en directorio principal");
        System.out.println("2.- Organización de ficheros");
        System.out.println("3.- Mostrar informe serializado con datos de movimientos");
        System.out.println("Introduzca una opción: ");
        op = teclado.nextByte();

        switch (op) {
            case 1:
                directorios.crearDirectorio();
                procesador.generacionArchivosAleatorios();
                break;
            case 2:
                procesador.procesar();
                break;
            case 3:
                procesador.mostrarInforme();
                break;
        }
    }

}
