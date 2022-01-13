package ejercicio3examen;

import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author Jose Ignacio
 */
public class Ejercicio3Examen {

    public static void main(String[] args) {       
        
        Scanner escaner = new Scanner(System.in);
        
        byte p, n;   // HEMOS DICHO QUE DADO EL ENUNCIADO TODO VA A CABER EN UN SHORT AUNQUE LAS VARIABLES P Y N 
                     // CABEN EN UN BYTE
        
        do{          // BUCLE DE VALIDACIÓN DE N SEGÚN EL ENUNCIADO
            
          System.out.printf("Introduzca el número total de elementos n (mayor que 1 y menor que 8):");        
          n = escaner.nextByte();
        
        }while(n>7 || n<2);
                
        do{          // BUCLE DE VALIDACIÓN DE P SEGÚN EL ENUNCIADO  
            
          System.out.printf("Introduzca el número de elementos p (2<=p<n<8):");        
          p = escaner.nextByte();
        
        }while(p>=n || p<2);

        // CALCULO DEL VALOR DE LA FÓRMULA E IMPRESIÓN DEL RESULTADO
        
        System.out.printf("El número de combinaciones sin repetición de %d elementos tomados en grupos de %d con 2<=p<n<8 es ", n, p);                       
                
        // AQUÍ SE LLAMA 3 VECES AL MÉTODO ESTÁTICO DE FACTORIAL AUNQUE SE PODRÍA ESTABLECER 
        // EL CÁLCULO DE ESA FÓRMULA EN UN MÉTODO ÚNICO TAMBIÉN ESTÁTICO DENTRO DE LA CLASE FACTORIAL
        
        System.out.printf("%d\n",Factorial.factorial(n)/(Factorial.factorial(p)*Factorial.factorial((short)(n-p))));        
        
    }
    
}
