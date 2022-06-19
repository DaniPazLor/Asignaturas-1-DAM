package respuestas.tarea2programacion;


/**
 * @Nombre de clase: PROG02_Ejer10
 * @Descripción: Programa que realice varias operaciones entre distintos tipos de datos y los muestre por pantalla
 * @author Daniel Paz Lorenzo
 */
public class PROG02_Ejer10 {
    public static void main (String args[]){
        float x = 4.5f;
        float y = 3.0f;
        int i = 2;
        int j = (int)(i*x);
        double dx = 2.0;
        double dz = dx*y;
        byte bx = 5;
        byte by = 2;
        byte bz = (byte) (bx-by);
        short sx = 5;
        short sy = 2;
        short sz = (short)(sx-sy);
        char cx = '\u000F';
        char cy = '\u0001';
        int z = cx-cy;
        
        System.out.println("------- Conversiones entre enteros y coma flotante -------"); 
        System.out.println("Producto de int por float: j= i*x = " + j);
        System.out.println("Producto de float por double: dz=dx * y = " + dz);
        
        System.out.println("------- Operaciones con byte -------");
        System.out.printf("byte: %d - %d = %d\n", bx, by, bz);        
        bx = -128;
        by = 1;
        bz = (byte)(bx-by);
        System.out.printf("byte %d - %d = %d\n", bx, by, bz);        
        System.out.println("(int) ("+bx+" - "+by+") = "+ (bx-by));
        
        System.out.println("------- Operaciones con short -------");
        System.out.println("short"+sx+" - "+sy+" = "+sz);
        sx = 32767;
        sy = 1;
        sz = (short)(32767 + 1);
        System.out.println("short"+sx+" - "+sy+" = "+sz);
        
        System.out.println("------- Operaciones con char -------");
        System.out.println("char cx - cy = "+z);
        z = cx -1;
        System.out.printf("char: (0x000F) - 1 = %d\n", z);
        cx = '\uFFFF';
        z = cx;
        System.out.println("(int) (z) = "+z);
        sx = (short)cx;
        System.out.println("(short) (z) = "+sx);
        sx = -32768;
        cx = (char)sx;
        z = (int)cx;
        System.out.printf("%d short-char-int = %d\n", sx, z);
        sx = -1;
        cx = (char)sx;
        z = (int)cx;
        System.out.printf("%d short-char-int = %d", sx, z);
    }//Estructura principal del programa
}//Fin de la clase PROG02_Ejer10
