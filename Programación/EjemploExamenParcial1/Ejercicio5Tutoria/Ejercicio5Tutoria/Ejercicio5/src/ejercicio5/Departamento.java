package ejercicio5;

import java.io.File;

/**
 *
 * @author Jose Ignacio
 */

public class Departamento {
    
    private String departamento;
    private int meses_creados;
    private Mes[] listaMesesEnDepartamento;
    private int indice_mes_encontrado = 0;
    
    Departamento (String nombre){
        
        this.departamento = nombre;
        this.listaMesesEnDepartamento = new Mes[12];        
        
    }
    
    public String getDepartamento(){
        
        return this.departamento;
        
    }
    
    public Mes[] getListaMeses(){
        
        return this.listaMesesEnDepartamento;
        
    }
    
    public int getMesesCreados(){
        
        return this.meses_creados;
        
    }
    
    public boolean encuentraMes(String mes){
        
        for(int i=0;i<meses_creados;i++)
            if(listaMesesEnDepartamento[i].getNombre().equals(mes)){
                indice_mes_encontrado = i;
                return true;                    
            }
       
        return false;
        
    }
    
    public void creaMes(String mes){
        
        listaMesesEnDepartamento[meses_creados] = new Mes(mes);
        listaMesesEnDepartamento[meses_creados++].setNombre(mes);
        
        File directorio = new File("C:\\documentacion2020\\".concat(departamento).concat("\\").concat(mes));
        directorio.mkdir();
        indice_mes_encontrado = meses_creados-1;
        
    }
    
    public int obtenerIndiceMesEncontrado(){
        
        return this.indice_mes_encontrado;
        
    }
    
}
