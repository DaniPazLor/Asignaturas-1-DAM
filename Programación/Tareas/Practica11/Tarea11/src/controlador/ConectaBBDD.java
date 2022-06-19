package controlador;

import java.sql.*;

/**
 *
 * @author Daniel Paz Lorenzo
 */
public class ConectaBBDD {

    public Connection conexion;

    /**
     * Método para conectar con la base de datos de Oracle
     *
     */
    public ConectaBBDD() {
        try {
            //Comprobamos que el driver JDBC funciona correctamente y 
            //conectamos con la BBDD de Oracle mostrando mensaje 
            //de estado a través de la consola
            Class.forName("oracle.jdbc.OracleDriver");
            String ServidorBaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
            this.conexion = DriverManager.getConnection(ServidorBaseDeDatos, "TAREA11", "5678");
            if (this.conexion != null) {
                System.out.println("Conexion exitosa a esquema TAREA11");
            } else {
                System.out.println("Conexion fallida");
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
