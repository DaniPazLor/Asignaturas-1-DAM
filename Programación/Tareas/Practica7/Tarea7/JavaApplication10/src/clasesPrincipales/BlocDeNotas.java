package clasesPrincipales;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.DefaultEditorKit;

/**
 * Clase para definir la estructura del bloc de notas definiendo el constructor
 *
 * @author Daniel Paz Lorenzo
 */
public class BlocDeNotas extends JFrame {

    //Declaracion de atributos y objetos de clase
    JFrame ventanaBloc;

    JMenu menuFichero;
    JMenu menuEditar;

    JTextArea areaTexto;

    JMenuItem opNuevo;
    JMenuItem opAbrir;
    JMenuItem opGuardar;
    JMenuItem opGuardarComo;
    JMenuItem opCortar;
    JMenuItem opCopiar;
    JMenuItem opPegar;
    JMenuItem Salir;

    File nombreArchivo;

    /**
     * Constructor de la clase donde vamos a definir la estructura para cuando
     * se haga la instancia del objeto de la clase blocdenotas
     */
    public BlocDeNotas() {

        //Creamos ventana global donde vamos a incorporar el resto de elementos
        this.ventanaBloc = new JFrame("BLOC DE NOTAS");
        ventanaBloc.setBounds(0, 0, 1500, 1000);//Cambiar a codigo para que se adapte a pantalla
        ventanaBloc.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventanaBloc.setIconImage(Toolkit.getDefaultToolkit().getImage("icono.png"));
        ventanaBloc.setBackground(Color.LIGHT_GRAY);

        //Creamos una barra de menu y le asignamos color fondo
        JMenuBar barraMenu = new JMenuBar();
        barraMenu.setBackground(Color.lightGray);

        //Definimos las 2 opciones de menu
        this.menuFichero = new JMenu("Fichero");
        this.menuEditar = new JMenu("Editar");

        //Definimos todos los Menuitem que iran dentro del menu
        this.opNuevo = new JMenuItem("Nuevo");
        this.opAbrir = new JMenuItem("Abrir");
        this.opGuardar = new JMenuItem("Guardar");
        this.opGuardarComo = new JMenuItem("Guardar como");
        
        //Creamos las opciones cortar, copiar y pegar añadiendoles
        //acciones correspondientes valiendonos de la clase DefaultEditorKit
        Action accionCopiar = new DefaultEditorKit.CopyAction();
        accionCopiar.putValue(Action.NAME, "Copiar");
        this.opCopiar = new JMenuItem(accionCopiar);

        Action accionCortar = new DefaultEditorKit.CutAction();
        accionCortar.putValue(Action.NAME, "Cortar");
        this.opCortar = new JMenuItem(accionCortar);

        Action accionPegar = new DefaultEditorKit.PasteAction();
        accionPegar.putValue(Action.NAME, "Pegar");
        this.opPegar = new JMenuItem(accionPegar);

        this.Salir = new JMenuItem("Salir");

        //Añadimos cada Menuitem a su correspondiente menu
        menuFichero.add(opNuevo);
        menuFichero.add(opAbrir);
        menuFichero.add(opGuardar);
        menuFichero.add(opGuardarComo);
        menuFichero.addSeparator();
        menuFichero.add(Salir);

        menuEditar.add(opCortar);
        menuEditar.add(opCopiar);
        menuEditar.add(opPegar);

        //Añadimos los 2 menús a la barramenu
        barraMenu.add(menuFichero);
        barraMenu.add(menuEditar);
        //Añadimos la barramenu a la ventana principal del bloc de notas
        ventanaBloc.setJMenuBar(barraMenu);

        //Creamos un objeto del tipo textArea y lo añadimos a la ventan principal
        this.areaTexto = new JTextArea();
        ventanaBloc.add(this.areaTexto);

        //Hacemos que la ventana sea visible y la configuramos para que cierre el programa cuando se cierra la ventana
        ventanaBloc.setVisible(true);
        ventanaBloc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
