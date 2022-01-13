/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio5;

/**
 *
 * @author PAUDA
 */
public class Archivo {
    
    //nombreDepartamento_mes-dia-2020.doc
    public String nombreArchivo;
    public String nombreDepartamento;
    public String mes;
    public String dia;
    public final int anno = 2020;
    
    protected int [] dias = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
    protected  String [] departamentos= {"RecursosHumanos","Fabricación","Mantenimiento","Matricería","Calidad","OficinaTécnica"};
    protected final String [] meses= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};

    
    public Archivo(){
          nombreDepartamento=departamentos[(int) (Math.random() * 6)];
          dia=Integer.toString(dias[(int) (Math.random() * 31)]);  
          mes=meses[(int) (Math.random() * 12)];
          nombreArchivo=imprimir(); 

    }
    
    public Archivo(String nombreArchivo){
        
        this.nombreArchivo=nombreArchivo;
        String[] tokenNombreArchivo=this.nombreArchivo.split("_");
        // tokenNombreArchivo[0]; = nombreDepartamento
        // tokenNombreArchivo[1]; = mes-dia-2020.doc
        this.nombreDepartamento = tokenNombreArchivo[0];
        
        // segundaParteCadena[1]; = mes-dia-2020.doc
        String segundaParteCadena = tokenNombreArchivo[1];       
        String[] tokenFechaArchivo=segundaParteCadena.split("-");
        // tokenFechaArchivo[0]; = mes
        // tokenFechaArchivo[1]; = dia        
        // tokenFechaArchivo[2]; = 2020.doc       
        this.mes = tokenFechaArchivo[0];
        this.dia = tokenFechaArchivo[1]; 
        
    }
    
        public String imprimir(){
        return nombreDepartamento+"_"+mes+"-"+dia+"-"+anno+".doc";
    }
    
}
