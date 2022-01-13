package tiposCuentasBancarias;

import java.util.*;

/**
 * Clase abstracta que hereda de CuentaBancaria y que a su vez actúa como 
 * superclase de la que heredan otras clases del mismo tipo
 *
 * @author Daniel Paz Lorenzo
 */
public abstract class CuentaCorriente extends CuentaBancaria {

    //Declaración de Hashtable para guardar los pares empresa a domiciliar y máxima cuantía
    Hashtable<String, Double> hashEmpresasDomiciliaciones = new Hashtable();

    //Método para introducir los valores pasados como parámetros en la hashtable 
    public void setHash(String codEntidad, double maxCantAutorizada) {
        hashEmpresasDomiciliaciones.put(codEntidad, maxCantAutorizada);
    }

    //Método para obtener la colección hashtable creada
    public Hashtable<String, Double> getHash() {
        return this.hashEmpresasDomiciliaciones;
    }
}
