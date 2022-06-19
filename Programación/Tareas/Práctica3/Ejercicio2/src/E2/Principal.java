/*Clase principal del ejercicio2*/
package E2;


import java.util.*;


/**
 * @Nombre: Principal
 * @Descripción: Ejecuta la clase principal main() del programa
 * @author: Daniel Paz Lorenzo
 */
public class Principal {

    public static void main(String[] args) {
        //Bloque declaración de variables y objetos
        String nom;
        int annos;
        float alt;
        Persona Per = new Persona();//Creamos objeto Per de la clase Persona
        
        //Recoger por teclado nombre, edad y altura y pasar el parámetro a su correspondiente método
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca un nombre: ");
        nom = teclado.nextLine();
        Per.cambia_Nombre(nom); 
        System.out.println("\nIntroduzca edad: ");
        annos = teclado.nextInt();
        Per.cambia_Edad(annos);
        System.out.println("\nIntroduzca altura: ");
        alt = teclado.nextFloat();
        Per.cambia_Altura(alt);        
        
        //Mostrar por pantalla el resultado
	System.out.printf("\nEste es el nombre: %s", Per.consulta_Nombre());//Mostrar por pantalla el valor devuelto por el método consulta_Nombre
	System.out.printf("\nEsta es la edad: %s", Per.consulta_Edad());//Mostrar por pantalla el valor devuelto por el método consulta_Edad
	System.out.printf("\nEsta es la altura: %.2f", Per.consulta_Altura());//Mostrar por pantalla el valor devuelto por el método consulta_Altura
 
   }//Fin clase main
    
}//Fin clase Principal
