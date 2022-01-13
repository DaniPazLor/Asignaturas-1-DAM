package respuestas.tarea2programacion;

import java.util.Scanner;

/**
 * @Nombre de clase: PROG02_Ejer07
 * @Descripción: Resolver ecuación de primer grado
 * @author Daniel Paz Lorenzo
 */
public class PROG02_Ejer07 {
    public static void main(String[ ] args) {
        float x;
        Scanner lector = new Scanner(System.in);

        System.out.println("Introduce un número: ");
        float C1 = lector.nextFloat();
    
        System.out.println("Introduce otro número: ");
        float C2 = lector.nextFloat();
        
        x = -C2/C1;
        
        System.out.println("El resultado de la ecuación es: " + x);
    }//Estructura principal del programa
}//Fin de la clase PROG02_Ejer07
