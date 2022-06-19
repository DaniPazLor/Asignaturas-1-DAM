package entradaDatosAplicacion;

import java.util.regex.*;

/**
 * Clase para implementar métodos de comprobación para los datos de entrada de
 * la aplicación
 *
 * @author Daniel Paz Lorenzo
 */
public class comprobarDatosEntrada {

    /**
     * Método para comprobar, mediante comparación de patrón , que un dato tipo
     * String se corresponde a dni/nie
     *
     *
     * @param dni cadena de carácteres recogida como dni
     * @return dniValido true si el dni/nie es correcto, en caso contrario false
     */
    public static boolean comprobarDniNie(String dni) {

        boolean dniValido, patronValido;
        int modulo, numeroDni;
        String dniSinLetra;
        final String LETRADNI = "TRWAGMYFPDXBNJZSQVHLCKE";

        Pattern patron = Pattern.compile("([XY]?)([0-9]{8})([a-zA-Z])");
        Matcher compruebaPatron = patron.matcher(dni);
        patronValido = compruebaPatron.matches();

        if (patronValido) {
            if (dni.length() == 10) {
                dniSinLetra = dni.substring(1, dni.length() - 1);
            } else {
                dniSinLetra = dni.substring(0, dni.length() - 1);
            }
            numeroDni = Integer.parseInt(dniSinLetra);//Pasa tipo String a entero
            modulo = numeroDni % 23;

            if (dni.charAt(dni.length() - 1) == LETRADNI.charAt(modulo)) {
                dniValido = true;//El dni es correcto
            } else {
                dniValido = false;//La letra del DNI/NIE no es válida
            }
        } else {
            dniValido = false;//El formato del DNI/NIE no es válido
        }
        return dniValido;
    }

}
