/*Clase Persona incluida en el paquete Ejercicio2*/
package E2;


/**
 * @Nombre: Persona
 * @Descripción: Definimos los métodos de consulta y cambio de nombre, edad y altura
 * @author: Daniel Paz Lorenzo
 */
public class Persona {   
        
    String nombre;
    int edad;
    float altura;

        
    String consulta_Nombre(){

        return nombre;
    }//Metodo que retorna el valor de la variable nombre

    void cambia_Nombre(String nom){

        nombre=nom;
    }//Método que asigna el parámetro de nom al atributo nombre
    
    int consulta_Edad(){

        return edad;
    }//Metodo que retorna el valor de la variable edad
    
    void cambia_Edad(int annos){

        edad=annos;
    }//Método que asigna el parámetro de annos al atributo edad
    
    float consulta_Altura(){

        return altura;
    }//Metodo que retorna el valor de la variable altura

    void cambia_Altura(float alt){

        altura=alt;
    }//Método que asigna el parámetro de alt al atributo altura
}//Fin clase Persona
