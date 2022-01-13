package Ejemplo_UsoINSERT;

import User.Conductor;
import com.intersys.objects.CacheDatabase;
import com.intersys.objects.CacheException;
import com.intersys.objects.Id;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import util.*;

/**
 * Ejemplo de inserción en la base de datos usando la sentencia INSERT.
 * @author Salvador Romero
 */
public class Ejemplo_UsoInsert {
    

public static void main (String[] args)
{
     ConexionACache cac=new ConexionACache();
     ConexionAOracle cao=new ConexionAOracle();
     Connection conn;
     String Opcion=UtilConsola.leerOpciones("¿Usar Cache (c), Oracle (o) o Salir (s)?:", "o=o,c=c,s=s", true ,true);
     System.out.println(Opcion);
     if (!Opcion.equals("s"))
     {                   
          String Usuario = UtilConsola.leerCadena("Usuario : ", true);
          String Password = UtilConsola.leerCadena("Contraseña : ", true);
          if (Opcion.equals("c"))
          {
            String DB=UtilConsola.leerCadena("Namespace: ", true);
            conn=cac.construirConexion(DB, Usuario, Password);                        
          }
          else 
          {
            String DB=UtilConsola.leerCadena("SID: ", true);
            conn=cao.construirConexion(DB, Usuario, Password);
          }
          if (conn!=null)
          {
              if (Opcion.equals("c")) IntroducirConductorCache(conn);
              else IntroducirConductorOracle(conn);
          }
          else
          {
              System.out.println("Operacion Fallida.");
          }
     }
     else
     {
         System.out.println ("Adios!");
     }
}
    /**
    * Inserta un conductor o una conductora en la base de datos caché.
    * @param conn Instancia de la clase Connection conectado a caché.
    */
    private static void IntroducirConductorCache(Connection conn) {        
        try {                
            String SQLq="INSERT INTO Conductor (Nombre, Apellidos,";
            SQLq=SQLq+" FechaNacimiento, PuntosCarnet, direccion_nombrevia,";
            SQLq=SQLq+" direccion_numero, direccion_codigopostal,DDI)";
            SQLq=SQLq+" VALUES (?,?,?,?,?,?,?,?)";

            /* Preparamos la consulta*/
            PreparedStatement ps=conn.prepareStatement(SQLq,Statement.RETURN_GENERATED_KEYS);
            
            /* Insertamos los parametros de la consulta: */
            ps.setString(8, UtilConsola.leerCadena("Introduce identificación (DNI, NIE, etc.) (obligatorio):", true));
            ps.setString(1, UtilConsola.leerCadena("Introduce el nombre (obligatorio):", true));
            ps.setString(2, UtilConsola.leerCadena("Introduce los apellidos (obligatorio):", true));            
            ps.setDate(3, new java.sql.Date(UtilConsola.leerFecha("Introduce la fecha de nacimiento (DD/MM/AAAA) (obligatorio):", true).getTime()));
            Integer puntos=null;
            do
            {
            puntos=UtilConsola.leerEntero("Introduce los puntos del carnet (opcional) (entre 0 y 15):", false);
            } while (puntos!=null && (puntos<0 || puntos>15));
            if (puntos!=null) ps.setInt(4, puntos); 
            else ps.setNull(4, java.sql.Types.INTEGER);
            
            String via=UtilConsola.leerCadena("Direccion --> Introduce el nombre de la vía (opcional):",false);
            if (via!=null) ps.setString(5,via);
            else ps.setNull(5, java.sql.Types.VARCHAR);
            
            Integer numero=UtilConsola.leerEntero("Direccion --> Introduce el número (opcional):", false);
            if (numero!=null) ps.setInt(6, numero);
            else ps.setNull(6, java.sql.Types.INTEGER);
            
            String cp=UtilConsola.leerCadena("Direccion --> Introduce el código postal (opcional):", false);
            if (cp!=null) ps.setString(7,cp);
            else ps.setNull(7,java.sql.Types.VARCHAR);
         
            /* Ejecutamos la consulta: */
            ps.executeUpdate();
            
            /* Obtenemos el ID generado para el objeto */
            ResultSet rs=ps.getGeneratedKeys();
            rs.next();
            String newID=rs.getString(1);
            
            /* Abrimos la instancia de conductor creado a través de la proyección (Caché Java Binding),
             para poner los datos de las colecciones.*/
            Conductor c=(Conductor)Conductor._open(CacheDatabase.getDatabase(conn), new Id(newID));
            /* --> Añadimos un telefono "obligatorio" */
            c.getTelefonos().put("Fijo",UtilConsola.leerCadena("Telefonos --> Introduce un telefono fijo (obligatorio):", true));
            /* --> Añadimos un mail "obligatorio" */
            c.getMails().add(UtilConsola.leerCadena("Mails --> Introduce una dirección de mail (obligatorio):", true));            
            /*Guardamos el objeto.*/
            c._save();            
            
            /* Mostramos por pantalla el ID generado para el objeto */
            System.out.println("OID del objeto recien guardado en Caché:"+newID);
        } catch (CacheException ex) {
            Logger.getLogger(Ejemplo_UsoInsert.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Ejemplo_UsoInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 
     * Inserta un conductor o una conductora en la base de datos Oracle.
     * @param conn Instancia de la clase Connection conectado a caché.
     */
   private static void IntroducirConductorOracle(Connection conn) {
          try {                                  
            String SQLq = "INSERT INTO CONDUCTORES VALUES (TIPO_CONDUCTOR(?,?,?,?,?,?,?,";
            SQLq=SQLq+"TIPO_DIRECCION(NULL,?,?, NULL,?, NULL, NULL, NULL, NULL)))";
             /* Preparamos la consulta*/
            PreparedStatement ps=conn.prepareStatement(SQLq,Statement.RETURN_GENERATED_KEYS);
            
            int pos=0;
            /* Insertamos los datos en la consulta: */
            pos++; System.out.print("("+pos+") ");
            ps.setString(pos, UtilConsola.leerCadena("Introduce identificación (DNI, NIE, etc.) (obligatorio):", true));
            
            pos++; System.out.print("("+pos+") ");
            ps.setString(pos, UtilConsola.leerCadena("Introduce el nombre (obligatorio):", true));
            
            pos++; System.out.print("("+pos+") ");
            ps.setString(pos, UtilConsola.leerCadena("Introduce los apellidos (obligatorio):", true));            
            
            pos++; System.out.print("("+pos+") ");
            ps.setDate(pos, new java.sql.Date(UtilConsola.leerFecha("Introduce la fecha de nacimiento (DD/MM/AAAA) (obligatorio):", true).getTime()));
            
            /* Procesamos los correos electrónicos: */                        
            pos++; System.out.print("("+pos+") ");
            ArrayDescriptor array_mails=ArrayDescriptor.createDescriptor("ARRAY_MAILS",conn);
            String[] s_mails=new String[1];
            s_mails[0]=UtilConsola.leerCadena("Mails --> Introduce una dirección de mail (obligatorio):",true);
            ARRAY mails=new ARRAY(array_mails,conn,s_mails);
            ps.setArray(pos, mails);
            
            /* Procesamos los teléfonos: */           
            pos++; System.out.print("("+pos+") ");
            
            StructDescriptor tipo_telefono = StructDescriptor.createDescriptor ("TIPO_TELEFONO", conn);
            ArrayDescriptor tabla_telefonos = ArrayDescriptor.createDescriptor("TABLA_TELEFONOS", conn);                        
            String[] s_telefono_fijo={"Fijo",UtilConsola.leerCadena("Telefonos --> Introduce un telefono fijo (obligatorio):", true)};
            STRUCT telefono_fijo=new STRUCT(tipo_telefono,conn,s_telefono_fijo);
            STRUCT[] a_telefonos=new STRUCT[1];
            a_telefonos[0]=telefono_fijo;
            ARRAY telefonos = new ARRAY(tabla_telefonos,conn,a_telefonos);
            ps.setArray(pos, telefonos);
            
            
            pos++; System.out.print("("+pos+") ");
            Integer puntos=null;
            do
            {
            puntos=UtilConsola.leerEntero("Introduce los puntos del carnet (opcional) (entre 0 y 15):", false);
            } while (puntos!=null && (puntos<0 || puntos>15));            
            if (puntos!=null) ps.setInt(pos, puntos); 
            else ps.setNull(pos, java.sql.Types.INTEGER);
            
            pos++; System.out.print("("+pos+") ");
            String via=UtilConsola.leerCadena("Direccion --> Introduce el nombre de la vía (opcional):",false);
            if (via!=null) ps.setString(pos,via);
            else ps.setNull(pos, java.sql.Types.VARCHAR);
            
            pos++; System.out.print("("+pos+") ");
            Integer numero=UtilConsola.leerEntero("Direccion --> Introduce el número (opcional):", false);
            if (numero!=null) ps.setInt(pos, numero);
            else ps.setNull(pos, java.sql.Types.INTEGER);
            
            pos++; System.out.print("("+pos+") ");
            String cp=UtilConsola.leerCadena("Direccion --> Introduce el código postal (opcional):", false);
            if (cp!=null) ps.setString(pos,cp);
            else ps.setNull(pos,java.sql.Types.VARCHAR);
            
            
             /* Ejecutamos la consulta: */
            ps.executeUpdate();
            
            /* Obtenemos el ID generado para el objeto */
            ResultSet rs=ps.getGeneratedKeys();
            rs.next();
            String newID=rs.getString(1);            
            
            /* Mostramos por pantalla el ID generado para el objeto */
            System.out.println("OID del elemento recien guardado en Oracle: "+newID);
           
        } catch (Exception ex) {
            Logger.getLogger(Ejemplo_UsoInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
   
}
