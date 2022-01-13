
package salidaDatosAplicacion;

import entradaDatosAplicacion.*;
import java.util.*;
import org.w3c.dom.*;

/**
 *Clase para transormar el ArrayList de la clase clientes en un 
 * documento válido .xml a través de la librería DOM y haciendo uso 
 * de la clase DOMUtil facilitada en la tarea
 * @author Daniel Paz Lorenzo
 */
public class transformarDatosAXML {

    /**
     * Método void para generar documento .xml a través de la llamada a otros 
     * métodos de clase
     * @param listaDatosCliente lista de todos los clientes de la clase cliente
     */
    public static void crearDocumentoXml(ArrayList<datosCliente> listaDatosCliente) {
        String nombreArchivoXML;
        Scanner teclado = new Scanner(System.in);

        // Creamos un árbol DOM vacio con el nombre "datos_clientes"
        Document doc = DOMUtil.crearDOMVacio("datos_clientes");

        // Pasamos los datos del cliente al DOM
        transferirDatosDOM(doc, listaDatosCliente);

        // Guardamos el XML en un archivo solicitando nombre o ruta
        do {
            System.out.println("Introduzca el nombre del archivo XML que desea crear: ");
            nombreArchivoXML = teclado.next().concat(".xml");//Añadimos la extensión .xml al nombre 
            
            if (DOMUtil.DOM2XML(doc, nombreArchivoXML)) {
                guardarArchivoXml(doc, nombreArchivoXML);
                System.out.println("El archivo " + nombreArchivoXML + " se ha creado satisfactoriamente");
            } else {
                System.err.println("No se pudo crear el archivo, nombre mal expecificado");
            }
        } while (DOMUtil.DOM2XML(doc, nombreArchivoXML) == false);
    }

    /**
     * Método para generar el DOM, paso previo a generar nuestro documento xml
     * @param doc instancia de la clase Document generada anteriormente
     * @param listaDatosCliente lista de todos los clientes de la clase cliente
     */
    public static void transferirDatosDOM(Document doc, ArrayList<datosCliente> listaDatosCliente) {
        //Declaración de variables
        String validezDni;

        //Recorremos la lista de clientes
        for (datosCliente datcliente : listaDatosCliente) {
            Integer contadorNumTelefonos = 0;
            
            //Generamos el primer elemento
            Element cliente = doc.createElement("cliente");
            doc.getDocumentElement().appendChild(cliente);
            
            //Generamos el elemento dni, asignamos contenido y lo anidamos a la clase cliente
            Element dni = doc.createElement("id");
            cliente.appendChild(dni);
            dni.setTextContent(datcliente.dni);
            //Comprobamos la validez del dni para mostrar como comentario si es válido o no
            if (comprobarDatosEntrada.comprobarDniNie(datcliente.dni)) {
                validezDni = ("El DNI/NIE es válido");
            } else {
                validezDni = ("El DNI/NIE no es válido");
            }
            Comment comentario = doc.createComment(validezDni);
            dni.appendChild(comentario);

            //Generamos el elemento nombre, asignamos contenido y lo anidamos a la clase cliente
            Element nombre = doc.createElement("nombre");
            nombre.setTextContent(datcliente.nombre);
            cliente.appendChild(nombre);

            //Generamos el elemento apellidos, asignamos contenido y lo anidamos a la clase cliente
            Element apellidos = doc.createElement("apellidos");
            apellidos.setTextContent(datcliente.apellidos);
            cliente.appendChild(apellidos);

            //Generamos el elemento telefonos, asignamos contenido y lo anidamos a la clase cliente
            Element telefonos = doc.createElement("telefonos");
            //Distinguimos entre telefonos locales e internacionales y los anidamos al elemnto telefonos
            for (Long tlf : datcliente.numLocales) {
                Element telefono = doc.createElement("telefono");
                telefono.setTextContent(tlf.toString());
                telefonos.appendChild(telefono);
                contadorNumTelefonos += 1;
            }
            for (Long tlf : datcliente.numInternacionales) {
                Element telefono = doc.createElement("telefono");
                telefono.setTextContent("+" + tlf.toString());
                telefonos.appendChild(telefono);
                contadorNumTelefonos += 1;
            }
            cliente.appendChild(telefonos);
            
            //Se agrega el atributo "total" al nodo teléfonos y su valor calculado
            Attr total = doc.createAttribute("total");
            total.setValue(contadorNumTelefonos.toString());
            telefonos.setAttributeNode(total);

            //Generamos el elemento mails, asignamos contenido y lo anidamos a la clase cliente
            Element mails = doc.createElement("mails");
            //Creamos una etiqueta "mail" para cada mail de cliente y anidamos a elemento mails
            for (String email : datcliente.emails) {
                Element mail = doc.createElement("mail");
                mail.setTextContent(email);
                mails.appendChild(mail);
            }
            cliente.appendChild(mails);
        }
    }

    /**
     * Método que llama a método de la clase DOMUtil para guardar el documento
     * @param doc instancia de la clase Document generada anteriormente
     * @param nombreArchivoXML nombre o ruta del documento elegida por el usuario
     */
    public static void guardarArchivoXml(Document doc, String nombreArchivoXML) {
        DOMUtil.DOM2XML(doc, nombreArchivoXML);
    }
}
