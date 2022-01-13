package ejercicio5;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Jose Ignacio
 */
public class Ejercicio5 {
    
    public static void main(String[] args) {

        boolean departamentoYaCreado;
        boolean mesYaCreado;    
        boolean diaYaCreado;       
        int departamentos_creados=0;        
        String departamento;                     // departamento del fichero leido actual 
        String mes;                              // mes del fichero leído actual        
        String dia;                              // dia del fichero        
        File[] listaFicheros = new File[1000];   // MÁXIMO DE FICHEROS EN EL DIRECTORIO 
        int maximo_departamentos = 100;
        int indiceDepartamento=0;
        int indiceMes = 0;
        Departamento[] listaDepartamentos = new Departamento[maximo_departamentos];   // MÁXIMO DE DEPARTAMENTOS POSIBLES     
        
        // VAMOS A SUPONER QUE SIEMPRE VA A HABER FICHEROS CON EL NOMBRE CORRECTO Y BIEN FORMADO Y NO SALTARÁN EXCEPCIONES
        // AUNQUE SI QUISIERAMOS HACER ESA COMPROBACIÓN LA REALIZARÍAMOS DESPUÉS DE LLAMAR A LISTFILES EN LAS LÍNEAS SIGUIENTES
        
        File directorio2020 = new File("C:\\documentacion2020");   // DIRECTORIO DONDE ESTÁN ALMACENADOS LOS FICHEROS
        
        listaFicheros = directorio2020.listFiles();   // LISTA DE FICHEROS ALMACENADA EN UN ARRAY DE FILE                                      
        
        for(File ficheroActual: listaFicheros){   // PARA CADA FICHERO RECOGIDO
            
            departamento = ficheroActual.getName().substring(0, ficheroActual.getName().indexOf("_"));  // OBTENEMOS EL NOMBRE DEL DEPARTAMENTO
            
            departamentoYaCreado = false;
            
            if(departamentos_creados == 0){   // SI EL ARRAY DE DEPARTAMENTOS ESTÁ VACÍO
           
                   // SI NO HAY DEPARTAMENTOS CREADOS NO HACEMOS NINGUNA COMPROBACIÓN CLARO                
                    creaDepartamento(listaDepartamentos,departamento,departamentos_creados++);
                    indiceDepartamento = departamentos_creados - 1;
                    
            }else{
             
                 // COMPROBAMOS SI EL DEPARTAMENTO ESTÁ YA CREADO                 
                
                for(int i=0;i<departamentos_creados;i++)
                    if(listaDepartamentos[i].getDepartamento().equals(departamento)){
                            departamentoYaCreado = true;
                            indiceDepartamento = i;
                            break;
                    }

                if(!departamentoYaCreado){    // SI NO ESTÁ CREADO ENTONCES CREAMOS EL DIRECTORIO Y AÑADIMOS EL DEPARTAMENTO A LA LISTA DE DEPARTAMENTO CREADOS                               
                    creaDepartamento(listaDepartamentos,departamento,departamentos_creados++);
                    indiceDepartamento = departamentos_creados - 1;
                }
                                         
            } 
            
            // ACCEDEMOS AL MES
            
            mes = ficheroActual.getName().substring(ficheroActual.getName().indexOf("_")+1,ficheroActual.getName().indexOf("-"));                     
            
            mesYaCreado = false;
            
            // BUSCA EL MES EN LA ESTRUCUTRA DE CLASES QUE HEMOS CREADO 
            
            if(!listaDepartamentos[indiceDepartamento].encuentraMes(mes))    // SI NO LO ENCUENTRA LO CREA
                listaDepartamentos[indiceDepartamento].creaMes(mes);            

            indiceMes = listaDepartamentos[indiceDepartamento].obtenerIndiceMesEncontrado();
            
            // ACCEDEMOS AL DÍA
            
            dia = ficheroActual.getName().substring(ficheroActual.getName().indexOf(mes)+mes.length()+1,ficheroActual.getName().indexOf("-2020"));                     
            
            diaYaCreado = false;
            
            // SI NO ENCUENTRA EL DIA YA NO HARÁ FALTA EN ESTA VERSIÓN AÑADIR NINGÚN DIRECTORIO MÁS Y NO LO CREAREMOS
            
            if(!listaDepartamentos[indiceDepartamento].getListaMeses()[indiceMes].encuentraDia(dia))
                listaDepartamentos[indiceDepartamento].getListaMeses()[indiceMes].creaDia(departamento, dia, ficheroActual.getName());
                     
        }        
        
    }
    
    public static void creaDepartamento(Departamento[] lista, String departamento,int ind_departamento){
        
        // ESTE MÉTODO SE ENCARGA DE CREAR UN DIRECTORIO CON EL DEPARTAMENTO NUEVO ENCONTRADO
        
        // NO SE RECOGEN EXCEPCIONES PORQUE SUPONEMOS QUE SIEMPRE VA A HABER FICHEROS CON EL NOMBRE BIEN FORMADO EN EL DIRECTORIO
        
        File directorio = new File("C:\\documentacion2020\\".concat(departamento));
        directorio.mkdir();
        lista[ind_departamento] = new Departamento(departamento);      
        
    }
    
}