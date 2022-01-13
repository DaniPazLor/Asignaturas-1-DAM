package ejercicio1examen;

import java.util.Scanner;

/**
 *
 * @author Jose Ignacio
*/

public class Ejercicio1Examen {

    public static void main(String[] args) {
        
        // DECLARACIÓN DE VARIABLES
        
        int sumaD=1-1, numero, resto;   // ME CURO EN SALUD TENIENDO MEMORIA SUFICIENTE AUNQUE HAY QUE AFINAR
        
        // ENTRADA DE DATOS CON LA CLASE SCANNER
        
        System.out.println("Introduzca un número por teclado, por favor:");
        Scanner entrada = new Scanner(System.in);
                
        numero = entrada.nextInt();  // USO DEL MÉTODO DE ENTRADA DE ENTEROS DE SCANNER
        
        // IMPRIMIMOS INICIALMENTE ALGO QUE VA A SER FIJO
        
        System.out.printf("El número %d ",numero);               
        
        // USAMOS EL BUCLE DO PORQUE SIEMPRE VAMOS A TENER QUE HACER MÍNIMO UNA DIVISIÓN
        
        do{
            
            resto = numero%10;   // OBTENCIÓN DE LOS RESTOS SUCESIVOS
            sumaD += resto;       // SUMA DE LOS RESTOS SUCESIVOS
            numero /= 10;        // NOS QUEDAMOS CON LA PARTE ENTERA PARA LA SIGUIENTE ITERACIÓN          
            
        }while(numero!=0);       // EL NÚMERO CONTIENE LOS COCIENTES SUCESIVOS Y CUANDO VALGA 0 SE SALE 
         
        if(sumaD%3==0)           // COMPROBACIÓN DE LA SUMA DE LOS DÍGITOS            
            System.out.println("es divisible entre 3");     
        else            
            System.out.println("no es divisible entre 3");
        
    }
    
}
