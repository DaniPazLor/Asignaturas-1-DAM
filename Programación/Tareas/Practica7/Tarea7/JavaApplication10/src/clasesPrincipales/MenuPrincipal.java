package clasesPrincipales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

/**
 * Clase que contiene el metodo principal main
 *
 * @author Daniel Paz Lorenzo
 */
public class MenuPrincipal {

    //Declaracion de objetos de clase
    File archivoPath;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declaración de objetos de las 3 clases del programa
        BlocDeNotas blocNotas = new BlocDeNotas();
        MetodosBlocNotas metBlocNotas = new MetodosBlocNotas();
        MenuPrincipal mPrincipal = new MenuPrincipal();

        //Creación de clases oyentes para cada menuItem del programa
        //Llamada a método correspondiente dependiendo del evento recibido por teclado o ratón
        blocNotas.opNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mPrincipal.archivoPath = metBlocNotas.nuevoDocumento(blocNotas.areaTexto, blocNotas.nombreArchivo, blocNotas.ventanaBloc);
            }
        });
        blocNotas.opAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mPrincipal.archivoPath = metBlocNotas.abrirDocumento(blocNotas.opAbrir, blocNotas.nombreArchivo, blocNotas.ventanaBloc, blocNotas.areaTexto);
                if (mPrincipal.archivoPath != null) {
                    JOptionPane.showMessageDialog(null, "Documento " + mPrincipal.archivoPath + " abierto ");
                }

            }
        });
        blocNotas.opGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Recoge el texto que hay dentro del componente areaText
                String texto = blocNotas.areaTexto.getText();
                mPrincipal.archivoPath = metBlocNotas.guardarDocumento(texto, mPrincipal.archivoPath, blocNotas.nombreArchivo, blocNotas.ventanaBloc, blocNotas.opGuardarComo, blocNotas.areaTexto);
            }
        });
        blocNotas.opGuardarComo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mPrincipal.archivoPath = metBlocNotas.guardarDocumentoComo(blocNotas.opGuardarComo, mPrincipal.archivoPath, blocNotas.nombreArchivo, blocNotas.areaTexto, blocNotas.ventanaBloc);
            }
        });
        blocNotas.Salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}
