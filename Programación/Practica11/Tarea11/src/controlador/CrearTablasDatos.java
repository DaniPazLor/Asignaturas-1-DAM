package controlador;

import java.sql.*;
import java.util.logging.*;

/**
 * Clase donde se incluyen 2 métodos para insertar datos de prueba en la base de
 * datos
 *
 * @author Daniel Paz Lorenzo
 */
public class CrearTablasDatos {

    /**
     * Método para crear las tablas en la base de datos si no existieran ya
     *
     * @param clientes boolean=true si hay que crear la tabla
     * @param escrituras boolean=true si hay que crear la tabla
     * @return exito=true si la creación se ha producido sin errores
     */
    public boolean crearTablasBBDD(ConectaBBDD conexionBBDD,boolean clientes, boolean escrituras) {
        boolean exito = false;
        if (clientes) {
            try {
                //Creamos la tabla''CLIENTES'
                String sentenciaSQL = "CREATE TABLE Clientes ("
                        + "    Cod_cliente INTEGER,"
                        + "    Nombre VARCHAR2(20),"
                        + "    Telefono VARCHAR2(10),"
                        + "    CONSTRAINT con_cli_pk PRIMARY KEY (Cod_Cliente))";
                PreparedStatement consultaPreparada = conexionBBDD.conexion.prepareStatement(sentenciaSQL);
                consultaPreparada.executeQuery();

                //Generamos una sucencia y un trigger para que se incremente automáticamente el Cod_cliente
                //Hacemos esto porque Oracle no tiene opción de AUTO_INCREMENT
                sentenciaSQL = "CREATE SEQUENCE cliente_seq START WITH 1";
                consultaPreparada.executeQuery(sentenciaSQL);
                sentenciaSQL = "CREATE OR REPLACE TRIGGER clientes_bir "
                        + "BEFORE INSERT ON clientes "
                        + "FOR EACH ROW "
                        + "BEGIN"
                        + "  SELECT cliente_seq.NEXTVAL"
                        + "  INTO   :new.Cod_cliente"
                        + "  FROM   dual;"
                        + "END;";
                consultaPreparada.executeQuery(sentenciaSQL);
                exito = true;
            } catch (SQLException ex) {
                exito = false;
                Logger.getLogger(GestionDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (escrituras) {
            try {
                //Creamos la tabla''ESCRITURAS'
                String sentenciaSQL = "CREATE TABLE Escrituras ("
                        + "    Cod_Escritura VARCHAR2(10),"
                        + "    codCli INTEGER,"
                        + "    Tipo VARCHAR2(10),"
                        + "    Nom_fich VARCHAR2(80),"
                        + "    Num_interv INTEGER,"
                        + "    CONSTRAINT codEsc_pk PRIMARY KEY (Cod_Escritura),"
                        + "    CONSTRAINT codCl_FK FOREIGN KEY (codCli) REFERENCES Clientes(cod_cliente))";

                PreparedStatement consultaPreparada;
                consultaPreparada = conexionBBDD.conexion.prepareStatement(sentenciaSQL);
                consultaPreparada.executeQuery();
                exito = true;
            } catch (SQLException ex) {
                exito = false;
                Logger.getLogger(GestionDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return exito;
    }

    /**
     * Método que no devuelve nada con el que insertamos datos de ejemplo en las
     * 2 tablas
     */
    public void insertarDatosDePruebas(ConectaBBDD conexionBBDD) {

        try {
            //Insertamos 5 clientes 
            String sentenciaSQL = "INSERT INTO CLIENTES(NOMBRE, TELEFONO) VALUES (?,?)";
            PreparedStatement consultaPreparada = conexionBBDD.conexion.prepareStatement(sentenciaSQL);
            consultaPreparada.setString(1, "Juan");
            consultaPreparada.setString(2, "658235489");
            consultaPreparada.executeQuery();
            consultaPreparada.setString(1, "Pepe");
            consultaPreparada.setString(2, "666879525");
            consultaPreparada.executeQuery();
            consultaPreparada.setString(1, "Maria");
            consultaPreparada.setString(2, "689257893");
            consultaPreparada.executeQuery();
            consultaPreparada.setString(1, "Paola");
            consultaPreparada.setString(2, "979586243");
            consultaPreparada.executeQuery();

            //Insertamos 3 datos de ejemplo en la tabla escrituras
            sentenciaSQL = "INSERT INTO ESCRITURAS(COD_ESCRITURA, CODCLI, TIPO, NOM_FICH, NUM_INTERV) VALUES (?, ?, ?, ?, ?)";
            consultaPreparada = conexionBBDD.conexion.prepareStatement(sentenciaSQL);
            consultaPreparada.setString(1, "CV9895612");
            consultaPreparada.setInt(2, 1);
            consultaPreparada.setString(3, "CPVE");
            consultaPreparada.setString(4, "compraventa_Juan_12_10_2006.doc");
            consultaPreparada.setInt(5, 5);
            consultaPreparada.executeQuery();

            consultaPreparada.setString(1, "TES656211");
            consultaPreparada.setInt(2, 3);
            consultaPreparada.setString(3, "TEST");
            consultaPreparada.setString(4, "testamento_Maria_06_04_2008.doc");
            consultaPreparada.setInt(5, 2);
            consultaPreparada.executeQuery();

            consultaPreparada.setString(1, "CV266545");
            consultaPreparada.setInt(2, 4);
            consultaPreparada.setString(3, "CPVE");
            consultaPreparada.setString(4, "compraventa_Juan_09_08_2018.doc");
            consultaPreparada.setInt(5, 1);
            consultaPreparada.executeQuery();

            consultaPreparada.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestionDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
