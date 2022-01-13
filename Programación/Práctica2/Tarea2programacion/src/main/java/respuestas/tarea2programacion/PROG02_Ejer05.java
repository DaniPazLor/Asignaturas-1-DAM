
package respuestas.tarea2programacion;

/**
 * @Nombre de clase: PROG02_Ejer05
 * @Descripción: Programa que verifica si 2 números recogidos por teclado son múltiplos entre sí
 * @author Daniel Paz Lorenzo
 */
import java.util.Scanner;

public class PROG02_Ejer05 {
    public static void main (String[] args){
        
    Scanner lector = new Scanner(System.in);

    System.out.println("Introduce un número: ");
    int num1 = lector.nextInt();
    
    System.out.println("Introduce otro número: ");
    int num2 = lector.nextInt();
    
        if(num1%num2==0){
            System.out.println("El primer número es múltiplo del segundo");
        }
        else System.out.println("El primer número no es múltiplo del segundo");
        
    System.out.printf("\nEl resultado de la división de ambos números nos dará el siguiente resto: %d", (num1%num2));     
    }//Estructura principal del programa
}//Fin de la clase PROG02_Ejer05
