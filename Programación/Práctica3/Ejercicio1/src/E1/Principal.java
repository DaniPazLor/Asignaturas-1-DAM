/*Clase principal del ejercicio1*/
package E1;

/**
 * @Nombre: Principal
 * @Descripción: Ejecuta la clase principal main() del programa
 * @author: Daniel Paz Lorenzo
 */
public class Principal {

    public static void main(String[] args) {	
       
        Persona Per = new Persona();//Creamos objeto Per de la clase Persona
        String nom = Per.metodo_Principal();//Llamamos al metodo_Principal y el valor obtenido lo introducimos en la variable nom
        Per.cambia_Nombre(nom);//Invocamos al metodo cambia_Nombre de la clase Persona
	System.out.printf("\nEste es el nombre: %s", Per.consulta_Nombre());//Mostrar por pantalla el valor devuelto por el método consulta_Nombre
 
   }//Fin clase main
    
}//Fin clase Principal
