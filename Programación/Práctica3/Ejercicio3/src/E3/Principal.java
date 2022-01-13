/*Clase principal del ejercicio3*/
package E3;


/**
 * @Nombre: Principal
 * @Descripción: Ejecuta la clase principal main() del programa
 * @author: Daniel Paz Lorenzo
 */
public class Principal {

    public static void main(String[] args) {

        Persona Per = new Persona();//Creamos objeto Per del método constructor de la clase persona
   
        
        //Mostrar por pantalla los resultados
	System.out.printf("\nEste es el nombre: %s", Per.consulta_Nombre());//Mostrar por pantalla el valor devuelto por el método consulta_Nombre
	System.out.printf("\nEsta es la edad: %s", Per.consulta_Edad());//Mostrar por pantalla el valor devuelto por el método consulta_Edad
	System.out.printf("\nEsta es la altura: %.2f", Per.consulta_Altura());//Mostrar por pantalla el valor devuelto por el método consulta_Altura
 
   }//Fin clase main
    
}//Fin clase Principal
