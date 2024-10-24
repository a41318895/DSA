package algorithm.matrix;

public class Matrix implements MyMatrix {

    private int[][] data ;

    public Matrix(int[][] data) {

        this.data = data ;
    }


    @Override
    public void add(Matrix matrix) {

        int[][] arrayOfInputtingMatrix = matrix.data ;

        if (arrayOfInputtingMatrix.length != data.length ||
            arrayOfInputtingMatrix[0].length != data[0].length) {

            throw new IllegalArgumentException("Input matrix is not fit the format of the current matrix !") ;
        }

        for (int row = 0 ; row < data.length ; row ++) {

            for (int column = 0 ; column < data[row].length ; column ++) {

                data[row][column] += arrayOfInputtingMatrix[row][column] ;
            }
        }
    }

    /*
        Example Mock :

        rowA cal columnB -> rowColumnC

        A           B        C
        [1, 2, 3]   [1, 2]   [20, 14]
        [4, 5, 6]   [3, 4]   [56, 41]
                    [5, 6]

        row1 of A [1, 2, 3] cal
        column1 of B [1]
                     [3]
                     [5] -> row1Column1 of C [20]
     */
    @Override
    public void multiply(Matrix matrix) {

        if (data[0].length != matrix.data.length) {

            throw new IllegalArgumentException("Input matrix is not fit the format of the current matrix !") ;
        }

        int[][] result = new int[data.length][matrix.data[0].length] ;

        for (int row = 0 ; row < result.length ; row ++) {

            for (int column = 0 ; column < result[row].length ; column ++) {

                result[row][column] = calculateWeightedSum(this, row, matrix, column) ;
            }
        }

        this.data = result ;
    }

    // Calculate the weighted sum per position in matrix
    private int calculateWeightedSum(Matrix matrix1, int rowOfMatrix1, Matrix matrix2, int columnOfMatrix2) {

        int numberOfHandling = matrix1.data[0].length ;

        int resultValue = 0 ;

        for (int i = 0 ; i < numberOfHandling ; i ++) {

            resultValue += matrix1.data[rowOfMatrix1][i] * matrix2.data[i][columnOfMatrix2] ;
        }

        return resultValue ;
    }

    @Override
    public void transpose() {

        // Origin : [row][column] -> [column][row]
        int[][] result = new int[data[0].length][data.length] ;

        for (int row = 0 ; row < data.length ; row ++) {

            for (int column = 0 ; column < data[row].length ; column ++) {

                result[column][row] = data[row][column] ;
            }
        }

        this.data = result ;
    }

    @Override
    public int[][] toThreeTupleTable() {

        // Total number of storing space
        int elementNumber = data.length * data[0].length ;

        // Record the row of non-zero element
        Integer[] rowOfNonZeroElements = new Integer[elementNumber] ;
        // Record the column of non-zero element
        Integer[] columnOfNonZeroElements = new Integer[elementNumber] ;

        int nonZeroElementNumber = 0 ;

        for (int row = 0 ; row < data.length ; row ++) {

            for (int column = 0 ; column < data[row].length ; column ++) {

                if (data[row][column] != 0) {

                    rowOfNonZeroElements[nonZeroElementNumber] = row ;
                    columnOfNonZeroElements[nonZeroElementNumber] = column ;

                    nonZeroElementNumber ++ ;
                }
            }
        }

        // row 0 : Record the total row, column, and the number of non-zero element
        // row 1... : Record the row, column, and the non-zero element
        int[][] threeTupleTable = new int[nonZeroElementNumber + 1][3] ;

        // Init the row 0 information
        threeTupleTable[0][0] = data.length ;
        threeTupleTable[0][1] = data[0].length ;
        threeTupleTable[0][2] = nonZeroElementNumber ;

        // Fill row, column, the element from row 1...
        for (int i = 1 ; i <= nonZeroElementNumber ; i ++) {

            threeTupleTable[i][0] = rowOfNonZeroElements[i - 1] ;
            threeTupleTable[i][1] = columnOfNonZeroElements[i - 1] ;
            threeTupleTable[i][2] = data[threeTupleTable[i][0]][threeTupleTable[i][1]] ;
        }

        return threeTupleTable ;
    }

    public static Matrix restoreFromThreeTupleTableToMatrix(int[][] table) {

        if (table.length < 1 || table[0].length != 3) throw new IllegalArgumentException("Input table is not fit the format of three tuple table !") ;

        // Read the row and column from row 0
        int[][] resultTwoDimensionArray = new int[table[0][0]][table[0][1]] ;
        for (int i = 1 ; i <= table[0][2] ; i ++) {

            // Read row and column of element from column 0 & column 1
            int tempRow = table[i][0] ;
            int tempColumn = table[i][1] ;

            resultTwoDimensionArray[tempRow][tempColumn] = table[i][2] ;
        }

        return new Matrix(resultTwoDimensionArray) ;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder() ;

        for (int[] dataRow : data) {

            for (int singleData : dataRow) {

                sb.append(singleData).append("\t") ;
            }

            sb.append("\n") ;
        }

        return sb.toString() ;
    }
}
