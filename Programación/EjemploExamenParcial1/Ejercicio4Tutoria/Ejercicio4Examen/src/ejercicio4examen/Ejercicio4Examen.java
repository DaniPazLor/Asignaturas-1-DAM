package ejercicio4examen;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jose Ignacio
 */

public class Ejercicio4Examen {

    public static void main(String[] args) {
        
        // AQUÍ SE DECLARAN LOS ARRAYS DE ENTEROS DE 2 X 2 
        
        int[][] matrizM = new int[2][2], matrizN = new int[2][2];
        int[][] matriz_resultado = new int[2][2];
        
        int valor;
        
        Scanner entrada = new Scanner(System.in);
        
        // LOS BUCLES VAN DE 0 A 1 PORQUE EL ÍNDICE DE LOS ARRAYS EMPIEZA SIEMPRE EN 0
        
        for(int i=0;i<2;i++)
            
            for(int j=0;j<2;j++){
                
               System.out.printf("Introduzca el elemento (%d,%d) de la primera matriz:",i,j);                       
               matrizM[i][j] = entrada.nextInt();
        
            }
        
        for(int i=0;i<2;i++)
            
            for(int j=0;j<2;j++){
                
               System.out.printf("Introduzca el elemento (%d,%d) de la segunda matriz:",i,j);                       
               matrizN[i][j] = entrada.nextInt();
        
            }
        
        int suma,filaResul;
        
        // AQUÍ COMIENZA REALMENTE EL PRODUCTO DE LAS MATRICES
        
        for(int columnasResul=0;columnasResul<2;columnasResul++)
            
            for(filaResul=0;filaResul<2;filaResul++){                
                
                suma=0;        // INICIALIZACIÓN DE LA SUMA        
                
                for(int indiceTrasposicion=0;indiceTrasposicion<2;indiceTrasposicion++)
                    suma += matrizM[filaResul][indiceTrasposicion] * matrizN[indiceTrasposicion][columnasResul];
             
                matriz_resultado[filaResul][columnasResul] = suma;   // ALMACENAMIENTO EN LA MATRIZ RESULTADO
                
            }                          
                     
        // IMPRESIÓN DEL RESULTADO EN LA SALIDA ESTÁNDAR CON EL FORMATO ((r11,r12),(r21,r22)) CON r de RESULTADO
        
        System.out.print("(");      // SE IMPRIME EL PARÉNTESIS INICIAL DE LA MATRIZ
       
        for(int i=0;i<2;i++){       // SE RECORREN LAS FILAS DEL ARRAY RESULTADO 
            
            System.out.print("(");  // POR CADA FILA HAY UNA APERTURA DE PARÉNTESIS DE FILA
            
            for(int k=0;k<2;k++){   // POR CADA FILA SE RECORREN LAS COLUMNAS DEL ARRAY
                
               System.out.printf("%d", matriz_resultado[i][k]);    // SE IMPRIME EL VALOR ANTERIORMENTE ALMACENADO
               
               if(k!=1)                        // SE IMPRIME UNA COMA SI ACABAMOS DE IMPRIMIR EL PRIMER ELEMENTO
                   System.out.printf(",");                                  
            }            
            
            if(i!=1)                           // SI ESTAMOS EN LA PRIMERA FILA CERRAMOS EL PARÉNTESIS DE LA PRIMERA FILA Y ESCRIBIMOS UNA COMA
              System.out.print("),");
            
         }
        
        System.out.print("))\n");        // FINALMENTE CERRAMOS LA SEGUNDA FILA Y LA MATRIZ
                
    }
    
}