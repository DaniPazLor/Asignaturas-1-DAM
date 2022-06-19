package vista;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que contiene los métodos para mostrar por pantalla la tabla de el
 * resultado obtenido al realizar la consulta a la base de datos
 *
 * @author Daniel Paz Lorenzo
 */
public class TablasVirtuales {

    /**
     * Método para mostrar por pantalla la tabla clientes
     *
     * @param resultadosClientes del tipo ResultSet resultado de la consulta
     * 'tabla clientes'
     */
    public void mostrarTablaVirtualClientes(ResultSet resultadosClientes) {
        //Creamos la tabla virtual de clientes a través del objeto JTable utilizando el modelo DefaultTableModel
        String[] nombresColumnas = {"Cod. Cliente", "Nombre", "Telefono"};
        DefaultTableModel modeloTabla = new DefaultTableModel(nombresColumnas, 0);
        modeloTabla.addRow(nombresColumnas);

        JTable table = new JTable(modeloTabla);
        table.getColumn("Cod. Cliente").setPreferredWidth(80);
        table.getColumn("Nombre").setPreferredWidth(150);
        table.getColumn("Telefono").setPreferredWidth(80);

        try {
            //Añadimos las filas contenidas en la tabla al objeto table
            while (resultadosClientes.next()) {
                modeloTabla.addRow(new Object[]{resultadosClientes.getInt("COD_CLIENTE"),
                    resultadosClientes.getString("NOMBRE"),
                    resultadosClientes.getString("TELEFONO")});
            }
            //Mostramos por pantalla el objeto table en un JOptionPane
            JOptionPane.showMessageDialog(null, table, "RESULTADOS DE LA TABLA CLIENTES", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método para mostrar por pantalla la tabla escrituras
     *
     * @param resultadosEscrituras del tipo ResultSet resultado de la consulta
     * 'tabla escrituras'
     */
    public void mostrarTablaVirtualEscrituras(ResultSet resultadosEscrituras) {
        //Creamos la tabla virtual de escrituras a través del objeto JTable utilizando el modelo DefaultTableModel
        String[] nombresColumnas = {"COD. ESCRITURA", "COD. CLIENTE", "TIPO", "NOMBRE DE FICHERO", "INTERVINIENTES"};
        DefaultTableModel modeloTabla = new DefaultTableModel(nombresColumnas, 0);
        modeloTabla.addRow(nombresColumnas);

        JTable table = new JTable(modeloTabla);
        table.getColumn("COD. ESCRITURA").setPreferredWidth(120);
        table.getColumn("COD. CLIENTE").setPreferredWidth(100);
        table.getColumn("TIPO").setPreferredWidth(80);
        table.getColumn("NOMBRE DE FICHERO").setPreferredWidth(300);
        table.getColumn("INTERVINIENTES").setPreferredWidth(120);

        try {
            //Añadimos las filas contenidas en la tabla al objeto table
            while (resultadosEscrituras.next()) {
                modeloTabla.addRow(new Object[]{resultadosEscrituras.getString("COD_ESCRITURA"),
                    resultadosEscrituras.getInt("CODCLI"), resultadosEscrituras.getString("TIPO"),
                    resultadosEscrituras.getString("NOM_FICH"), resultadosEscrituras.getInt("NUM_INTERV")});
            }
            //Mostramos por pantalla el objeto table en un JOptionPane
            JOptionPane.showMessageDialog(null, table, "RESULTADOS DE LA TABLA ESCRITURAS", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que muestra los nombres de clientes que han realizado compraventa
     *
     * @param resultadosClientesCPVE ResultSet resultado de la consulta
     * 'clientes CPVE'
     */
    public void mostrarTablaVirtualEscriturasCPVE(ResultSet resultadosClientesCPVE) {
        //Creamos la tabla virtual de escrituras a través del objeto JTable utilizando el modelo DefaultTableModel
        String[] nombresColumnas = {"Nombre", "TIPO"};
        DefaultTableModel modeloTabla = new DefaultTableModel(nombresColumnas, 0);
        modeloTabla.addRow(nombresColumnas);

        JTable table = new JTable(modeloTabla);
        table.getColumn("Nombre").setPreferredWidth(120);
        table.getColumn("TIPO").setPreferredWidth(80);

        try {
            //Añadimos las filas contenidas en la tabla al objeto table
            while (resultadosClientesCPVE.next()) {
                modeloTabla.addRow(new Object[]{resultadosClientesCPVE.getString("NOMBRE"), resultadosClientesCPVE.getString("TIPO")});
            }
            //Mostramos por pantalla el objeto table en un JOptionPane
            JOptionPane.showMessageDialog(null, table, "RESULTADOS DE LA TABLA CLIENTES COMPRAVENTA", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
