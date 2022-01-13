/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.intersys.jdbc.*;
import com.intersys.objects.*;
import java.sql.*;
import java.util.logging.Level;

/**
 * Clase facilitadora para la realización de conexiones a Caché.
 * @author Salvador Romero Villegas
 */
public class ConexionACache {
    
    Connection conn=null; 
     
    /**
     * Función que facilita la conexión a un servidor Caché.
     * @param ipDelServidor Dirección IP del servidor o nombre de la máquina
     * donde está el servidor (FQDN). Para desarrollo normalmente se pone 
     * "localhost", dado que el servidor está instalado en la misma máquina.
     * @param puertoDelServidor Generalmente es el puerto 1972, salvo que se 
     * haya alterado la instalación por defecto.
     * @param namespace Namespace a conectar por defecto. Si no has creado uno
     * puedes usar el namespace USER, creado por defecto.
     * @param usuario Usuario para conectarse. Si no has creado un usuario
     * propio puedes usar el usuario "_SYSTEM" con password "SYS".
     * @param password Password para conectarse, cuyo dato depende de como 
     * tengas configurada la base de datos.
     * @return Retorna una instancia de la clase Connection, con la conexión
     * o null en caso de no haber podido conectarse.
     */
    public Connection construirConexion (String ipDelServidor,
            int puertoDelServidor, String namespace, String usuario,
            String password) {
          
        try {
             CacheDataSource ds = new CacheDataSource();
            String url = "jdbc:Cache://" + ipDelServidor + ":" + puertoDelServidor + "/" + namespace;
            ds.setURL(url);
            ds.setUser(usuario);
            ds.setPassword(password);
            conn = ds.getConnection();            
        } catch (SQLException ex) {            
            java.util.logging.Logger.getLogger(ConexionACache.class.getName()).log(Level.SEVERE, null, ex);
            conn = null;
        }        
        return conn;
    }
    
    /**
     * Crea una conexión a Caché cuando está instalado en el mismo ordenador
     * donde se desarrolla y al puerto por defecto (1972).
     * @param namespace Namespace a conectar por defecto. Si no has creado uno
     * puedes usar el namespace USER, creado por defecto.
     * @param usuario Usuario para conectarse. Si no has creado un usuario
     * propio puedes usar el usuario "_SYSTEM" con password "SYS".
     * @param password Password para conectarse, cuyo dato depende de como 
     * tengas configurada la base de datos.
     * @return Retorna una instancia de la clase Connection, con la conexión
     * o null en caso de no haber podido conectarse. 
     */
    public Connection construirConexion (String namespace,
            String usuario, String password) {
        return construirConexion("127.0.0.1", 1972, namespace, usuario, password);
    }
    
    /**
     * Obtiene la conexión realizada a Caché o null si todavía no se ha conectado.
     * @return Una instancia de la clase Connection, con la conexión a la base 
     * de datos, o null en caso de no haberse conectado.
     */
    public Connection getConn ()
    {
        return conn;
    }
    
    /**
     * Obtiene una conexión, pero encapsulada en la clase Database de Caché,
     * la cual permite usar Java Caché Binding. Solo funcionará si se ha 
     * conectado anteriormente con la base de datos con los métodos construirConexion.
     * @return Una instancia de la clase Database, con la conexión a la base 
     * de datos, o null en caso de no haberse conectado.
     */
    public Database getDatabase ()
    {
        Database DBConn = null;
        if (conn != null) {
            try {
                return CacheDatabase.getDatabase(conn);
            } catch (CacheException ex) {
                java.util.logging.Logger.getLogger(ConexionACache.class.getName()).log(Level.SEVERE, null, ex);
                DBConn = null;
            }
        }
        return DBConn;
    }
    
}
