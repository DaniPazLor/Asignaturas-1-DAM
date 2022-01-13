/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio5;

import java.io.File;
import java.util.Arrays;

/**
 *
 * @author PAUDA
 */
public class DirectoriosDepartamento {
    
    protected final String directorioRaíz= "C:\\documentacion2020";
    protected File directorio= new File(directorioRaíz);
    
    public void comprobarDirectorio(){
    }
    
    public void crearDirectorio(){
        
        if(!directorio.exists()){
            if(directorio.mkdir()){
                System.out.println("Directorio creado");
            }
        }else{
                System.out.println("directorio ya creado");
            }
        
    }
    
    public void listarArchivosDirectorio(){
        System.out.println(Arrays.toString(directorio.listFiles()));
    }
    
    public String getNombreDepartamento(){
        String nombreDepartamento="";
        
        
        
        
        return nombreDepartamento;
    }
}
