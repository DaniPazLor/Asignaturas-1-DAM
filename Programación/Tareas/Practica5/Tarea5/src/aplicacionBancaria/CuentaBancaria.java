package aplicacionBancaria;

/**
 * Clase que define el constructor y los métodos principales de la aplicación de
 * cuenta bancaria
 *
 * @author Daniel Paz Lorenzo
 * @version 1.0
 */
public class CuentaBancaria {

    //Declaración de los atributos de clase
    protected String nombreTitular, numeroCCC;
    private String entidad, oficina, numCuenta, digitosControl;
    private int saldo = 0;

    /**
     * Constructor de la clase CuentaBancaria
     *
     * @param nombreTitular
     * @param numeroCCC
     */
    protected CuentaBancaria(String nombreTitular, String numeroCCC) {
        this.nombreTitular = nombreTitular;
        this.numeroCCC = numeroCCC;
    }//Fin del constructor CuentaBancaria

    /**
     * Método sin parámetros que calcula y devuelve el número de la entidad
     * extrayendolo del numeroCCC
     *
     * @return entidad
     */
    public String informacionEntidad() {
        entidad = this.numeroCCC.substring(0, 4);
        return entidad;
    }//Fin del método informacionEntidad

    /**
     * Método sin parámetros que calcula y devuelve el número de la oficina
     * extrayendolo del numeroCCC
     *
     * @return oficina
     */
    public String informacionOficina() {
        oficina = this.numeroCCC.substring(4, 8);
        return oficina;
    }//Fin del método informacionOficina

    /**
     * Método sin parámetros que calcula y devuelve el número de la cuenta
     * extrayendolo del numeroCCC
     *
     * @return numCuenta
     */
    public String informacionNumCuenta() {
        numCuenta = this.numeroCCC.substring(10);
        return numCuenta;
    }//Fin del método informacionNumCuenta

    /**
     * Método sin parámetros que calcula y devuelve el número de los digitos de
     * control extrayendolos del numeroCCC
     *
     * @return digitosControl
     */
    public String informacionDigitosControl() {
        digitosControl = this.numeroCCC.substring(8, 10);
        return digitosControl;
    }//Fin del método

    /**
     * Método sin parámetros que nos devulve el valor del saldo en ese momento
     *
     * @return saldo
     */
    public int consultaSaldo() {
        return saldo;
    }//Fin del método consultaSaldo

    /**
     * Método que suma el ingreso al saldo que ya había anteriormente No retorna
     * ningún valor
     *
     * @param ingreso
     */
    public void realizarIngreso(int ingreso) {
        if (ingreso < 1) {//Controla que la cantidad a ingresar no sea negativa
            System.out.println("Cantidad a ingresar negativa\n\n");
        } else {
            this.saldo += ingreso;
            System.out.println("Ingreso realizado con éxito!!\n\n");
        }
    }//Fin del método realizarIngreso

    /**
     * Método para realizar una retirada de dinero restando al saldo que ya
     * había anteriormente, comprobando antes que hay dinero en la cuenta No
     * retorna ningún valor
     *
     * @param retirada
     */
    public void realizarRetirada(int retirada) {
        if (retirada < 1) {//Controla que la cantidad a retirar no sea negativa
            System.out.println("Cantidad a retirar negativa\n\n");
        } else {
            if (this.saldo > retirada) {//Comprueba que la retirada no sea mayor que el saldo
                this.saldo -= retirada;
                System.out.println("Retirada realizada con éxito!!\n\n");
            } else {
                System.out.println("No hay suficiente saldo \n\n");
            }
        }
    }//Fin del método realizarRetirada

    /**
     * Método que comprueba si el nombre del titular completo no contiene más de
     * 40 caracteres
     *
     * @param nombreTitular
     * @return valido
     */
    protected static boolean validarTitular(String nombreTitular) {
        boolean valido;//Declaración de atributo de método
        if (nombreTitular.length() > 40) {
            System.out.println("Nombre del titular demasiado largo (máx. 40 caracteres)\n\n");
            valido = true;
            return valido;
        }
        valido = false;
        return valido;
    }//Fin del método validarTitular

    /**
     * Método para validar si el formato del número de cuenta consta de 20
     * digitos
     *
     * @param numeroCCC
     * @return valido
     */
    protected static boolean validarFormatoCCC(String numeroCCC) {

        boolean valido;//Declaración de atributo de método

        if (numeroCCC.length() != 20) {//Comparamos la longitud del String con 20
            if (numeroCCC.length() < 20) {
                System.out.println("CCC incorrecto (faltan números)\n\n");
                valido = true;
                return valido;
            } else if (numeroCCC.length() > 20) {
                System.out.println("CCC incorrecto (ha introducido más de 20 números)\n\n");
                valido = true;
                return valido;
            }
        }//Comprobación de si el número es >< que 20

        valido = false;//Si no es >< que 20 entonces = a 20
        return valido;
    }//Fin del método validarFormatoCCC

    /**
     * Método que valida si el número introducido es un número de cuenta
     * corriente válido
     *
     * @param numeroCCC
     * @return valido
     */
    protected static boolean validarNumeroCCC(String numeroCCC) {

        //Declaración de atributos del método
        boolean valido = true;
        byte digitoControl1, digitoControl2;

        //Comrobación del primer digito de control
        String numeroCCC1 = "00" + numeroCCC.substring(0, 8);//numeroCCC1adena de los 8 primeros digitos 
        //de la cuenta bancaria al que añadimos dos ceros al inicio para que la longitud sea 10
        digitoControl1 = CuentaBancaria.bucleValidacionCCC(numeroCCC1);//Llamada a método bucleValidacionCCC

        //Comparamos el valor generado con el real para saber si es valido para digito de control 1
        if (Character.getNumericValue(numeroCCC.charAt(8)) != digitoControl1) {
            System.out.println("PRIMER DIGITO DE CONTROL INCORRECTO\n\n");
            return valido;
        }//Si la primera validación es incorrecta retorna true y 
        //ya no comprueba el segundo digito de control     

        //Comprueba el segundo digito de control
        String numeroCCC2 = numeroCCC.substring(10);//numeroCCC2 contendrá
        //solo los 10 últimos números de la la cadena numeroCCC
        digitoControl2 = CuentaBancaria.bucleValidacionCCC(numeroCCC2);//Llamada a método bucleValidacionCCC

        //Comparamos el valor generado con el real para saber si es valido para digito de control 2
        if (Character.getNumericValue(numeroCCC.charAt(9)) == digitoControl2) {
            System.out.println("NUMERO DE CUENTA CORRECTO\n\n");
            valido = false;
            return valido;
        } else {
            System.out.println("SEGUNDO DIGITO DE CONTROL INCORRECTO\n\n");
            return valido;
        }

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

}//Fin de la clase CuentaBancaria
