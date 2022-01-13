package controlador;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.text.html.HTML.Tag.SELECT;
import vista.Principal;

/**
 *
 * @author PAUDA
 */
public class ConectaBBDD {
    public Connection conexion;
   
    /**
     * Método para conectar con la base de datos de Oracle
     * 
     * @return 
     */
    public ConectaBBDD(){
        try{
        //Comprobamos que el driver funciona correctamente    
        Class.forName("oracle.jdbc.OracleDriver");
        String ServidorBaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
        this.conexion= DriverManager.getConnection(ServidorBaseDeDatos,"TAREA10","5678");
        if(this.conexion!=null)
        {
        System.out.println("Conexion exitosa a esquema TAREA10");
        }
        else{System.out.println("Conexion fallida");}
        }
        catch(Exception e)
        {e.printStackTrace();}
     
    }
    
    
}
