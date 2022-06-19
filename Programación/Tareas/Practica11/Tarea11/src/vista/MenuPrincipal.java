package vista;

import java.sql.*;
import javax.swing.*;
import modelo.*;
import controlador.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para la gestion de las pantallas de visualización de la aplicación
 *
 * @author Daniel Paz Lorenzo
 */
public class MenuPrincipal {

    //Declaramos los objetos como atributos de la clase
    TablaClientes cliente;
    TablaEscrituras escritura;
    GestionDatos gestionDato;

    /**
     * Constructor de la clase donde instanciamos la clase gestion datos y y
     * llamamos al método para que muestre el menú
     */
    public MenuPrincipal() {
        gestionDato = new GestionDatos();
        mostrarMenu();
    }

    /**
     * Método que interactúa con el usuario mediante métodos de la clase
     * JPanelOption
     */
    public void mostrarMenu() {
        //Declaración de atributos y objetos
        TablasVirtuales tablaVirtual = new TablasVirtuales();
        String sentenciaSQL;
        int op;

        do {
            //Mostramos el menú principal y recogemos la elección del usuario
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "1.- Insertar datos en la tabla CLIENTES\n"
                    + "2.- Insertar datos en la tabla ESCRITURAS\n"
                    + "3.- Recuperar datos de la tabla CLIENTES\n"
                    + "4.- Recuperar datos de la tabla ESCRITURAS\n"
                    + "5.- Actualizar nombre y telefono de la tabla CLIENTES\n"
                    + "6.- Listado de clientes que han realizado compraventa\n"
                    + "7.- Salir de la aplicación ", "MENÚ DE OPCIONES", JOptionPane.QUESTION_MESSAGE));

            switch (op) {
                case 1:
                    //Solicitamos al usuario los datos y llamamos al método para insertarlos
                    cliente = new TablaClientes();
                    cliente.nombre = JOptionPane.showInputDialog(null, "Introduzca nombre del cliente", "Inserccion de datos en la tabla CLIENTES", JOptionPane.QUESTION_MESSAGE);
                    cliente.telefono = JOptionPane.showInputDialog(null, "Introduzca número de telefono del Cliente", "Inserccion de datos en la tabla CLIENTES", JOptionPane.QUESTION_MESSAGE);

                    if (gestionDato.insertarDatosClienteBBDD(cliente)) {
                        JOptionPane.showMessageDialog(null, "Los datos han sido introducidos correctamente", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al intentar insertar los datos", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 2:
                    //Solicitamos al usuario los datos y llamamos al método para insertarlos
                    escritura = new TablaEscrituras();
                    escritura.codEscritura = JOptionPane.showInputDialog(null, "Introduzca codigo de escritura", "Inserccion de datos en la tabla ESCRITURA", JOptionPane.QUESTION_MESSAGE);
                    escritura.tipo = JOptionPane.showInputDialog(null, "Introduzca el tipo de escritura ('TEST' O 'CPVE')", "Inserccion de datos en la tabla ESCRITURA", JOptionPane.QUESTION_MESSAGE);
                    escritura.nom_Fichero = JOptionPane.showInputDialog(null, "Introduzca un nombre para el fichero (Ej:'compraventa_AntonioBJ_10_12_2010.doc')", "Inserccion de datos en la tabla ESCRITURA", JOptionPane.QUESTION_MESSAGE);
                    escritura.num_Intervinientes = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca el número de intervinientes", "Inserccion de datos en la tabla ESCRITURA", JOptionPane.QUESTION_MESSAGE));
                    escritura.codCliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca el código del cliente al que asociar la escritura", "Inserccion de datos en la tabla ESCRITURA", JOptionPane.QUESTION_MESSAGE));

                    if (gestionDato.insertarDatosEscrituraBBDD(escritura)) {
                        JOptionPane.showMessageDialog(null, "Los datos han sido introducidos correctamente", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al intentar insertar los datos", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 3:
                    //Creamos la secuencia SQL y la pasamos como parámetro a los 
                    //métodos correspondientes para mostrar la tabla clientes por pantalla
                    sentenciaSQL = "SELECT * FROM CLIENTES";
                    ResultSet resultadosClientes = gestionDato.obtenerTablaResultados(sentenciaSQL);
                    tablaVirtual.mostrarTablaVirtualClientes(resultadosClientes);
                    break;

                case 4:
                    //Creamos la secuencia SQL y la pasamos como parámetro a los 
                    //métodos correspondientes para mostrar la tabla escrituras por pantalla
                    sentenciaSQL = "SELECT * FROM ESCRITURAS";
                    ResultSet resultadosEscrituras = gestionDato.obtenerTablaResultados(sentenciaSQL);
                    tablaVirtual.mostrarTablaVirtualEscrituras(resultadosEscrituras);
                    break;

                case 5:
                    //Solicitamos al usuario los nuevos datos para posteriormente actualizarlos en la BBDD
                    cliente = new TablaClientes();
                    cliente.cod_Cliente = JOptionPane.showInputDialog(null, "Introduzca el código del cliente que desea modificar", "Actualizar datos en la tabla CLIENTES", JOptionPane.QUESTION_MESSAGE);
                    cliente.nombre = JOptionPane.showInputDialog(null, "Introduzca el nuevo nombre", "Actualizar datos en la tabla CLIENTES", JOptionPane.QUESTION_MESSAGE);
                    cliente.telefono = JOptionPane.showInputDialog(null, "Introduzca el nuevo número de teléfono", "Actualizar datos en la tabla CLIENTES", JOptionPane.QUESTION_MESSAGE);

                    if (gestionDato.actualizarDatosCliente(cliente)) {
                        JOptionPane.showMessageDialog(null, "Los datos han sido modificados correctamente", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al intentar modificar los datos", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 6:
                    //Muestra por pantalla la sentencia SQL 
                    sentenciaSQL = "SELECT c.nombre, es.tipo FROM Clientes c INNER JOIN escrituras es ON c.cod_cliente=es.codcli WHERE es.tipo='CPVE'";
                    ResultSet resultadosClientesCPVE = gestionDato.obtenerTablaResultados(sentenciaSQL);
                    tablaVirtual.mostrarTablaVirtualEscriturasCPVE(resultadosClientesCPVE);
                    break;

                case 7:
                    JOptionPane.showMessageDialog(null, "HASTA LA PRÓXIMA!", "Mensaje de despedida", JOptionPane.PLAIN_MESSAGE);
                    break;

                default: {
                    try {
                        gestionDato.conexionBBDD.conexion.close();
                        System.out.println("Desconexión al esquema TAREA11");
                    } catch (SQLException ex) {
                        Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                JOptionPane.showMessageDialog(null, "Opción seleccionada incorrecta\nPor favor elija del 1-7", "ERROR", JOptionPane.ERROR_MESSAGE);
                break;
            }
        } while (op != 7);
    }
}
