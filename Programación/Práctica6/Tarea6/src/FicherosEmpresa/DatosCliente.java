package FicherosEmpresa;

import java.io.*;


/**
 * Clase que guarda y permite mostrar los atributos referidos al cliente
 * Implementada como serializable para poder pasar el flujo de datos
 * a un fichero y luego recuperarlo
 * @author Daniel Paz Lorenzo
 */
public class DatosCliente implements Serializable {

    //Bloque de declaración de atributos de clase
    private float deuda;
    private String dni, nombre, direccion, telefono;
    private static final long serialVersionUID =-5588012102836621537L;

    DatosCliente(String dni, String nombre, String telefono, String direccion, Float deuda) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.deuda = deuda;
    }//Fin del método constructor de la clase

    public float getDeuda() {
        return deuda;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }
    
    public void setDeuda(float deuda) {
        this.deuda = deuda;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setDni(String nif) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
        
    /**
     * Método para obtener todos los datos del cliente por pantalla
    */
    public String imprimir() {
        return "Nombre: " + getNombre() + ", DNI: " + getDni() + ", Dirección: " + getDireccion() + ", Teléfono: " + getTelefono() + ", Deuda: " + getDeuda();
    }
}//Fin clase DatosCliente
