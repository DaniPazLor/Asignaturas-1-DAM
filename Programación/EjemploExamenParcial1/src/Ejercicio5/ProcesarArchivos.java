/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PAUDA
 */
public class ProcesarArchivos {

    public final String directorioRaiz = "C:\\documentacion2020";

    public ProcesarArchivos() {

    }

    public void procesar() throws IOException{
        
        
        ArrayList<Archivo> listaArchivos=listarArchivos();

        ArrayList <InformeMovimiento> listaInformesMovimientos=organizarArchivo(listaArchivos);
        
        crearInforme(listaInformesMovimientos);
        
    } 
    public ArrayList<Archivo> listarArchivos() {

        ArrayList<Archivo> listaArchivos = new ArrayList<Archivo>();
        File directorio = new File(directorioRaiz);
        String[] listaFicheros = directorio.list();

        for (String fichero : listaFicheros) {
            Archivo arc = new Archivo(fichero);
            System.out.println(arc.nombreArchivo);
            listaArchivos.add(arc);
        }

        return listaArchivos;
    }

    public ArrayList <InformeMovimiento> organizarArchivo(ArrayList<Archivo> listaArchivos) {

        ArrayList <InformeMovimiento> listaInforme=new ArrayList <InformeMovimiento> ();
        
        for (Archivo arc : listaArchivos) {
            comprobarDirectorioDepartamento(arc); 
            File ficheroOrigen=new File(directorioRaiz+"\\"+arc.nombreArchivo);

            File ficheroDestino=new File(directorioRaiz +"\\"+ arc.nombreDepartamento +"\\"+ arc.mes+"\\"+ arc.dia+"\\"+arc.nombreArchivo);
            if(ficheroOrigen.renameTo(ficheroDestino)){
                InformeMovimiento informe=new InformeMovimiento(ficheroOrigen.getName(),ficheroDestino.getName(),new Date());
                listaInforme.add(informe);
            }
        }
        
        return listaInforme;
    }

    public void comprobarDirectorioDepartamento(Archivo arc) {

        File directorio = new File(directorioRaiz +"\\"+ arc.nombreDepartamento);

        if (!directorio.exists()) {
            directorio.mkdir();
        }
        comprobarDirectorioMes(arc);

    }

    public void comprobarDirectorioMes(Archivo arc) {

        File directorio = new File(directorioRaiz +"\\"+ arc.nombreDepartamento + "\\" + arc.mes);

        if (!directorio.exists()) {
            directorio.mkdir();
        }
        comprobarDirectorioDia(arc);
    }

    public void comprobarDirectorioDia(Archivo arc) {

        File directorio = new File(directorioRaiz +"\\"+ arc.nombreDepartamento +"\\" + arc.mes+"\\"+ arc.dia);

        if (!directorio.exists()) {
            directorio.mkdir();
        }

    }
    
    public void crearInforme(ArrayList <InformeMovimiento> informes) throws IOException{
        
        
        File fichero=crearFichero("informeMovimientos.txt");
            FileOutputStream ficheroSalida = new FileOutputStream(fichero);
            ObjectOutputStream objetoSalida = new ObjectOutputStream(ficheroSalida);
            objetoSalida.writeObject(informes);
            ficheroSalida.close();
            objetoSalida.close();
        
        
    }
    
    public void mostrarInforme(){
        
                    File fichero=new File("C:\\documentacion2020\\informeMovimientos.txt");
                    ArrayList <InformeMovimiento> listaInformeMovimiento=new ArrayList <InformeMovimiento>();
        try {
            //Comprobar si el fichero existe lo lee y guarda en array

                FileInputStream ficheroEntrada = new FileInputStream(fichero);
                ObjectInputStream objetoEntrada = new ObjectInputStream(ficheroEntrada);
                listaInformeMovimiento = (ArrayList <InformeMovimiento>) objetoEntrada.readObject();
                ficheroEntrada.close();
                objetoEntrada.close();

        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        
        for(InformeMovimiento informeMovimiento:listaInformeMovimiento){
            System.out.println(informeMovimiento.origen+"--->"+informeMovimiento.destino+"--->"+informeMovimiento.fechayHora);
        }
    }
    
  public File crearFichero(String nombreFichero) throws IOException{       
        
        File fichero=new File("C:\\documentacion2020\\",  nombreFichero );
        fichero.createNewFile();
        
        return fichero;
    }

    
    public void generacionArchivosAleatorios() throws IOException{

        int c=0;
         
        
            do{  
                Archivo arc=new Archivo();
          crearFichero(arc.nombreArchivo);
          c++;
            }while(c<100);
    }
    
    
    
}