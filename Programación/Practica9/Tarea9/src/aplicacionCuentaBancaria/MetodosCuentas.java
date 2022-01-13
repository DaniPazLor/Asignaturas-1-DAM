package aplicacionCuentaBancaria;

import java.util.*;
import tiposCuentasBancarias.*;

/**
 * Clase para la creación de los tipos de cuentas posibles 
 * con los métodos correspondientes
 *
 * @author Daniel Paz Lorenzo
 */
public class MetodosCuentas {

    //Declaración de objetos, variables y arrays como atributos de la clase
    Map<CuentaBancaria, CuentaBancaria.Persona> nuevaCuenta = new HashMap();

    /**
     * Método para crear cuentas del tipo Ahorro
     *
     * @param nombre String que contiene el nombre que nos da el usuario
     * @param apellidos String que contiene los apellidos que nos da el usuario
     * @param fechaNacimiento String que contiene la fecha de nacimiento que nos
     * da el usuario
     * @return hashMap del tipo clase CuentaBancaria y Persona
     */
    public Map<CuentaBancaria, CuentaBancaria.Persona> crearCuentaAhorro(String nombre, String apellidos, String fechaNacimiento) {
        //Declaración de variables e instanciación de objetos
        boolean c = true;
        CuentaAhorro cAhorro = new CuentaAhorro();
        CuentaAhorro.Persona datper = cAhorro.new Persona();
        String numCCC;

        datper.nombre = nombre;
        datper.apellidos = apellidos;
        datper.fechaNacimiento = fechaNacimiento;

        //Solicitamos al usuario los datos necesarios para generar la cuenta
        do {
            Scanner teclado = new Scanner(System.in);
            try {
                do {
                    System.out.println("Número de cuenta: ");
                    numCCC = teclado.nextLine();
                    //Quitamos los espacios en blanco de la cadena si los hubiera
                    numCCC = numCCC.replace(" ", "");
                    if (cAhorro.validarNumeroCCC(numCCC)) {
                        cAhorro.numeroCCC = numCCC;
                    }
                } while (cAhorro.validarNumeroCCC(numCCC) == false);

                do {
                    System.out.println("Saldo inicial: ");
                    cAhorro.saldoActual = teclado.nextDouble();
                } while (cAhorro.saldoActual < 0);

                do {
                    System.out.println("Tipo de interés de remuneración: ");
                    cAhorro.tipoInteres = teclado.nextDouble();
                } while (cAhorro.tipoInteres < 0);

                c = false;
            } catch (Exception e) {
                System.err.println("Algún dato no es correcto, por favor vuelva a introducirlos");
            }
        } while (c);
        //Añadimos los datos al hashMap nuevaCuenta para luego retornarlo
        nuevaCuenta.put(cAhorro, datper);

        return nuevaCuenta;
    }

    /**
     * Método para crear cuentas del tipo cuenta corriente personal
     *
     * @param nombre String que contiene el nombre que nos da el usuario
     * @param apellidos String que contiene los apellidos que nos da el usuario
     * @param fechaNacimiento String que contiene la fecha de nacimiento que nos
     * da el usuario
     * @return hashMap del tipo clase CuentaBancaria y Persona
     */
    public Map<CuentaBancaria, CuentaBancaria.Persona> crearCuentaCorrientePersonal(String nombre, String apellidos, String fechaNacimiento) {
        //Declaración de variables e instanciación de objetos
        boolean c = true;
        CuentaCorrientePersonal cCorrientePersonal = new CuentaCorrientePersonal();
        CuentaCorrientePersonal.Persona datper = cCorrientePersonal.new Persona();
        String numCCC;

        datper.nombre = nombre;
        datper.apellidos = apellidos;
        datper.fechaNacimiento = fechaNacimiento;

        do {
            Scanner teclado = new Scanner(System.in);
            try {
                do {
                    System.out.println("Número de cuenta: ");
                    numCCC = teclado.nextLine();
                    //Quitamos los espacios en blanco de la cadena si los hubiera
                    numCCC = numCCC.replace(" ", "");
                    if (cCorrientePersonal.validarNumeroCCC(numCCC)) {
                        cCorrientePersonal.numeroCCC = numCCC;
                    }
                } while (cCorrientePersonal.validarNumeroCCC(numCCC) == false);

                do {
                    System.out.println("Saldo inicial: ");
                    cCorrientePersonal.saldoActual = teclado.nextDouble();
                } while (cCorrientePersonal.saldoActual < 0);

                do {
                    System.out.println("Tipo de interés de mantenimiento: ");
                    cCorrientePersonal.comisionMantenimiento = teclado.nextDouble();
                } while (cCorrientePersonal.comisionMantenimiento < 0);

                c = false;
            } catch (Exception e) {
                System.err.println("Algún dato no es correcto, por favor vuelva a introducirlos");
            }
        } while (c);
        //Añadimos los datos al hashMap nuevaCuenta para luego retornarlo
        nuevaCuenta.put(cCorrientePersonal, datper);

        return nuevaCuenta;
    }

    /**
     * Método para crear cuentas del tipo cuenta corriente de empresa
     *
     * @param nombre String que contiene el nombre que nos da el usuario
     * @param apellidos String que contiene los apellidos que nos da el usuario
     * @param fechaNacimiento String que contiene la fecha de nacimiento que nos
     * da el usuario
     * @return hashMap del tipo clase CuentaBancaria y Persona
     */
    public Map<CuentaBancaria, CuentaBancaria.Persona> crearCuentaCorrienteEmpresa(String nombre, String apellidos, String fechaNacimiento) {
        //Declaración de variables e instanciación de objetos
        boolean c = true;
        CuentaCorrienteEmpresa cCorrienteEmpresa = new CuentaCorrienteEmpresa();
        CuentaCorrienteEmpresa.Persona datper = cCorrienteEmpresa.new Persona();
        String numCCC;

        datper.nombre = nombre;
        datper.apellidos = apellidos;
        datper.fechaNacimiento = fechaNacimiento;

        do {
            Scanner teclado = new Scanner(System.in);
            try {
                do {
                    System.out.println("Número de cuenta: ");
                    numCCC = teclado.nextLine();
                    //Quitamos los espacios en blanco de la cadena si los hubiera
                    numCCC = numCCC.replace(" ", "");
                    if (cCorrienteEmpresa.validarNumeroCCC(numCCC)) {
                        cCorrienteEmpresa.numeroCCC = numCCC;
                    }
                } while (cCorrienteEmpresa.validarNumeroCCC(numCCC) == false);

                do {
                    System.out.println("Saldo inicial: ");
                    cCorrienteEmpresa.saldoActual = teclado.nextDouble();
                } while (cCorrienteEmpresa.saldoActual < 0);

                do {
                    System.out.println("Máximo descubierto permitido: ");
                    cCorrienteEmpresa.maxDescubiertoPermitido = teclado.nextDouble();
                } while (cCorrienteEmpresa.maxDescubiertoPermitido < 0);

                do {
                    System.out.println("Tipo de interés por descubierto: ");
                    cCorrienteEmpresa.interesDescubierto = teclado.nextDouble();
                } while (cCorrienteEmpresa.interesDescubierto < 0);

                do {
                    System.out.println("Comisión fija por descubierto: ");
                    cCorrienteEmpresa.interesDescubierto = teclado.nextDouble();
                } while (cCorrienteEmpresa.interesDescubierto < 0);

                c = false;
            } catch (Exception e) {
                System.err.println("Algún dato no es correcto, por favor vuelva a introducirlos");
            }
        } while (c);
        //Añadimos los datos al hashMap nuevaCuenta para luego retornarlo
        nuevaCuenta.put(cCorrienteEmpresa, datper);

        return nuevaCuenta;
    }

    /**
     * Método para mostrar formato de salida como encabezado
     */
    public static void encabezadoTabla() {
        System.out.println("Numero de cuenta    || Titular         || Saldo Actual");
        System.out.println("____________________||_________________||______________");
    }

}
