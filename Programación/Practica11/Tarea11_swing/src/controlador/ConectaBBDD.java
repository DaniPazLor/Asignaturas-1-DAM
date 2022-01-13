package controlador;

import java.sql.*;

/**
 *
 * @author PAUDA
 */
public class ConectaBBDD {

    public Connection conexion;

    /**
     * Método para conectar con la base de datos de Oracle
     *
     */
    public ConectaBBDD() {
        try {
            //Comprobamos que el driver funciona correctamente y conectamos con la BBDD
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
        //public boolean existenTablasEnBBDD()
        //if (!existenTablasEnBBDD()){public void crearTablasEnBBDD()

    }

}
