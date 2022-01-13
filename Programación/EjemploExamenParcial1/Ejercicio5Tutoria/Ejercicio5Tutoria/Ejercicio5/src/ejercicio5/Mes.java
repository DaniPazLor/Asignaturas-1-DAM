package ejercicio5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose Ignacio
 */

public class Mes {
    
    private String mes;
    private int dias_creados;
    int indice_dia_encontrado=0;
    private Dia[] listaDiasEnMes;   // ARRAY DE CLASES DIA QUE REPRESENTAN LOS DIAS PARA LOS QUE HAY DOCUMENTOS DENTRO DEL MES
    
    Mes (String nombre){
        
        this.mes = nombre;
        this.listaDiasEnMes = new Dia[31];
        
    }
    
    public String getNombre(){
        
        return this.mes;
        
    }
    
    public void setNombre(String nombre){
        
        this.mes = nombre;
        
    }
    
    public boolean encuentraDia(String dia){   // ENCUENTRA EL DÍA SI EXISTE
        
        for(int i=0;i<dias_creados;i++)
            if(listaDiasEnMes[i].getDia().equals(dia))
                return true;                    
       
        return false;
        
    }
    
    public void creaDia(String departamento, String dia, String nombreFichero){
        
        // ESTE MÉTODO CREA EL DIRECTORIO DEL NUEVO DIA ENCONTRADO EN EL NOMBRE DE UN ARCHIVO DEL DIRECTORIO ORIGEN
        
        listaDiasEnMes[dias_creados] = new Dia(dia);
        listaDiasEnMes[dias_creados++].setDia(dia);        
        File directorio = new File("C:\\documentacion2020\\".concat(departamento).concat("\\").concat(mes).concat("\\").concat(dia));                
        directorio.mkdir();
        indice_dia_encontrado = dias_creados-1;
        leerEnOrigenYEscribirEnDestino("C:\\documentacion2020\\".concat(nombreFichero), directorio.toString().concat("\\").concat(nombreFichero));
        
    }
    
    public void leerEnOrigenYEscribirEnDestino(String origen, String destino){
        
        // ESTE MÉTODO EMITE POR LA CONSOLA LOS FICHEROS DE ORIGEN Y DESTINO Y COPIA DICHO FICHERO DE
        // ORIGEN A DESTINO HACIENDO USO DE FILEINPUTSTREAM Y FILEOUTPUTSTREAM
        // SI HAY ALGÚN ERROR EMITE UNA EXCEPCIÓN
        
        System.out.println(origen);
        System.out.println(destino);
        
        try {
            
            FileInputStream fis = new FileInputStream(origen);
            FileOutputStream fos = new FileOutputStream(destino);
            
            int i = fis.read();
            while(i !=-1){                
                fos.write(i);
                i = fis.read();                
            }
            
            fis.close();
            fos.close();
            
        } catch(IOException e){
            System.out.println("HA HABIDO ALGÚN PROBLEMA CON LA TRANSMISIÓN DEL FICHERO "+ origen);
        }
        
    }
    
}