package controlador;

import java.sql.*;
import java.util.logging.*;
import modelo.*;

/**
 * Clase para contiene los métodos necesarios para la gestion de los datos
 * mediando entre la interfaz de usuario y la base de datos
 *
 * @author Daniel Paz Lorenzo
 */
public class GestionDatos {

    //Declaración de atributos de clase
    public ConectaBBDD conexionBBDD;
    public DatabaseMetaData dbm;
    public CrearTablasDatos creaDatosPrueba;

    /**
     * Constructor de la clase donde llamamos a la clase de la conexión con la
     * base de datos y comprobamos si existen o no las tablas y sino llamamos a
     * los metodos para crearlas
     */
    public GestionDatos() {
        //Declaración de atributos del constructor
        this.conexionBBDD = new ConectaBBDD();
        this.creaDatosPrueba = new CrearTablasDatos();
        boolean clientes = false;
        boolean escrituras = false;

        try {
            //Utilizamos la clase DatabaseMetaData para la comprobación de las tablas en la BBDD
            dbm = conexionBBDD.conexion.getMetaData();
            // Comprobamos que existe la tabla Clientes y si no las creamos
            ResultSet tables = dbm.getTables(null, null, "CLIENTES", null);

            if (tables.next()) {
                System.out.println("La tabla 'CLIENTES' ya existe en la base de datos");
            } else {
                clientes = true;
                System.out.println("Se creará una nueva tabla 'CLIENTES' en la BBDD");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Comprobamos que existe la tabla Clientes y si no las creamos
        try {
            ResultSet tables = dbm.getTables(null, null, "ESCRITURAS", null);

            if (tables.next()) {
                System.out.println("La tabla 'ESCRITURAS' ya existe en la base de datos");
            } else {
                escrituras = true;
                System.out.println("Se creará una nueva tabla 'ESCRITURAS' en la BBDD");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Si no existe alguna de las 2 llamamos al método crearTablas indicandole cual cuales necesitamos crear
        if (clientes || escrituras) {
            if (this.creaDatosPrueba.crearTablasBBDD(this.conexionBBDD,clientes, escrituras)) {
                System.out.println("Las tablas se crearon con éxito");
                this.creaDatosPrueba.insertarDatosDePruebas(this.conexionBBDD);
            } else {
                System.out.println("Fallo en la creación de las tablas");
            }
        }

    }

    /**
     * Método para insertar los datos del usuario en la tabla clientes de la
     * BBDD
     *
     * @param cliente clase TablaClientes
     * @return exito=true si se han insertado los datos correctamente, false si
     * nos da error
     */
    public boolean insertarDatosClienteBBDD(TablaClientes cliente) {
        boolean exito = false;
        try {
            String sentenciaSQL = "INSERT INTO CLIENTES(NOMBRE, TELEFONO) VALUES (?,?)";

            //Introducimos la sentencia SQL en la consulta preparada, pasamos los parámetros y la ejecutamos
            PreparedStatement consultaPreparada = conexionBBDD.conexion.prepareStatement(sentenciaSQL);
            consultaPreparada.setString(1, cliente.nombre);
            consultaPreparada.setString(2, cliente.telefono);
            consultaPreparada.executeQuery();
            consultaPreparada.close();

            exito = true;
        } catch (SQLException ex) {
            Logger.getLogger(GestionDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exito;
    }

    /**
     * Método para insertar los datos del usuario en la tabla escrituras de la
     * BBDD
     *
     * @param escritura clase TablaEscrituras
     * @return exito=true si se han insertado los datos correctamente, false si
     * nos da error
     */
    public boolean insertarDatosEscrituraBBDD(TablaEscrituras escritura) {
        boolean exito = false;

        try {
            String sentenciaSQL = "INSERT INTO ESCRITURAS(COD_ESCRITURA, CODCLI, TIPO, NOM_FICH, NUM_INTERV) VALUES (?, ?, ?, ?, ?)";

            //Introducimos la sentencia SQL en la consulta preparada, pasamos los parámetros y la ejecutamos
            PreparedStatement consultaPreparada = conexionBBDD.conexion.prepareStatement(sentenciaSQL);
            consultaPreparada.setString(1, escritura.codEscritura);
            consultaPreparada.setInt(2, escritura.codCliente);
            consultaPreparada.setString(3, escritura.tipo);
            consultaPreparada.setString(4, escritura.nom_Fichero);
            consultaPreparada.setInt(5, escritura.num_Intervinientes);
            consultaPreparada.executeQuery();
            consultaPreparada.close();

            exito = true;
        } catch (SQLException ex) {
            Logger.getLogger(GestionDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exito;
    }

    /**
     * Método para actualizar la tabla clientes mediante los datos suministrados
     * por el usuario
     *
     * @param cliente clase TablaClientes
     * @return exito=true si se han insertado los datos correctamente, false si
     * nos da error
     */
    public boolean actualizarDatosCliente(TablaClientes cliente) {
        boolean exito = false;

        try {
            String sentenciaSQL = "UPDATE clientes SET nombre=?, telefono=? WHERE cod_cliente=?";

            //Introducimos la sentencia SQL en la consulta preparada, pasamos los parámetros y la ejecutamos mediante update
            PreparedStatement consultaPreparada = conexionBBDD.conexion.prepareStatement(sentenciaSQL);
            consultaPreparada.setString(1, cliente.nombre);
            consultaPreparada.setString(2, cliente.telefono);
            consultaPreparada.setString(3, cliente.cod_Cliente);
            consultaPreparada.executeUpdate();
            consultaPreparada.close();

            exito = true;
        } catch (SQLException ex) {
            Logger.getLogger(GestionDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exito;
    }

    /**
     * Método que recoge una secuencia cualquiera SQL como parámetro y nos
     * devuelve una tabla de resultados
     *
     * @param sentenciaSQL de la clase String
     * @return ResultSet contiene una tabla virtual de resultados
     */
    public ResultSet obtenerTablaResultados(String sentenciaSQL) {
        ResultSet tablaResultados = null;
        try {
            PreparedStatement consultaPreparada = conexionBBDD.conexion.prepareStatement(sentenciaSQL);
            //Recogemos el resultados de la consulta en un ResultSet
            tablaResultados = consultaPreparada.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(ConectaBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tablaResultados;
    }

}
