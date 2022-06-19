package vista;

import java.sql.*;
import javax.swing.*;
import modelo.*;
import controlador.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *Clase para la gestion de las pantallas de visualización de 
 * @author Daniel Paz Lorenzo
 */
public class PanelesVisualizacion extends JFrame {

    TablaClientes cliente;
    TablaEscrituras escritura;
    GestionDatos gestionDato;
    

    public PanelesVisualizacion() {
        gestionDato = new GestionDatos();
        mostrarMenu();
    }

    public void mostrarMenu() {
        TablasVirtuales tablaVirtual=new TablasVirtuales();
        String sentenciaSQL;
        int op;
        do {

            op = Integer.parseInt(JOptionPane.showInputDialog(null, "1.- Insertar datos en la tabla CLIENTES\n"
                    + "2.- Insertar datos en la tabla ESCRITURAS\n"
                    + "3.- Recuperar datos de la tabla CLIENTES\n"
                    + "4.- Recuperar datos de la tabla ESCRITURAS\n"
                    + "5.- Actualizar nombre y telefono de la tabla CLIENTES\n"
                    + "6.- Listado de clientes que han realizado compraventa\n"
                    + "7.- Salir de la aplicación ", "MENÚ DE OPCIONES", JOptionPane.QUESTION_MESSAGE));

            switch (op) {
                case 1:
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
                    sentenciaSQL = "SELECT * FROM CLIENTES";
                    ResultSet resultadosClientes = gestionDato.obtenerTablaResultados(sentenciaSQL);
                    tablaVirtual.mostrarTablaVirtualClientes(resultadosClientes);
                    //termino=new Terminos(JOptionPane.showInputDialog("Introduzca el término que desea buscar"));
                    //mostrarTablaResultadosVirtual(gestionDato.obtenerTablaResultados(sentenciaSQL));
                    break;
                case 4:
                    sentenciaSQL = "SELECT * FROM ESCRITURAS";
                    ResultSet resultadosEscrituras = gestionDato.obtenerTablaResultados(sentenciaSQL);
                    tablaVirtual.mostrarTablaVirtualEscrituras(resultadosEscrituras);
                    break;
                case 5:
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
                        Logger.getLogger(PanelesVisualizacion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                JOptionPane.showMessageDialog(null, "Opción seleccionada incorrecta\nPor favor elija del 1-7", "ERROR", JOptionPane.ERROR_MESSAGE);
                break;

            }
        } while (op != 7);
    }
}
