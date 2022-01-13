package respuestas.tarea2programacion;

import java.util.*;

/**
 * @Nombre de clase: PROG02_Ejer08
 * @Descripción: Programa que calcule la suma, resta, multiplicación y división 
 * de 2 números introducidos por teclado y añadir funciones para potencia y raíz 
 * cuadrada
 * @author Daniel Paz Lorenzo
 */
public class PROG02_Ejer08 {
        static double potencia(float x){
            double pot;
            pot = Math.pow(x, 2);
            return pot;
        }//Función para calcular la potencia de un número
        static double raizcuadrada(float x){
            double raiz;
            raiz = Math.sqrt(x);
            return raiz;
        }//Función para calcular a raiz cuadrada de un número
    public static void main(String[ ] args) {

        Scanner lector = new Scanner(System.in);

        System.out.println("Introduce un número: ");
        float x = lector.nextFloat();//Recogemos el número por teclado y lo asignamos a la variable
    
        System.out.println("Introduce otro número: ");
        float y = lector.nextFloat();//Recogemos el número por teclado y lo asignamos a la variable
        
        System.out.printf("\n\tx = %.1f y = %.1f\n",x,y);
        System.out.printf("\n\tx + y = %.1f\n",(x+y));
        System.out.printf("\n\tx - y = %.1f\n",(x-y));
        System.out.printf("\n\tx * y = %.1f\n",(x*y));
        System.out.printf("\n\tx / y = %.1f\n",(x/y));
        System.out.printf("\n\tx ^ 2 = %.1f\n",(potencia(x)));
        System.out.printf("\n\tla raiz cuadrada de x = %.1f\n",(raizcuadrada(x)));
    }//Estructura principal del programa
}//Fin de la clase PROG02_Ejer08
