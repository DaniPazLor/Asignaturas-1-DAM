/*Clase principal del ejercicio4*/
package E4;

/**
 * @Nombre: Principal
 * @Descripción: Ejecuta la clase principal main() del programa
 * @author: Daniel Paz Lorenzo
 */
public class Principal {

    public static void main(String[] args) {
        //Creamos objeto Per del método constructor de la clase persona con parámetros
        Persona Per = new Persona("Luisa perez", 22, 1.70f);   
        
        //Mostrar por pantalla los resultados
	System.out.printf("\nEste es el nombre: %s", Per.consulta_Nombre());//Mostrar por pantalla el valor devuelto por el método consulta_Nombre
	System.out.printf("\nEsta es la edad: %s", Per.consulta_Edad());//Mostrar por pantalla el valor devuelto por el método consulta_Edad
	System.out.printf("\nEsta es la altura: %.2f", Per.consulta_Altura());//Mostrar por pantalla el valor devuelto por el método consulta_Altura
 
   }//Fin clase main
    
}//Fin clase Principal
