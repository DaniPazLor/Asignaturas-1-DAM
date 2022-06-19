/*Clase Persona incluida en el paquete Ejercicio1*/
package E1;


import java.util.Scanner;
/**
 * @Nombre: Persona
 * @Descripción: Define la clase persona e incluye 3 métodos para la misma
 * @author: Daniel Paz Lorenzo
 */
public class Persona {   
   
    String nombre;
    /*int edad;
    float altura;*/

    String metodo_Principal(){
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca un nombre: ");
        nombre = teclado.nextLine();
        return nombre;           
    } //Metodo que recoge el valor introducido por teclado y lo retorna en una variable tipo String
    
    String consulta_Nombre(){

        return nombre;
    }
    
    void cambia_Nombre(String nom){

        nombre=nom;
    }

}//Fin clase Persona
