package tiposCuentasBancarias;

/**
 * Clase del tipo ahorro que hereda de la superclase abstracta de CuentaBancaria
 * junto con sus atributos y métodos
 *
 * @author Daniel Paz Lorenzo
 */
public class CuentaAhorro extends CuentaBancaria {

    public double tipoInteres;

    //Dejamos el método sin implementar porque no lo usaremos
    public void setMaxDes(double maxDesPer) {
    }

    //Método abstracto heredado y sobreescrito de CuentaBancaria  
    @Override
    public double getMaxDes() {
        return 0;
    }

    //Método abstracto heredado y sobreescrito de la interfaz Imprimible
    @Override
    public void mostrarDatosCuenta(CuentaBancaria cb, CuentaBancaria.Persona p) {

        System.out.println(super.numeroCCC + "   " + p.nombre + " " + p.apellidos + "    " + super.saldoActual);
    }
}
