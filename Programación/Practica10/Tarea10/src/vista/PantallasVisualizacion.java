/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import modelo.*;
import controlador.*;

/**
 *
 * @author PAUDA
 */
public class PantallasVisualizacion extends JFrame{
    Terminos termino;
    GestionDatos gestionDato;
    
    public PantallasVisualizacion(){
        gestionDato= new GestionDatos();
        mostrarMenu();            
    }
    
    public void mostrarMenu(){
        
        int op;
        do{
        op=Integer.parseInt(JOptionPane.showInputDialog("1.-Insertar nuevo término\n2.-Borrar un término\n3.-Consultar un término"));
        
        switch(op){
            case 1:
                boolean existeTermino=true;
                termino=new Terminos(JOptionPane.showInputDialog("Introduzca un nuevo término"));
                existeTermino=gestionDato.comprobarExisteTermino(termino);
                
                if(existeTermino){
                    JOptionPane.showMessageDialog(null,"El término ya existe en la BBDD","ERROR", JOptionPane.ERROR_MESSAGE);
                }else{
                    gestionDato.insertarTerminoBBDD(termino);
                    JOptionPane.showMessageDialog(null,"El término ha sido introducido correctamente","INFORMACION", JOptionPane.INFORMATION_MESSAGE);                    
                }
                break;
            case 2:
                termino=new Terminos(JOptionPane.showInputDialog("Introduzca el término que desea borrar"));
                break;
            case 3:
                termino=new Terminos(JOptionPane.showInputDialog("Introduzca el término que desea buscar"));
                //String sentenciaSQL = "SELECT * FROM RECURSOS";
                //mostrarTablaResultadosVirtual(gestionDato.obtenerTablaResultados(sentenciaSQL));
                break;
            default:
                JOptionPane.showMessageDialog(null,"Opción seleccionada incorrecta\nPor favor introduzca un número del 1-3)","ERROR", JOptionPane.ERROR_MESSAGE);
                break;
        }
        }while(op<1 || op>3);
    }
    
    
    
    public void mostrarTablaResultadosVirtual(ResultSet  tablaResultados){
        /*  DefaultTableModel dtm = new DefaultTableModel(datos, columnNames);
        final JTable table = new JTable(dtm);

        // Agregar nueva columna
        String[] columnaNueva1 = {"vago", "diestro", "normal",};
        dtm.addColumn("Tipo", columnaNueva1);

        // Agregar nueva fila
        Object[] newRow = {"Maria", 55, false};
        dtm.addRow(newRow);

        // Modificar celda especifica
        dtm.setValueAt("XXX", 3, 3); // Row/Col

        table.setPreferredScrollableViewportSize(new Dimension(250, 100));
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);       
        addWindowListener(new WindowAdapter() {           
            public void windowClosing(WindowEvent e) {
                System.exit(0);               
            }
        */
     /*          try {
            while(resultados.next()){
                
                //JOptionPane.showMessageDialog(null,tablaResultados.getInt("ID_RECURSO")+"   "+tablaResultados.getString("TERMINO")+"   "+tablaResultados.getInt("NUMERO_MUESTRAS"),"TABLA VIRTUAL DE RECURSOS", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(resultados.getString("VALOR"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PantallasVisualizacion.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
}
