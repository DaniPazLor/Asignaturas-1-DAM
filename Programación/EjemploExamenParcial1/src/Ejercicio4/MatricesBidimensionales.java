/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

import java.util.Scanner;

/**
 *
 * @author PAUDA
 */
public class MatricesBidimensionales {
    
    MatricesBidimensionales() {

    }

    public static int[][] introducirDatosMatriz() {

        Scanner teclado = new Scanner(System.in);
        int[][] mat = new int[2][2];

        try {
            
            System.out.println("Introduzca número Posición 1x1 ");
            mat[0][0] = teclado.nextInt();

            System.out.println("Introduzca número Posición 1x2 ");
            mat[0][1] = teclado.nextInt();

            System.out.println("Introduzca número Posición 2x1 ");
            mat[1][0] = teclado.nextInt();

            System.out.println("Introduzca número Posición 2x2 ");
            mat[1][1] = teclado.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return mat;
    }//Fin método introducirDatosMatriz

    public static void mostrarMatriz(int[][] mat) {

        int x, y;

        for (x = 0; x < mat.length; x++) {
            for (y = 0; y < mat[x].length; y++) {
                System.out.print(" | ");
                System.out.print(mat[x][y]);
                System.out.print(" | ");
            }
            System.out.println();
        }
    }//Fin método mostrar matriz
    
    public static int [][] multiplicarMatrices(int [][] mat1, int[][] mat2){
        
        int x, y;
        int [][] matMul = new int [2][2]; 
        
        for (x = 0; x < matMul.length; x++){
            for (y = 0; y < matMul[x].length; y++){
                matMul[x][y]=mat1[x][0]*mat2[0][y]+mat1[x][1]*mat2[1][y];
            }            
        }      
        
        return matMul;
    }//Fin método multiplicarMatrices
}
