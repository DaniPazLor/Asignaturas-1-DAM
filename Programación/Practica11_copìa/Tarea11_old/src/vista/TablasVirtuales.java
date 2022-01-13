package vista;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PAUDA
 */
public class TablasVirtuales {

    public void mostrarTablaVirtualClientes(ResultSet resultadosClientes) {

        String[] nombresColumnas = {"Cod. Cliente", "Nombre", "Telefono"};

        DefaultTableModel modeloTabla = new DefaultTableModel(nombresColumnas, 0);

        JTable table = new JTable(modeloTabla);
        table.getColumn("Cod. Cliente").setPreferredWidth(80);
        table.getColumn("Nombre").setPreferredWidth(150);
        table.getColumn("Telefono").setPreferredWidth(80);

        modeloTabla.addRow(nombresColumnas);
        try {
            while (resultadosClientes.next()) {

                modeloTabla.addRow(new Object[]{resultadosClientes.getInt("COD_CLIENTE"), resultadosClientes.getString("NOMBRE"), resultadosClientes.getString("TELEFONO")});

            }

            JOptionPane.showMessageDialog(null, table, "RESULTADOS DE LA TABLA CLIENTES", JOptionPane.PLAIN_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(PanelesVisualizacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void mostrarTablaVirtualEscrituras(ResultSet resultadosEscrituras) {

        String[] nombresColumnas = {"COD. ESCRITURA", "COD. CLIENTE", "TIPO", "NOMBRE DE FICHERO", "INTERVINIENTES"};

        DefaultTableModel modeloTabla = new DefaultTableModel(nombresColumnas, 0);

        JTable table = new JTable(modeloTabla);
        table.getColumn("COD. ESCRITURA").setPreferredWidth(120);
        table.getColumn("COD. CLIENTE").setPreferredWidth(100);
        table.getColumn("TIPO").setPreferredWidth(80);
        table.getColumn("NOMBRE DE FICHERO").setPreferredWidth(300);
        table.getColumn("INTERVINIENTES").setPreferredWidth(120);

        modeloTabla.addRow(nombresColumnas);
        try {
            while (resultadosEscrituras.next()) {
                modeloTabla.addRow(new Object[]{resultadosEscrituras.getString("COD_ESCRITURA"),
                    resultadosEscrituras.getInt("CODCLI"), resultadosEscrituras.getString("TIPO"),
                    resultadosEscrituras.getString("NOM_FICH"), resultadosEscrituras.getInt("NUM_INTERV")});

            }

            JOptionPane.showMessageDialog(null, table, "RESULTADOS DE LA TABLA ESCRITURAS", JOptionPane.PLAIN_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(PanelesVisualizacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void mostrarTablaVirtualEscriturasCPVE(ResultSet resultadosClientesCPVE) {
        String[] nombresColumnas = {"Nombre", "TIPO"};

        DefaultTableModel modeloTabla = new DefaultTableModel(nombresColumnas, 0);

        JTable table = new JTable(modeloTabla);
        table.getColumn("Nombre").setPreferredWidth(120);
        table.getColumn("TIPO").setPreferredWidth(80);

        modeloTabla.addRow(nombresColumnas);
        try {
            while (resultadosClientesCPVE.next()) {

                modeloTabla.addRow(new Object[]{resultadosClientesCPVE.getString("NOMBRE"), resultadosClientesCPVE.getString("TIPO")});
            }

            JOptionPane.showMessageDialog(null, table, "RESULTADOS DE LA TABLA CLIENTES COMPRAVENTA", JOptionPane.PLAIN_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(PanelesVisualizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
