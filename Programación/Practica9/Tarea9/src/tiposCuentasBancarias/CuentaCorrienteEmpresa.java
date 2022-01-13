package tiposCuentasBancarias;

/**
 * Clase que hereda de CuentaCorriente junto con sus métodos y atributos e
 * implementa los suyos propios
 *
 * @author Daniel Paz Lorenzo
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente {

    //Atributos propios de la clase
    public double maxDescubiertoPermitido, comisionFijaDescubierto, interesDescubierto;

    //Implementación del método abstracto recibido como herencia para asignar el atributo máximo descubierto
    public void setMaxDes(double maxDesPer) {
        this.maxDescubiertoPermitido = maxDesPer;
    }

    //Implementación del método abstracto recibido como herencia para conseguir el atributo máximo descubierto   
    public double getMaxDes() {
        return this.maxDescubiertoPermitido;
    }

    //Método sobreescrito de la interfaz Imprimible para mostrar los datos de la cuenta
    @Override
    public void mostrarDatosCuenta(CuentaBancaria cb, CuentaBancaria.Persona p) {
        System.out.println(super.numeroCCC + "   " + p.nombre + " " + p.apellidos + "    " + super.saldoActual);
    }
}
