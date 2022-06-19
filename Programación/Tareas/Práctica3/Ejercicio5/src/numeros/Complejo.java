//Clase Complejo ubicada en el paquete E5
package numeros;

/**
 * @Nombre: Complejo
 * @Descripción: La clase define varios métodos para realizar operaciones con números complejos
 * @author: Daniel Paz Lorenzo
 */

public class Complejo {
    //Declaración de variables globales
    double real;
    double imag;
    
    public Complejo(){        
        real=0;
        imag=0;
    }//Constructor que inicializa los atributos a cero
    
    public Complejo(double real, double imag){        
        this.real=real;
        this.imag=imag;
    }//Constructor que inicializa los atributos a los valores indicados por los parámetros
    
    public double consulta_Real(){
        return real;
    }//Método que devuelve la parte real del objeto
    
    public double consulta_Imag(){
        return imag;
    }//Método que devuelve la parte imaginaria del objeto
    
    public void cambia_Real(double real){
        this.real=real;
    }//Método que asigna a la parte real del objeto el valor indicado en el parámetro real
    
    public void cambia_Imag(double imag){
        this.imag=imag;
    }//Método que asigna a la parte imaginaria del objeto el valor indicado en el parámetro imag
    
    public String toString(){
        return real+" + "+imag+"i";
    }//Méodo que pasa a tipo string número complejo
    
    public void sumar(Complejo b){
        double x;
        double y;
        x=b.real+this.real;
        y=b.imag+this.imag;
        System.out.printf("\nLa suma de la parte real: %f + %f = %f\n", this.real, b.real, x);
        System.out.printf("La parte imaginaria (%.2f y %.2f) es igual a %.2f\n", this.imag, b.imag, y);
    }//Metodo para sumar 2 números complejos
    
}//Fin clase Complejo
