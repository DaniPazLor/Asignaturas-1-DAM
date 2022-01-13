
package Ejercicio4;



/**
 *
 * @author PAUDA
 */
public class MultiplicarMatrices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int [][] mat1= new int[2][2];
        int [][] mat2= new int[2][2];
        int [][] matMul = new int [2][2];
        
        
    System.out.println("--------MULTIPLICAR MATRICES 2X2-----------");
    System.out.println("Le pedimos los datos de la matriz primera");
    mat1=MatricesBidimensionales.introducirDatosMatriz();
    MatricesBidimensionales.mostrarMatriz(mat1);
    System.out.println("Le pedimos los datos de la matriz primera");
    mat2=MatricesBidimensionales.introducirDatosMatriz();
    MatricesBidimensionales.mostrarMatriz(mat2);
    System.out.println("El resultado de la multiplicación es");
    matMul=MatricesBidimensionales.multiplicarMatrices(mat1, mat2);
    MatricesBidimensionales.mostrarMatriz(matMul);
    }

}
