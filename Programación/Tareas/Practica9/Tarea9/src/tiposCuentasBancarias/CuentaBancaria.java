package tiposCuentasBancarias;

import aplicacionCuentaBancaria.*;

/**
 * Superclase del tipo abstracto y que implementa la clase Imprimible junto con
 * sus métodos
 *
 * @author Daniel Paz Lorenzo
 */
public abstract class CuentaBancaria implements Imprimible {

    //Declaración de atributos de clase
    public double saldoActual;
    public String numeroCCC;
    public Persona per;

    //Clase Persona declarada como interna anidada a CuentaBancaria
    public class Persona {

        //Declaración de atributos de clase
        public String nombre, apellidos, fechaNacimiento;

        //Declaración del constructor de la clase Persona
        public Persona() {
            this.nombre = "";
            this.apellidos = "";
            this.fechaNacimiento = "";
        }
    }

    /**
     * Creación de método abstracto para obtener el máximo descubierto
     *
     * @return double con valor de máximo descubierto
     */
    public abstract double getMaxDes();

    /**
     * Creación de método abstracto para escribir el atributo máximo descubierto
     *
     * @param maxDesPer
     */
    public abstract void setMaxDes(double maxDesPer);

    /**
     * Método que valida si el número introducido es un número de cuenta
     * corriente válido
     *
     * @param numeroCCC
     * @return valido
     */
    public boolean validarNumeroCCC(String numeroCCC) {

        //Declaración de atributos del método
        boolean valido = true;
        byte digitoControl1, digitoControl2;

        //Comprobación de si el número es >< que 20
        if (numeroCCC.length() != 20) {//Comparamos la longitud del String con 20
            if (numeroCCC.length() < 20) {
                System.err.println("CCC incorrecto (faltan números)");
                valido = false;

            } else if (numeroCCC.length() > 20) {
                System.err.println("CCC incorrecto (ha introducido más de 20 números)");
                valido = false;
            }
        } else {//Si no es >< que 20 entonces = a 20

            //Comrobación del primer digito de control
            String numeroCCC1 = "00" + numeroCCC.substring(0, 8);//numeroCCC1adena de los 8 primeros digitos 
            //de la cuenta bancaria al que añadimos dos ceros al inicio para que la longitud sea 10
            digitoControl1 = CuentaBancaria.bucleValidacionCCC(numeroCCC1);//Llamada a método bucleValidacionCCC

            //Comparamos el valor generado con el real para saber si es valido para digito de control 1
            if (Character.getNumericValue(numeroCCC.charAt(8)) != digitoControl1) {
                System.err.println("Primer digito de control incorrecto");
                valido = false;
            }//Si la primera validación es incorrecta retorna true y 
            //ya no comprueba el segundo digito de control     

            //Comprueba el segundo digito de control
            String numeroCCC2 = numeroCCC.substring(10);//numeroCCC2 contendrá
            //solo los 10 últimos números de la la cadena numeroCCC
            digitoControl2 = CuentaBancaria.bucleValidacionCCC(numeroCCC2);//Llamada a método bucleValidacionCCC

            //Comparamos el valor generado con el real para saber si es valido para digito de control 2
            if (Character.getNumericValue(numeroCCC.charAt(9)) == digitoControl2) {
                valido = true;

            } else {
                System.err.println("Segundo digito de control incorrecto");
                valido = false;
            }
        }

        return valido;
    }//Fin del método validarNumeroCCC

    /**
     * Método para realizar las operaciones de validación con el array de PESOS
     * utilizado por el método validarNumeroCCC
     *
     * @param numeroCCC
     * @return digitoControl
     */
    private static byte bucleValidacionCCC(String numeroCCC) {

        //Declaración de atributos
        byte i, digitoControl;
        int productoPesos, sumaPesos = 0;
        final int[] PESOS = {1, 2, 4, 8, 5, 10, 9, 7, 3, 6};//Array declarado como constante

        //Recorre el array de PESOS multiplicando cada valor con su hmólogo 
        //en la cadena numeroCCC y sumando el resultado dentro de la variable sumaPesos
        for (i = 0; i < PESOS.length; i++) {
            productoPesos = Character.getNumericValue(numeroCCC.charAt(i)) * PESOS[i];
            sumaPesos += productoPesos;
        }
        digitoControl = (byte) (11 - (sumaPesos % 11));

        //Contemplamos la posibilidad de que el digitoControl sea 10 u 11
        if (digitoControl == 10) {
            digitoControl = 1;
        } else if (digitoControl == 11) {
            digitoControl = 0;
        }
        return digitoControl;
    }//Fin del método bucleValidacionCCC

}
