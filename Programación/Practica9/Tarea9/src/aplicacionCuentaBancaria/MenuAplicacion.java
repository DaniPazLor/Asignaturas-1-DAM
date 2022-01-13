package aplicacionCuentaBancaria;

import java.text.*;
import java.util.*;
import tiposCuentasBancarias.*;

/**
 * Clase principal de la plicación que contiene el método main y contiene los
 * menús y métodos necesarios para la gestión de la aplicación
 *
 * @author Daniel Paz Lorenzo
 */
public class MenuAplicacion {

    Map<CuentaBancaria, CuentaBancaria.Persona> listaCuentasBancarias = new HashMap();
    MetodosCuentas metCuentas = new MetodosCuentas();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Bloque declaración de variables globales e instanciación de objetos
        byte op;
        boolean m, e;
        MenuAplicacion menu = new MenuAplicacion();
        CuentaAhorro ca = new CuentaAhorro();
        String numCCC;
        double cantidadIngresar, cantidadRetirar;

        do {
            Scanner teclado = new Scanner(System.in);
            m = true;

            System.out.println("----------MENÚ DE DATOS DE CLIENTE----------");
            System.out.println("1.- Abrir una nueva cuenta");
            System.out.println("2.- Ver un listado de las cuentas disponibles");
            System.out.println("3.- Obtener los datos de una cuenta concreta");
            System.out.println("4.- Realizar un ingreso en una cuenta");
            System.out.println("5.- Retirar efectivo de una cuenta");
            System.out.println("6.- Consultar el saldo actual de una cuenta");
            System.out.println("7.- Salir de la aplicación");
            System.out.println("Introduzca una opción: ");
            do {
                try {
                    e = false;
                    op = teclado.nextByte();

                    switch (op) {
                        case 1:
                            menu.abrirNuevaCuenta();
                            break;
                        case 2:
                            menu.mostrarListadoCuentas();
                            break;
                        case 3:
                            teclado.nextLine();
                            System.out.println("Introduzca el numero de la cuenta: ");
                            numCCC = teclado.nextLine();
                            //Quitamos los espacios en blanco de la cadena si los hubiera
                            numCCC = numCCC.replace(" ", "");
                            if (ca.validarNumeroCCC(numCCC)) {
                                menu.buscarCuenta(numCCC);
                            }
                            break;
                        case 4:
                            teclado.nextLine();
                            System.out.println("Introduzca el numero de la cuenta: ");
                            numCCC = teclado.nextLine();
                            //Quitamos los espacios en blanco de la cadena si los hubiera
                            numCCC = numCCC.replace(" ", "");
                            if (ca.validarNumeroCCC(numCCC)) {
                                System.out.println("Introduzca la cantidad que desea ingresar: ");
                                cantidadIngresar = teclado.nextDouble();
                                menu.realizarIngreso(numCCC, cantidadIngresar);
                            }
                            break;
                        case 5:
                            teclado.nextLine();
                            System.out.println("Introduzca el numero de la cuenta: ");
                            numCCC = teclado.nextLine();
                            //Quitamos los espacios en blanco de la cadena si los hubiera
                            numCCC = numCCC.replace(" ", "");
                            if (ca.validarNumeroCCC(numCCC)) {
                                System.out.println("Introduzca la cantidad que desea retirar: ");
                                cantidadRetirar = teclado.nextDouble();
                                menu.retirarEfectivo(numCCC, cantidadRetirar);
                            }
                            break;
                        case 6:
                            teclado.nextLine();
                            System.out.println("Introduzca el numero de la cuenta: ");
                            numCCC = teclado.nextLine();
                            //Quitamos los espacios en blanco de la cadena si los hubiera
                            numCCC = numCCC.replace(" ", "");
                            if (ca.validarNumeroCCC(numCCC)) {
                                menu.consultaSaldo(numCCC);
                            }
                            break;
                        case 7:
                            System.out.println("Hasta la próxima!!");
                            m = false;
                            break;
                        default:
                            System.out.println("Introduzca una opción válida del 1 al 7: ");

                    }
                } catch (InputMismatchException ex) {//Excepción para controlar que el número introducido sea entero tipo byte
                    System.out.println("Caracter o valor introducido incorrecto");
                    System.out.println("Por favor, introduzca opción valida del 1 al 6: ");
                    teclado.next();
                    e = true;
                }
            } while (e);
        } while (m);
    }

    /**
     * Método para crear una nueva cuenta bancaria
     */
    public void abrirNuevaCuenta() {
        //Declaración de variables y objetos del método
        Scanner teclado = new Scanner(System.in);
        boolean c;
        byte op;
        String nombre, apellidos, fNacimiento, fechaNacimiento = "";

        System.out.println("--Introduzca los Datos personales--");
        System.out.println("Nombre: ");
        nombre = teclado.nextLine();

        System.out.println("Apellidos: ");
        apellidos = teclado.nextLine();

        do {
            System.out.println("Fecha de nacimiento (DD/MM/YYYY): ");
            fNacimiento = teclado.next();
            //Comprobamos que el formato de fecha sea el correcto
            if (comprobacionFormatoFechaNacimiento(fNacimiento)) {
                fechaNacimiento = fNacimiento;
            }
        } while (!comprobacionFormatoFechaNacimiento(fNacimiento));

        //Menú para que el usuario seleccione la cuenta que desea crear
        do {
            try {
                c = false;
                System.out.println("¿Que tipo de cuenta desea abrir?");
                System.out.println("1.- Cuenta de ahorro");
                System.out.println("2.- Cuenta corriente personal");
                System.out.println("3.- Cuenta corriente de empresa");
                System.out.println("Elija una opción: ");
                op = teclado.nextByte();
                switch (op) {
                    //Añade al hashMap listaCuentasBancarias el Map devuelto por el método cuenta correspondiente según la selección
                    case 1:
                        this.listaCuentasBancarias.putAll(metCuentas.crearCuentaAhorro(nombre, apellidos, fechaNacimiento));
                        break;
                    case 2:
                        this.listaCuentasBancarias.putAll(metCuentas.crearCuentaCorrientePersonal(nombre, apellidos, fechaNacimiento));
                        break;
                    case 3:
                        this.listaCuentasBancarias.putAll(metCuentas.crearCuentaCorrienteEmpresa(nombre, apellidos, fechaNacimiento));
                        break;
                    default:
                        System.out.println("Introduzca una opción correcta del 1 al 3");
                        c = true;
                        break;
                }
            } catch (InputMismatchException ex) {//Excepción para controlar que el número introducido sea entero tipo byte
                System.err.println("Caracter o valor introducido incorrecto");
                teclado.next();
                c = true;
            }
        } while (c);
    }

    /**
     * Método que recorre el HashMap listaCuentasBancarias para mostrar todo su
     * contenido
     */
    public void mostrarListadoCuentas() {

        MetodosCuentas.encabezadoTabla();
        for (Map.Entry<CuentaBancaria, CuentaBancaria.Persona> ca : this.listaCuentasBancarias.entrySet()) {
            CuentaBancaria cb = ca.getKey();
            CuentaBancaria.Persona cbp = ca.getValue();
            //Llamada al método creado en la clase interfaz Imprimible e implementado en las clases de cuentas que heredan
            cb.mostrarDatosCuenta(cb, cbp);

        }
        System.out.println("\n\n");
    }

    /**
     * Método para buscar un numero de cuenta pasado como parámetro dentro de la
     * colección listaCuentasBancarias
     *
     * @param numeroCCC String de número de cuenta
     * @return true si la cuenta existe dentro de la colección, false si no
     * existe
     */
    public boolean buscarCuenta(String numeroCCC) {
        //Declaración de variables de método
        boolean encontrado = false;
        //Bucle para recorrer la colección listaCuentasBancarias
        for (Map.Entry<CuentaBancaria, CuentaBancaria.Persona> ca : this.listaCuentasBancarias.entrySet()) {
            //Recogemos el contenido de las claves y los valores
            CuentaBancaria cb = ca.getKey();
            CuentaBancaria.Persona cbp = ca.getValue();
            if (cb.numeroCCC.equals(numeroCCC)) {
                MetodosCuentas.encabezadoTabla();
                //Llamada al método creado en la clase interfaz Imprimible e implementado en las clases de cuentas que heredan
                cb.mostrarDatosCuenta(cb, cbp);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("El número de cuenta no existe en la base de datos");
        }
        System.out.println("\n\n");
        return encontrado;
    }

    /**
     * Método para realizar un ingreso dentro de una cuenta concreta pasada como
     * parámetro por el usuario
     *
     * @param numeroCCC String de número de cuenta
     * @param cantIngreso double con la cantidad que el usuario desea ingresar
     * @return true si la cuenta existe dentro de la colección, false si no
     * existe
     */
    public boolean realizarIngreso(String numeroCCC, Double cantIngreso) {
        //Declaración de variable
        boolean encontrado = false;
        //Bucle para recorrer la colección listaCuentasBancarias
        for (Map.Entry<CuentaBancaria, CuentaBancaria.Persona> ca : this.listaCuentasBancarias.entrySet()) {
            //Recogemos el contenido de las claves y los valores
            CuentaBancaria cb = ca.getKey();
            CuentaBancaria.Persona cbp = ca.getValue();
            //Si la cuenta existe sumamos la cantidad al atributo saldoActual
            if (cb.numeroCCC.equals(numeroCCC)) {
                cb.saldoActual += cantIngreso;
                System.out.println("Ingreso realizado con éxito");
                MetodosCuentas.encabezadoTabla();
                cb.mostrarDatosCuenta(cb, cbp);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("El número de cuenta no existe en la base de datos");
        }
        System.out.println("\n\n");
        return encontrado;
    }

    /**
     * Método para retirar efectivo de una cuenta concreta pasada como parámetro
     *
     * @param numeroCCC String de número de cuenta
     * @param cantRetirar double con la cantidad que el usuario desea retirar
     * @return true si la cuenta existe dentro de la colección, false si no
     * existe
     */
    public boolean retirarEfectivo(String numeroCCC, Double cantRetirar) {
        //Declaración de variable
        boolean encontrado = false;
        //Bucle para recorrer la colección listaCuentasBancarias
        for (Map.Entry<CuentaBancaria, CuentaBancaria.Persona> ca : this.listaCuentasBancarias.entrySet()) {
            //Recogemos el contenido de las claves y los valores
            CuentaBancaria cb = ca.getKey();
            CuentaBancaria.Persona cbp = ca.getValue();
            //Comprobamos que la cuenta existe
            if (cb.numeroCCC.equals(numeroCCC)) {
                System.out.println("El saldo actual de la cuenta es: " + cb.saldoActual + " con límite máximo descubierto de " + cb.getMaxDes());
                //COmprobamos si hay saldo en la cuenta o no
                if (cb.saldoActual < cantRetirar) {
                    //Si no hay saldo suficiente pero se permite descubierto comprobamos si es suficiente(ligadura dinámica)
                    if ((cb.saldoActual + cb.getMaxDes()) > cantRetirar) {
                        //Si hay saldo con el descubierto actualizamos los atributos correspondientes
                        cb.setMaxDes((cb.saldoActual + cb.getMaxDes()) - cantRetirar);
                        cb.saldoActual = 0;
                    } else {
                        System.err.println("No hay dinero suficiente en la cuenta");
                    }
                } else {
                    //Si hubiera saldo se sustrae directamente del mismo
                    cb.saldoActual -= cantRetirar;
                    System.out.println("Retirada realizada con éxito");
                }
                encontrado = true;
                MetodosCuentas.encabezadoTabla();
                cb.mostrarDatosCuenta(cb, cbp);
                System.out.println("descubierto" + cb.getMaxDes());
            }
        }
        if (!encontrado) {
            System.out.println("El número de cuenta no existe en la base de datos");
        }
        System.out.println("\n\n");
        return encontrado;
    }

    /**
     * Método para mostrar el saldo de una cuenta pasada como parámetro
     *
     * @param numeroCCC String de número de cuenta
     * @return true si la cuenta existe dentro de la colección, false si no
     * existe
     */
    public boolean consultaSaldo(String numeroCCC) {
        //Declaración de variable
        boolean encontrado = false;
        //Bucle para recorrer la colección listaCuentasBancarias
        for (Map.Entry<CuentaBancaria, CuentaBancaria.Persona> ca : this.listaCuentasBancarias.entrySet()) {
            //Recogemos el contenido de las claves poque es donde encontramos el atributo saldo
            CuentaBancaria cb = ca.getKey();
            if (cb.numeroCCC.equals(numeroCCC)) {
                System.out.println("El saldo actual de la cuenta es: " + cb.saldoActual);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("El número de cuenta no existe en la base de datos");
        }
        System.out.println("\n\n");
        return encontrado;
    }

    /**
     *
     * @param fechaNacimiento String con la fecha
     * @return true si el formato de fecha es correcto, false en caso contrario
     */
    public boolean comprobacionFormatoFechaNacimiento(String fechaNacimiento) {
        boolean valido;

        try {
            //Comprobamos el formato fecha por medio de un parse
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fechaNacimiento);
            valido = true;
        } catch (ParseException ex) {
            System.err.println("Formato de fecha introducido incorrecto");
            valido = false;
        }
        return valido;
    }
}
