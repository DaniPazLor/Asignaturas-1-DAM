/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio5;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author PAUDA
 */
public class InformeMovimiento implements Serializable{
    
    public String origen;
    public String destino;
    public Date fechayHora;
    
    public InformeMovimiento(String origen, String destino, Date fechayHora){
        
        this.origen=origen;
        this.destino=destino;
        this.fechayHora=fechayHora;
        
    }
    
    
}
