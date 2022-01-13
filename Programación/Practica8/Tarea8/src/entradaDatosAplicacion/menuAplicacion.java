package entradaDatosAplicacion;

import java.io.File;
import java.util.*;
import salidaDatosAplicacion.transformarDatosAXML;

/**
 * Clase principal de la aplicación donde va método main que la dirige
 *
 * @author Daniel Paz Lorenzo
 */
public class MenuAplicacion {

    /**
     * Método main
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declaración de variables, colecciones e instanciación objetos
        String pathFicheroEntrada = "entradaDatos.txt";
        File ficheroEntrada = new File(pathFicheroEntrada);
        ficheroEntrada contenidoArch = new ficheroEntrada(pathFicheroEntrada);
        ArrayList<datosCliente> listaDatosCliente = new ArrayList();

        //Comprueba si existe fichero de entrada y sino muestra mensaje error
        if (ficheroEntrada.exists()) {
            System.out.println("Recogemos los datos del archivo...\n");

            //Añadimos los datos cliente al arraylist de clientes
            for (String cliente : contenidoArch.listadoDatosClientes) {
                datosCliente datCliente = new datosCliente(cliente);
                listaDatosCliente.add(datCliente);
            }
            /*Mostramos por pantalla todos los datos del arraylist
            valiendonos de los métodos propios de la clase datosCliente*/
            for (datosCliente cliente : listaDatosCliente) {
                cliente.getDni();
                System.out.println(cliente.toString());
                cliente.getEmails();
                cliente.getTelefonos();
                System.out.println("\n");
            }
            //Llamada a método para generar documento xml pasando como parametros el listado de clientes
            transformarDatosAXML.crearDocumentoXml(listaDatosCliente);

        } else {
            //En caso de error muestra la dirección absoluta donde debería estar el fichero de entrada datos
            System.out.println(ficheroEntrada.getAbsolutePath());
        }
    }
}
