package respuestas.tarea2programacion;

/**
 * @Nombre de clase: PROG02_Ejer03
 * @Descripción: Vamos a modificar el programa anterior para sacar por pantalla los valores de las variables
 * @author Daniel Paz Lorenzo
 */
public class PROG02_Ejer03 {
    public static void main(String[ ] args) {
         boolean casado = true; 
         int MAXIMO = 999999; 
         byte diasem = 1; 
         short diaanual = 300; 
         char sexo = 'M'; 
         long miliseg = 1298332800000L;
         double totalfactura = 10350.677734; 
         long poblacion = 6775235741L;
         //Primera parte del ejercicio
         System.out.println("-----EJERCICIO DE VARIABLES Y TIPOS DE DATOS-----");
         System.out.println("\tEl valor de la variable casado es " + casado);
         System.out.println("\tEl valor de la variable MAXIMO es " + MAXIMO);
         System.out.println("\tEl valor de la variable diasem es " + diasem);
         System.out.println("\tEl valor de la variable diaanual es " + diaanual);
         System.out.println("\tEl valor de la variable miliseg es " + miliseg);
         System.out.println(String.format("\tEl valor de la variable totalfactura es %.3f", totalfactura));
         System.out.println("\tEl valor de la variable poblacion es " + poblacion);
         System.out.println("\tEl valor de la variable sexo es " + sexo);
         //Segunda parte del ejercicio
         System.out.print("-----EJERCICIO DE VARIABLES Y TIPOS DE DATOS-----\n");
         System.out.print("\tEl valor de la variable casado es " + casado + "\n");
         System.out.print("\tEl valor de la variable MAXIMO es " + MAXIMO + "\n");
         System.out.print("\tEl valor de la variable diasem es " + diasem + "\n");
         System.out.print("\tEl valor de la variable diaanual es " + diaanual + "\n");
         System.out.print("\tEl valor de la variable miliseg es " + miliseg + "\n");
         System.out.print(String.format("\tEl valor de la variable totalfactura es %.3f \n", totalfactura));
         System.out.print("\tEl valor de la variable poblacion es " + poblacion + "\n");
         System.out.print("\tEl valor de la variable sexo es " + sexo + "\n");
         //Tercera parte del ejercicio        
         System.out.printf("-----EJERCICIO DE VARIABLES Y TIPOS DE DATOS-----\n");
         System.out.printf("\tEl valor de la variable casado es " + casado + "\n");
         System.out.printf("\tEl valor de la variable MAXIMO es " + MAXIMO + "\n");
         System.out.printf("\tEl valor de la variable diasem es " + diasem + "\n");
         System.out.printf("\tEl valor de la variable diaanual es " + diaanual + "\n");
         System.out.printf("\tEl valor de la variable miliseg es " + miliseg + "\n");
         System.out.printf("\tEl valor de la variable totalfactura es " + totalfactura + "\n");
         System.out.printf(String.format("\tEl valor de la variable totalfactura es %e \n", totalfactura));
         System.out.printf("\tEl valor de la variable poblacion es " + poblacion + "\n");
         System.out.printf("\tEl valor de la variable sexo es " + sexo + "\n");        
    }//Estructura principal del programa: inicialización de variables y mostrar por pantalla el resultado    
}//Fin de la clase PROG02_Ejer03
