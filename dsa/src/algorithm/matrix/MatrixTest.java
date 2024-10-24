package algorithm.matrix;

import java.util.Arrays;

public class MatrixTest {

    public static void main(String[] args) {

        // row * column (3 * 4) two dimension array
        int[][] array = {

                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},

        } ;
        Matrix matrix = new Matrix(array) ;


        // Testing add() method
        int[][] array2 = {

                {5, 6, 7, 8},
                {1, 3, 5, 7},
                {2, 4, 6, 8},
        } ;
        Matrix matrixValid = new Matrix(array2) ;

        int[][] array3 = {

                {1, 3, 5},
                {2, 4, 6},
                {0, 7, 9}
        } ;
        Matrix matrixInvalid = new Matrix(array3) ;

        //matrix.add(matrixInvalid) ;

        //matrix.add(matrixValid) ;
        //System.out.println(matrix) ;


        // Testing multiply() method
        int[][] arrayForMatrix1 = {
                {1, 3, 5},
                {2, 4, 6},
        } ;
        Matrix matrix1 = new Matrix(arrayForMatrix1) ;
        int[][] arrayForMatrix2 = {
                {2, 4},
                {1, 3},
                {6, 8}
        } ;
        Matrix matrix2 = new Matrix(arrayForMatrix2) ;

        matrix1.multiply(matrix2) ;
        System.out.println("Multiplied Matrix : ");
        System.out.println(matrix1) ;


        // Testing transpose() method
        int[][] arrayForTranspose = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        } ;
        Matrix matrixForTranspose = new Matrix(arrayForTranspose) ;

        matrixForTranspose.transpose() ;
        System.out.println("Transposed Matrix :");
        System.out.println(matrixForTranspose) ;


        // Testing toThreeTupleTable() method
        int[][] arrayForToThreeTupleTable = {

                {1, 0, 0, 0, 0},
                {0, 0, 5, 0, 0},
                {0, 10, 0, 0, 1},
                {0, 0, 0, 15, 0},
                {0, 0, 0, 0, 25}
        } ;
        Matrix matrixForToThreeTupleTable = new Matrix(arrayForToThreeTupleTable) ;

        int[][] threeTupleTable = matrixForToThreeTupleTable.toThreeTupleTable() ;

        System.out.println("Three Tuple Table : ");
        for (int[] row : threeTupleTable) {

            System.out.println(Arrays.toString(row)) ;
        }


        // Testing restoreFromThreeTupleTableToMatrix() method
        Matrix matrixRestored = Matrix.restoreFromThreeTupleTableToMatrix(threeTupleTable) ;

        System.out.println("Restored Matrix : ") ;
        System.out.println(matrixRestored) ;
    }
}
