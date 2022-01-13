package ejercicio3examen;

/**
 *
 * @author Jose Ignacio
 */
public class Factorial {     // USAMOS UNA CLASE CON PROPÓSITOS LECTIVOS AUNQUE SE PODRÍA USAR UN MÉTODO EN LA CLASE PRINCIPAL
                             // PODRÍAMOS CALCULAR EN ESTA CLASE TAMBIÉN EL VALOR DE LA FÓRMULA EN VEZ DE EN LA CLASE PRINCIPAL
                             // SE DEJA COMO EJERCICIO AL ALUMNO
    
        public static short factorial(short numero){    // CABECERA DEL MÉTODO - ESTÁTICO
        
        short resultado = 1;  // INICIALIZACIÓN DE LA VARIABLE
        
        while(numero!=1)               // BUCLE QUE COMPRUEBA QUE NO SE HA LLEGADO A UNO
            resultado *= numero--;     // MULTIPLICAMOS POR NÚMERO Y DECREMENTAMOS EN LA MISMA LÍNEA
        
        return resultado;              // DEVOLVEMOS EL VALOR
    }
    
}