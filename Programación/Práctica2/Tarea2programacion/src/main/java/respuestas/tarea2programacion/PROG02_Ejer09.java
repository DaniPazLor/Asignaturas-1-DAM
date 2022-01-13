package respuestas.tarea2programacion;

import java.util.*;

/**
 * @Nombre de clase: PROG02_Ejer09
 * @Descripción: Programa que recoja 5 números por teclado y los muestre por separado
 * @author Daniel Paz Lorenzo
 */
public class PROG02_Ejer09 {
    
    public static void main (String args[]){
        String numero;
        int i=0;
        
        Scanner teclado = new Scanner(System.in);
        do{
            System.out.println("Introduzca un número de 5 cifras: ");        
            numero = teclado.nextLine();
        }while(numero.length()<5 || numero.length()>5);//Comprueba que el número introducido sea de 5 cifras exactamente
        
        for(i=0; i<numero.length(); i++){
            System.out.print(numero.charAt(i)+" ");
        }//Recorre los indices del String numero y nos devuelve su valor ayudandonos del metodo "charAT()"
    }//Estructura principal del programa: inicialización de variables y mostrar por pantalla el resultado
}//Fin de la clase PROG02_Ejer09
