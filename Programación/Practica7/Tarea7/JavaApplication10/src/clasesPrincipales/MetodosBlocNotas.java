package clasesPrincipales;

import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Clase que contiene todos los métodos a los que llamamos desde la clase
 * principal
 *
 * @author Daniel Paz Lorenzo
 */
public class MetodosBlocNotas extends JFrame {

    /**
     * Método para crear un nuevo documento
     *
     * @param areaTexto tipo areaText componente que genera area de texto
     * @param nombreArchivo tipo File contiene la dirección absoluta del archivo
     * @param ventanaBloc tipo JFrame componente del marco del bloc de notas
     * @return nombreArchivo
     */
    public File nuevoDocumento(JTextArea areaTexto, File nombreArchivo, JFrame ventanaBloc) {
        //Creacion de un panel de opciones para preguntar al usuario si desea generar nuevo documento o no
        JOptionPane opMenu = new JOptionPane();
        int confirmado = JOptionPane.showConfirmDialog(opMenu,"¿Desea crear un nuevo documento de texto?");

        if (JOptionPane.OK_OPTION == confirmado) {
            //Creación de nuevo area de texto, mensaje de información para el usuario
            areaTexto.setText("");
            nombreArchivo = null;
            ventanaBloc.setTitle("BLOC DE NOTAS");
            JOptionPane.showMessageDialog(null, "Nuevo documento creado");
        } else {
            JOptionPane.showMessageDialog(null, "cancelado");
        }
        return nombreArchivo;
    }

    /**
     * Método para abrir un nuevo documento de texto
     * 
     * @param opAbrir del tipo JMenuItem atributo opción de menu abrir documento
     * @param nombreArchivo tipo File contiene la dirección absoluta del archivo
     * @param ventanaBloc tipo JFrame componente del marco del bloc de notas
     * @param areaTexto tipo areaText componente que genera area de texto
     * @return nombreArchivo
     */
    public File abrirDocumento(JMenuItem opAbrir, File nombreArchivo, JFrame ventanaBloc, JTextArea areaTexto) {
        //Creamos un objeto del tipo Filechooser para poder interactuar con los archivos y docuemntos del ordenador
        String texto = "";
        JFileChooser abrirDoc = new JFileChooser();
        abrirDoc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        //Creamos un filtro para que solo nos aparezcan documentos del tipo .txt
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
        abrirDoc.setFileFilter(filtro);

        //Abre una ventana para navegar por los archivos del sistema
        //Evalúa la selección que hace el usuario
        int seleccion = abrirDoc.showOpenDialog(opAbrir);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            nombreArchivo = abrirDoc.getSelectedFile();
            ventanaBloc.setTitle("BLOC DE NOTAS  Nombre del archivo: " + nombreArchivo.getName());
            try {
                try ( //Lee el archivo elegido lo guarda en un String y lo añade a la zona de texto
                        Scanner input = new Scanner(nombreArchivo)) {
                    while (input.hasNextLine()) {
                        texto += input.nextLine() + "\n";
                        areaTexto.setText(texto);
                    }
                }
            } catch (FileNotFoundException ex) {
            }
        }
        return nombreArchivo;
    }

    /**
     * Método para guardar en un archivo el documento que tenemos en el area de texto
     * 
     * @param cadena String del texto que hay dentro del componente areaText
     * @param archivoPath Dirección absoluta del archivo
     * @param nombreArchivo tipo File contiene la dirección absoluta del archivo
     * @param ventanaBloc tipo JFrame componente del marco del bloc de notas
     * @param opGuardarComo del tipo JMenuItem atributo opción de menu guardar documento
     * @param areaTexto tipo areaText componente que genera area de texto
     * @return nombreArchivo
     */
    public File guardarDocumento(String cadena, File archivoPath, File nombreArchivo, JFrame ventanaBloc, JMenuItem opGuardarComo, JTextArea areaTexto) {
        //Objeto del tipo FIleWriter para poder añadir el texto a un archivo
        FileWriter escribir;
        
        //Evalúa si existe el archivo, si existe lo guarda directamente y sino 
        //llama al método guardar como para solicitar un nombre de archivo
        if (archivoPath != null) {
            try {
                escribir = new FileWriter(archivoPath);
                escribir.write(cadena);
                escribir.close();
                JOptionPane.showMessageDialog(null, "Documento " + archivoPath + "\nguardado con éxito");
                ventanaBloc.setTitle("BLOC DE NOTAS  Nombre del archivo: " + archivoPath.getName());
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar, ponga nombre al archivo");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar, en la salida");
            }
        } else {
            nombreArchivo = guardarDocumentoComo(opGuardarComo, archivoPath, nombreArchivo, areaTexto, ventanaBloc);
        }
        return nombreArchivo;
    }

    /**
     * 
     * @param opGuardarComo del tipo JMenuItem atributo opción de menu guardar documento
     * @param archivoPath Dirección absoluta del archivo
     * @param nombreArchivo tipo File contiene la dirección absoluta del archivo
     * @param areaTexto tipo areaText componente que genera area de texto
     * @param ventanaBloc tipo JFrame componente del marco del bloc de notas
     * @return nombreArchivo
     */
    public File guardarDocumentoComo(JMenuItem opGuardarComo, File archivoPath, File nombreArchivo, JTextArea areaTexto, JFrame ventanaBloc) {
        //Creamos un objeto del tipo Filechooser para poder interactuar con los archivos y docuemntos del ordenador
        JFileChooser guardar = new JFileChooser();
        guardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        //Muestra dialogo y evalúa selección del usuario
        int seleccion = guardar.showSaveDialog(opGuardarComo);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            nombreArchivo = guardar.getSelectedFile();
                archivoPath = nombreArchivo;
            guardarDocumento(areaTexto.getText(), archivoPath, nombreArchivo, ventanaBloc, opGuardarComo, areaTexto);
                        
        }
        return nombreArchivo;
    }
}
