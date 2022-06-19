package vista;

import java.sql.*;
import javax.swing.*;
import modelo.*;
import controlador.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PAUDA
 */
public class PantallasVisualizacion extends JFrame {

    TablaClientes cliente;
    TablaEscrituras escritura;
    GestionDatos gestionDato;
    JFrame marcoTabla;
    MenuOpciones menuPrincipal;

    public PantallasVisualizacion() {
        /*gestionDato = new GestionDatos();
        this.marcoTabla = new JFrame();
        marcoTabla.setTitle("APLICACION BASES DE DATOS");
        marcoTabla.setBounds(300, 300, 300, 300);
        marcoTabla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoTabla.setVisible(true);
        mostrarMenu();*/
        gestionDato = new GestionDatos();
        
        MenuOpciones menuPrincipal = new MenuOpciones();
        menuPrincipal.setVisible(true);
    }

    public void mostrarMenu() {

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
                    cliente.nombre = JOptionPane.showInputDialog(null, "Introduzca Nombre del Cliente", "Inserccion de datos en la tabla CLIENTES", JOptionPane.QUESTION_MESSAGE);
                    cliente.telefono = JOptionPane.showInputDialog(null, "Introduzca número de telefono del Cliente", "Inserccion de datos en la tabla CLIENTES", JOptionPane.QUESTION_MESSAGE);
                    //gestionDato.insertarDatosClienteBBDD(cliente);
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
                    String sentenciaSQL = "SELECT * FROM CLIENTES";
                    ResultSet resultadosClientes=gestionDato.obtenerTablaResultados(sentenciaSQL);
                    mostrarTablaVirtualClientes(resultadosClientes);
                    //termino=new Terminos(JOptionPane.showInputDialog("Introduzca el término que desea buscar"));
                    //mostrarTablaResultadosVirtual(gestionDato.obtenerTablaResultados(sentenciaSQL));
                    break;
                case 4:
                    
                    break;
                case 5:
                    break;
                case 6:
                    
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "HASTA LA PRÓXIMA!", "Mensaje de despedida", JOptionPane.PLAIN_MESSAGE);
                    break;
                default: {
                    try {
                        gestionDato.conexionBBDD.conexion.close();
                        System.out.println("Desconexión al esquema TAREA11");
                    } catch (SQLException ex) {
                        Logger.getLogger(PantallasVisualizacion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                JOptionPane.showMessageDialog(null, "Opción seleccionada incorrecta\nPor favor elija del 1-7", "ERROR", JOptionPane.ERROR_MESSAGE);
                break;

            }
        } while (op !=7);
    }

    public void mostrarTablaVirtualClientes(ResultSet resultadosClientes) {
        

        
        DefaultTableModel model = new DefaultTableModel(new String[] {"Codigo Cliente", "Nombre", "Telefono"},0);
        JTable table = new JTable(model);

        marcoTabla.add(new JScrollPane(table), BorderLayout.CENTER);

// Create a couple of columns 
        //model.addColumn("Codigo Cliente");
       // model.addColumn("Nombre");
       // model.addColumn("Telefono");
        
        try {
            while (resultadosClientes.next()) {
            // Append a row
            model.addRow(new Object[]{resultadosClientes.getInt("COD_CLIENTE") , resultadosClientes.getString("NOMBRE"), resultadosClientes.getString("TELEFONO")});
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(PantallasVisualizacion.class.getName()).log(Level.SEVERE, null, ex);
        }

           /*         try {
            System.out.println("COD_CLIENTE  " + "NOMBRE  " + "   TELEFONO  ");
            System.out.println("______________________________________");
            while (resultadosClientes.next()) {
            
            //JOptionPane.showMessageDialog(null,tablaResultados.getInt("ID_RECURSO")+"   "+tablaResultados.getString("TERMINO")+"   "+tablaResultados.getInt("NUMERO_MUESTRAS"),"TABLA VIRTUAL DE RECURSOS", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(resultadosClientes.getInt("COD_CLIENTE") + "\t     "
            + resultadosClientes.getString("NOMBRE") + "\t"
            + resultadosClientes.getString("TELEFONO"));
            }
            resultadosClientes.close();
            } catch (SQLException ex) {
            Logger.getLogger(PantallasVisualizacion.class.getName()).log(Level.SEVERE, null, ex);
            }*/
    }
}
