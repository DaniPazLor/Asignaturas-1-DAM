/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.*;
import java.util.logging.*;
import modelo.*;

/**
 *
 * @author PAUDA
 */
public class GestionDatos {

    ConectaBBDD conexionBBDD;

    public GestionDatos() {
        this.conexionBBDD = new ConectaBBDD();
    }

    public boolean comprobarExisteTermino(Terminos termino) {
        boolean existeValor = true;
         ResultSet resultados = null;
         String sentenciaSQL= "select valor from terminos where valor=?";
         
        try {
            PreparedStatement consultaPreparada = conexionBBDD.conexion.prepareStatement(sentenciaSQL);
            consultaPreparada.setString(1, termino.valor);
            resultados = consultaPreparada.executeQuery();
            
            int count = 0;
            while (resultados.next()) {
                ++count;
            }

            if (count == 0) {
                existeValor=false;                        
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existeValor;
    }

   public void insertarTerminoBBDD (Terminos termino){
       
        try {
            String sentenciaSQL= "INSERT INTO TERMINOS(VALOR, NUMERO_MUESTRAS) VALUES (?,?)";
            
            PreparedStatement consultaPreparada = conexionBBDD.conexion.prepareStatement(sentenciaSQL);
            consultaPreparada.setString(1, termino.valor);
            consultaPreparada.setInt(2, termino.numMuestras);
            consultaPreparada.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
   }

   /* public ResultSet obtenerTablaResultados(String sentenciaSQL) {
        ResultSet tablaResultados = null;
        try {
            PreparedStatement consultaPreparada = conexionBBDD.conexion.prepareStatement(sentenciaSQL);

            tablaResultados = consultaPreparada.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(ConectaBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tablaResultados;
    }*/
}
