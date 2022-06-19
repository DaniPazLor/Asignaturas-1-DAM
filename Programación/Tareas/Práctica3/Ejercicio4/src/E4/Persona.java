/*Clase Persona incluida en el paquete Ejercicio3*/
package E4;

/**
 * @Nombre: Persona
 * @Descripción: Añadimos un método constructor con el método this a los que ya tenía
 * @author: Daniel Paz Lorenzo
 */

public class Persona {   
        
    String nombre;
    int edad;
    float altura;

    public Persona(){
        nombre = "Luisa Perez";
        edad = 22;
        altura = 1.70f;        
    }//constructor de la clase persona
    
    public Persona(String nombre, int edad, float altura){
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }//constructor clase persona con this
    
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
