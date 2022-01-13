
package aplicacionCuentaBancaria;

import tiposCuentasBancarias.CuentaBancaria;

/**
 *Clase de tipo interfaz y que implementa un método
 * 
 * @author Daniel Paz Lorenzo
 */
public interface Imprimible {
    /**
     * Método sin implementar para mostrar los datos de la cuenta
     * 
     * @param cb tipo de la clase CuentaBancaria
     * @param p tipo de la clase Persona incluida en la clase CuentaBancaria
     */
    public void mostrarDatosCuenta(CuentaBancaria cb, CuentaBancaria.Persona p);
}
