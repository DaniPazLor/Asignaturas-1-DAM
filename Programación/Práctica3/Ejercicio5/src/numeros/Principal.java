/*Clase principal del ejercicio5*/
package numeros;

import java.util.Scanner;

/**
 * @Nombre: Principal
 * @Descripción: Ejecuta la clase principal main() del programa
 * @author: Daniel Paz Lorenzo
 */
public class Principal {

    public static void main(String[] args) {
        //Bloque declaración de variables y objetos
        double real;
        double imag;
        Complejo Complex = new Complejo();//Creamos objeto Complex de la clase Complejo
        Complejo Comp = new Complejo(3,4);
        
        
        //Mostrar por pantalla objeto con atributos inicializados a 0     
        System.out.printf("Constructor que inicializa atributos a 0: %.0f + %.0fi\n", Complex.consulta_Real(), Complex.consulta_Imag());
        
        //Mostrar por pantalla objeto inizializado por parámetros        
        System.out.printf("Constructor que inicializa atributos a valores indicados por parámetros: %.0f + %.0fi\n", Comp.consulta_Real(), Comp.consulta_Imag());
                
        //Recoger por teclado parte real y parte imaginaria 
        Scanner teclado = new Scanner(System.in);
        System.out.print("\nIntroduzca parte real de número complejo: ");
        real = teclado.nextDouble();
        Complex.cambia_Real(real);//Modifica valor utilizando método de objeto
        System.out.print("\nIntroduzca parte imaginaria de número complejo: ");
        imag = teclado.nextDouble();
        Complex.cambia_Imag(imag);;//Modifica valor utilizando método de objeto
        //Mostrar por pantalla valores recogidos
        System.out.printf("\nEste es el número complejo con los nuevos valores: %.0f + %.0fi\n", Complex.consulta_Real(), Complex.consulta_Imag());
        
        //Mostrar por pantalla método toString que convierte numero complejo a String
        System.out.print("\nNumero complejo convertido a String: "+ Complex.toString());
        
        //Llamar al método de la suma de 2 números complejos
        Complex.sumar(Comp);
        //System.out.printf("\n%s + %s = %s ", );
   }//Fin clase main
    
}//Fin clase Principal
