package FicherosEmpresa;

import java.io.*;
import java.util.*;

/**
 * Clase que contiene los métodos necesarios para el manejo de nuestro fichero
 * cliente.dat
 *
 * @author Daniel Paz Lorenzo
 */
public class MetodosFicheros {

    //Creamos una constante para el nombre de archivo
    private static final String FICHEROCLIENTE = "clientes.dat";

    /**
     * Método para añadir clientes al fichero
     *
     */
    public static void añadirCliente() {

        //Bloque de declaración de variable y objetos
        boolean c, d;
        float deuda = 0;
        String dni, nombre, direccion, telefono = null;
        ArrayList<DatosCliente> clienteArray = leerFichero();
        Scanner teclado = new Scanner(System.in);

        do {
            c = false;

            System.out.println("Introduzca los datos del cliente");
            do {
                System.out.println("DNI");
                dni = teclado.nextLine();
                dni = dni.toUpperCase();//Pone la letra en mayúsculas
            } while (!comprobarDni(dni));//Comprueba que la letra del dni introducida es correcta

            System.out.println("Nombre");
            nombre = teclado.nextLine();

            do {
                d = false;
                try {
                    System.out.println("Teléfono");
                    telefono = teclado.nextLine();
                    //Comprueba que el numero de teléfono tenga formato de 9 dígitos y sean todos números
                    if (telefono.length() != 9) {
                        System.err.println("El número de teléfono no contiene 9 digitos");
                        d = true;
                    }
                    Integer.parseInt(telefono);
                } catch (NumberFormatException ex) {
                    System.err.println("El teléfono introducido contiene caracteres incorrectos");
                    d = true;
                }
            } while (d);

            System.out.println("Dirección");
            direccion = teclado.nextLine();

            do {
                try {
                    System.out.println("Deuda");
                    deuda = teclado.nextFloat();
                } catch (Exception ex) {
                    System.err.println("Cantidad no válida");
                    teclado.next();
                    d = true;
                }
            } while (d);
        } while (c);
        //Añadimos los datos al Array del tipo objeto DatosCliente
        clienteArray.add(new DatosCliente(dni, nombre, telefono, direccion, deuda));

        //Comprueba si el fichero existe y si no crea uno nuevo
        try {
            if (comprobarFichero() == false) {
                File ficheroClientes = new File(FICHEROCLIENTE);
                ficheroClientes.createNewFile();
            }
            guardarFichero(clienteArray);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }//Fin método añadirCliente()

    /**
     * Método para comprobar que la longitud y la letra del dni introducido son
     * correctas
     *
     * @param dni
     * @return d
     */
    static boolean comprobarDni(String dni) {

        boolean valido;
        int modulo, numeroDni;
        String dniSinLetra = dni.substring(0, dni.length() - 1);
        final String LETRADNI = "TRWAGMYFPDXBNJZSQVHLCKE";

        if (dni.length() != 9) {
            System.out.println("Formato dni incorrecto");
            valido = false;
        } else {
            try {
                numeroDni = Integer.parseInt(dniSinLetra);//Pasa tipo String a entero
                modulo = numeroDni % 23;

                if (dni.charAt(dni.length() - 1) == LETRADNI.charAt(modulo)) {
                    valido = true;//El dni es correcto
                } else {
                    System.out.println("Letra del dni es incorrecta");
                    valido = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Formato dni incorrecto");
                valido = false;
            };
        }
        return valido;
    }//Fin método comprobarDni() 

    /**
     * Comprueba si el fichero existe en la dirección absoluta
     *
     * @return existe
     */
    private static boolean comprobarFichero() {
        boolean existe = true;
        try {
            File ficheroClientes = new File(FICHEROCLIENTE);
            if (!ficheroClientes.exists()) {
                existe = false;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return existe;
    }//Fin método comprobarFichero()

    /**
     * Método que lee el fichero, si existe, y lo copia en un array
     *
     * @return clienteArray
     */
    private static ArrayList<DatosCliente> leerFichero() {
        ArrayList<DatosCliente> clienteArray = new ArrayList<>();
        try {
            //Comprobar si el fichero existe lo lee y guarda en array
            if (comprobarFichero()) {
                FileInputStream ficheroEntrada = new FileInputStream(FICHEROCLIENTE);
                ObjectInputStream objetoEntrada = new ObjectInputStream(ficheroEntrada);
                clienteArray = (ArrayList<DatosCliente>) objetoEntrada.readObject();
                ficheroEntrada.close();
                objetoEntrada.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return clienteArray;
    }//Fin método leerFichero()

    /**
     * Método para guardar array del tipo objeto <DatosCliente> en el fichero
     * cliente.dat
     *
     * @param clienteArray
     */
    private static void guardarFichero(ArrayList<DatosCliente> clienteArray) {

        try {
            FileOutputStream ficheroSalida = new FileOutputStream(FICHEROCLIENTE);
            ObjectOutputStream objetoSalida = new ObjectOutputStream(ficheroSalida);
            objetoSalida.writeObject(clienteArray);
            ficheroSalida.close();
            objetoSalida.close();
            System.out.println("Cliente guardado en fichero");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }//Fin método guardarFichero()

    /**
     * Muestra el listado completo de clientes dentro del fichero
     */
    public static void listarClientes() {
        if (comprobarFichero()) {
            //Pasa los datos del fichero a un array
            ArrayList<DatosCliente> clienteArray = leerFichero();
            //Imprime por pantalla los datos del array
            if (clienteArray.isEmpty()) {
                System.err.println("El fichero de clientes está vacío");
            } else {
                for (DatosCliente datos : clienteArray) {
                    System.out.println(datos.imprimir());
                }
            }
        } else {
            System.err.println("Aún no existe fichero de clientes");
        }
    }//Fin método listarClientes()

    /**
     * Método para realizar una busqueda de cliente por dni y mostrar su
     * contenido
     */
    public static void buscarCliente() {
        if (comprobarFichero()) {
            boolean c = false;
            String dni;
            Scanner teclado = new Scanner(System.in);
            do {
                System.out.println("Introduzca dni del cliente que desea ver ");
                dni = teclado.nextLine();
                dni = dni.toUpperCase();
            } while (!comprobarDni(dni));

            //Introducimos en un array los datos leidos del fichero
            ArrayList<DatosCliente> clienteArray = leerFichero();

            for (DatosCliente datos : clienteArray) {
                if (dni.equals(datos.getDni())) {
                    System.out.println(datos.imprimir());//Mustra por pantalla los datos del cliente con ese dni
                    c = true;
                    break;
                }
            }
            if (!c) {
                System.out.println("No hay clientes con ese dni");

            }
        } else {
            System.err.println("Aún no existe fichero de clientes");
        }
    }//Fin método buscarClientes()

    /**
     * Método para buscar un cliente por dni y borrarlo del fichero
     */
    public static void borrarCliente() {
        if (comprobarFichero()) {
            boolean c = false;
            String dni;
            Scanner teclado = new Scanner(System.in);

            do {
                System.out.println("Introduzca dni del cliente que desea borrar ");
                dni = teclado.nextLine();
                dni = dni.toUpperCase();
            } while (!comprobarDni(dni));

            //Introducimos en un array los datos leidos del fichero
            ArrayList<DatosCliente> clienteArray = leerFichero();

            for (DatosCliente datos : clienteArray) {
                if (dni.equals(datos.getDni())) {
                    clienteArray.remove(datos);//Borramos los datos del array
                    guardarFichero(clienteArray);//Guardamos el nuevo array en el fichero
                    System.out.println("Cliente con dni: " + datos.getDni() + " fue borrado del fichero");
                    c = true;
                    break;
                }
            }
            if (!c) {
                System.out.println("No hay clientes con ese dni");
            }
        } else {
            System.err.println("Aún no existe fichero de clientes");
        }
    }

    /**
     * Método para borrar el fichero completo
     */
    public static void borrarFichero() {
        try {
            if (comprobarFichero()) {//Comprueba si exite el fichero y lo borra
                File ficheroClientes = new File(FICHEROCLIENTE);
                ficheroClientes.delete();
                System.out.println("El fichero de clientes fue borrado satisfactoriamente");
            } else {
                System.err.println("Aún no existe ningún fichero de clientes");
            }
        } catch (Exception e) {
            System.out.println("e.getMessage()");
        }
    }//Fin método borrarFichero

}//Fin clase MetodosFicheros
