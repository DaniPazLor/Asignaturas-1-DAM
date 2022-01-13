package entradaDatosAplicacion;

import java.util.*;

/**
 * Clase que contendrá todos los datos referidos al cliente
 *
 * @author Daniel Paz Lorenzo
 */
public class datosCliente {

    //Creamos los atributos de clase y los hacemos public para poder usarlos
    //en el paquete de salidaDatosAplicacion
    protected String datosCliente;
    public String dni, nombre, apellidos;
    public ArrayList<String> emails = new ArrayList();
    public ArrayList<String> telefonos = new ArrayList();
    public ArrayList<Long> numLocales = new ArrayList();
    public ArrayList<Long> numInternacionales = new ArrayList();

    /**
     * Constructor de la clase cliente con el que vamos a generar sus atributos
     *
     * @param datosCliente String que contiene todos los datos recogidos del
     * fichero
     */
    public datosCliente(String datosCliente) {
        String[] elementosArchivo = datosCliente.split(",");/*Creamos array de elementos por la separación de la coma*/
        int i;

        //Recorremos el array de elementos para separar en atributos de clase
        for (i = 0; i < elementosArchivo.length; i++) {
            /*El primer elemento de array será el dni*/
            if (i == 0) {
                this.dni = elementosArchivo[i].trim();
            }
            /*El segundo elemento de array será el nombre*/
            if (i == 1) {
                StringBuilder elemento = new StringBuilder(elementosArchivo[i].trim());
                this.nombre = elemento.deleteCharAt(0).deleteCharAt(elemento.lastIndexOf("\"")).toString();
            }
            /*El tercer elemento del array serán los apellidos*/
            if (i == 2) {
                StringBuilder elemento = new StringBuilder(elementosArchivo[i].trim());
                this.apellidos = elemento.deleteCharAt(0).deleteCharAt(elemento.lastIndexOf("\"")).toString();
            }
            /*A partir de esta posición tenemos que comprobar si son teléfonos o emails*/
            if (i > 2) {

                //Buscamos si el elemento contiene @ para saber si es email
                if (elementosArchivo[i].contains("@")) {
                    this.emails.add(elementosArchivo[i].toLowerCase().trim());
                } else {
                    StringBuilder elemento = new StringBuilder(elementosArchivo[i].trim());
                    //Elimina los paréntesis del número de teléfono si los hubiera 
                    if (elementosArchivo[i].contains("(") || elementosArchivo[i].contains(")")) {
                        elemento.deleteCharAt(elemento.indexOf("("));
                        elemento.deleteCharAt(elemento.indexOf(")"));
                    }
                    this.telefonos.add(elemento.toString().trim());
                }
            }
        }
        eliminarDuplicados(this.emails);
        eliminarDuplicados(this.telefonos);
        clasificarTelefonos(this.telefonos);
    }

    /**
     * Método void para eliminar los duplicados de cualquier lista pasada como
     * parémtro
     *
     * @param lista ArrayList de elementos cualquiera
     */
    public void eliminarDuplicados(ArrayList<String> lista) {
        //Nos valemos de la propiedad de las listas HashSet 
        //que dice que no puede tener contenido repetido en su interior
        HashSet<String> hashSet = new HashSet(lista);
        //Borramos la lista
        lista.clear();
        //Y la añadimos la nueva lista ya sin duplicados
        lista.addAll(hashSet);
    }

    /**
     * Método void para clasificar la lista de télefonos en locales e
     * internacionales
     *
     * @param listaTelefonos pasamos el array completo recogido en
     * listaTelefonos
     */
    public void clasificarTelefonos(ArrayList<String> listaTelefonos) {

        for (String telefono : listaTelefonos) {
            StringBuilder elemento = new StringBuilder(telefono.trim());
            if (telefono.contains("+")) {
                elemento.deleteCharAt(elemento.indexOf("+"));
                this.numInternacionales.add(Long.parseLong(elemento.toString()));
            } else {
                this.numLocales.add(Long.parseLong(elemento.toString()));
            }

        }
        //Una vez clasificados los ordenamos de mayor a menor
        Collections.sort(this.numLocales, Collections.reverseOrder());
        Collections.sort(this.numInternacionales, Collections.reverseOrder());
    }

    /**
     * Método para mostrar por pantalla el atributo de clase dni
     */
    public void getDni() {
        System.out.println("El número del DNI es " + this.dni);
        if (comprobarDatosEntrada.comprobarDniNie(dni)) {
            System.out.println("El DNI/NIE introducido es correcto");
        } else {
            System.err.println("El formato o la letra del DNI/NIE son incorrectos");
        }
    }

    /**
     * Método para mostrar por pantalla el atributo de clase nombre
     */
    public void getNombre() {
        System.out.println("El nombre es " + this.nombre);
    }

    /**
     * Método para mostrar por pantalla el atributo de clase apellidos
     */
    public void getApellidos() {
        System.out.println("Los apellidos son " + this.apellidos);
    }

    /**
     * Método para mostrar por pantalla el atributo de clase emails
     */
    public void getEmails() {
        System.out.println("LISTA DE EMAILS");
        for (String email : this.emails) {
            System.out.println(email);
        }
    }

    /**
     * Método para mostrar por pantalla los atributos de clase telefonos
     */
    public void getTelefonos() {
        System.out.println("LISTA DE TELÉFONOS");
        System.out.println("locales:");
        for (Long telefono : this.numLocales) {
            System.out.println(telefono);
        }
        System.out.println("Internacionales");
        for (Long telefono : this.numInternacionales) {
            System.out.println("+ " + telefono);
        }
    }

    /**
     * Método sobreescrito toString() para recoger los atributos de clase
     * nombre+apellidos
     *
     * @return la concatenación de atributos de clase nombre + apellidos
     */
    @Override
    public String toString() {
        return this.nombre + "  " + this.apellidos;
    }
}//Fin clase datosCliente
