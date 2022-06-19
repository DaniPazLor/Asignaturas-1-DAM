package entradaDatosAplicacion;

import java.io.*;
import java.util.*;

/**
 * Clase para manejar ficheros de entrada
 *
 * @author Daniel Paz Lorenzo
 */
public class ficheroEntrada {

    //Declaramos las variables y String como protected como medio de encapsulación
    protected String contenidoEntradaFichero;
    protected ArrayList<String> listadoDatosClientes = new ArrayList();

    /**
     * Método que comprueba si existe o no el fichero recibido por parámetro y
     * si existe lo abre, lee y lo recoge en atributos de clase
     *
     * @param ficheroEntrada
     */
    public ficheroEntrada(String ficheroEntrada) {
        try {
            //Abre y lee el fichero recibido como parámetro 
            FileReader f = new FileReader(ficheroEntrada);
            BufferedReader b = new BufferedReader(f);

            try {
                //Añade "contenidoEntradaFichero" a el ArrayList "listadoDatosClientes"
                while ((contenidoEntradaFichero = b.readLine()) != null) {
                    listadoDatosClientes.add(contenidoEntradaFichero);
                }
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(ficheroEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("El fichero de datos de entrada no existe en el directorio actual");

        }
    }
}
