/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.*;
import javax.swing.*;
import controlador.*;

/**
 *
 * @author PAUDA
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //PantallasVisualizacion menuOpciones=new PantallasVisualizacion();
        
             GestionDatos   gestionDato = new GestionDatos();
        
        MenuOpciones menuPrincipal = new MenuOpciones();
       
        menuPrincipal.setVisible(true);
        
        
        
        

    }
   
}
