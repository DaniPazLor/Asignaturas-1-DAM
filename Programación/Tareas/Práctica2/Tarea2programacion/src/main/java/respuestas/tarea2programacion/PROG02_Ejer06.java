package respuestas.tarea2programacion;

/**
 * @Nombre de clase: PROG02_Ejer06
 * @Descripción: Mostrar variable enumerada de los meses del año
 * @author Daniel Paz Lorenzo
 */
public class PROG02_Ejer06 {
    enum meses {ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE, DICIEMBRE};
    public static void main (String[] args){
        
        meses m = meses.MARZO;  //Creamos variable tipo enum "m" y le asignamos el valor MARZO
        System.out.println("El valor de la variable m es: " + m);
        
        System.out.println(m.MARZO.name()); //Asignamos a la variable tipo enum "m" la cadena de caracteres "MARZO" y la mostramos por pantalla
    }//Estructura principal del programa
}//Fin de la clase PROG02_Ejer06
