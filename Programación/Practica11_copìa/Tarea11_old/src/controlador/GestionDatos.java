package controlador;

import java.sql.*;
import java.util.logging.*;
import modelo.*;

/**
 *
 * @author PAUDA
 */
public class GestionDatos {

    public ConectaBBDD conexionBBDD;
    public DatabaseMetaData dbm;

    public GestionDatos() {
        this.conexionBBDD = new ConectaBBDD();
        boolean clientes = false;
        boolean escrituras = false;

        try {
            // Comprobamos que existen las tablas en la base de datos y si no las creamos
            dbm = conexionBBDD.conexion.getMetaData();
            ResultSet tables = dbm.getTables(null, null, "CLIENTES", null);
            // Si la tabla existe
            if (tables.next()) {
                System.out.println("La tabla 'CLIENTES' ya existe en la base de datos");
                insertarDatosDePruebas();
            // Si la tabla no existe 
            } else {
                clientes = true;
                System.out.println("Se creará una nueva tabla 'CLIENTES' en la BBDD");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ResultSet tables = dbm.getTables(null, null, "ESCRITURAS", null);
            // Si la tabla existe
            if (tables.next()) {
                System.out.println("La tabla 'ESCRITURAS' ya existe en la base de datos");
                // Si la tabla no existe la creamos
            } else {
                escrituras = true;
                System.out.println("Se creará una nueva tabla 'ESCRITURAS' en la BBDD");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Si no existe alguna de las 2 llamamos al método crearTablas indicandole cual queremos crear
        if (clientes || escrituras) {
            if(crearTablasBBDD(clientes, escrituras)){
                System.out.println("Las tablas se crearon con éxito");
                insertarDatosDePruebas();
            }else{
                System.out.println("Fallo en la creación de las tablas");
            }
        }

    }

    public boolean crearTablasBBDD(boolean clientes, boolean escrituras) {
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
                //Creamos la tabla''CLIENTES'
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

    public void insertarDatosDePruebas(){
        
        try {
            String sentenciaSQL= "INSERT INTO CLIENTES(NOMBRE, TELEFONO) VALUES (?,?)";
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
            
            sentenciaSQL= "INSERT INTO ESCRITURAS(COD_ESCRITURA, CODCLI, TIPO, NOM_FICH, NUM_INTERV) VALUES (?, ?, ?, ?, ?)";
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

   public boolean insertarDatosClienteBBDD (TablaClientes cliente){
       boolean exito = false;
        try {
            String sentenciaSQL= "INSERT INTO CLIENTES(NOMBRE, TELEFONO) VALUES (?,?)";
            
            PreparedStatement consultaPreparada = conexionBBDD.conexion.prepareStatement(sentenciaSQL);
            consultaPreparada.setString(1, cliente.nombre);
            consultaPreparada.setString(2, cliente.telefono);
            consultaPreparada.executeQuery();
            consultaPreparada.close();
            
            exito=true;            
        } catch (SQLException ex) {
            Logger.getLogger(GestionDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exito;
   }
   
      public boolean insertarDatosEscrituraBBDD(TablaEscrituras escritura){
          boolean exito = false;
          System.out.println(escritura.codEscritura+" "+escritura.codCliente+" "+escritura.tipo+" "+escritura.nom_Fichero+" "+escritura.num_Intervinientes);

        try {
            String sentenciaSQL= "INSERT INTO ESCRITURAS(COD_ESCRITURA, CODCLI, TIPO, NOM_FICH, NUM_INTERV) VALUES (?, ?, ?, ?, ?)";
            
            PreparedStatement consultaPreparada = conexionBBDD.conexion.prepareStatement(sentenciaSQL);
            consultaPreparada.setString(1, escritura.codEscritura);
            consultaPreparada.setInt(2, escritura.codCliente);
            consultaPreparada.setString(3, escritura.tipo);
            consultaPreparada.setString(4, escritura.nom_Fichero);
            consultaPreparada.setInt(5, escritura.num_Intervinientes);
            consultaPreparada.executeQuery();
            consultaPreparada.close();
            
            exito=true;
        } catch (SQLException ex) {
            Logger.getLogger(GestionDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exito;
   }

      public boolean actualizarDatosCliente(TablaClientes cliente){
          boolean exito=false;
            try {
            String sentenciaSQL= "UPDATE clientes SET nombre=?, telefono=? WHERE cod_cliente=?";
            
            PreparedStatement consultaPreparada = conexionBBDD.conexion.prepareStatement(sentenciaSQL);
            consultaPreparada.setString(1, cliente.nombre);
            consultaPreparada.setString(2, cliente.telefono);
            consultaPreparada.setString(3, cliente.cod_Cliente);
            consultaPreparada.executeUpdate();
            consultaPreparada.close();
            
            exito=true;            
        } catch (SQLException ex) {
            Logger.getLogger(GestionDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
          return exito;
      }
      
   public ResultSet obtenerTablaResultados(String sentenciaSQL) {
        ResultSet tablaResultados = null;
        try {
            PreparedStatement consultaPreparada = conexionBBDD.conexion.prepareStatement(sentenciaSQL);

            tablaResultados = consultaPreparada.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(ConectaBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tablaResultados;
    }
      
}
