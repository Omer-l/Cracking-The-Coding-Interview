package chapter01;

/**
 * Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column are set to 0.
 * Hints:#17, #74, #702
 * <br>
 * <b>My Approach</b> 3 days<br>
 * Firstly, create an array of zero bombs, each zero bomb has a location of where it is in the matrix.
 * Then, iterate through the entire matrix and where there is a zero bomb in the same x or y axis in the matrix, put a 0.
 * This takes O(2n), AKA O(n) time.
 */
public class Q01_08 {
    private int[][] matrix;
    private final int rows;
    private final int columns;

    public Q01_08(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = generateMatrix();
    }

    //Generates a matrix of arbitrary numbers
    private int[][] generateMatrix() {
        int[][] matrix = new int[rows][columns];
        int count = 1;
        for (int rowNumber = 0; rowNumber < rows; rowNumber++)
            for (int columnNumber = 0; columnNumber < columns; columnNumber++)
                matrix[rowNumber][columnNumber] = (int) (Math.random() * 30);
        return matrix;
    }

    /**
     * Searches matrix for number of zeros
     *
     * @return number of zeros in matrix
     */
    public int getNumberOfZeros() {
        int zeroCounter = 0;

        for (int rowNumber = 0; rowNumber < rows; rowNumber++)
            for (int columnNumber = 0; columnNumber < columns; columnNumber++)
                if (matrix[rowNumber][columnNumber] == 0)
                    zeroCounter++;

        return zeroCounter;
    }

    /**
     * Creates an array of zero bomb locations.
     *
     * @return an array of zero bombs with their respective coordinates
     */
    public ZeroBomb[] getZeroLocations() {
        ZeroBomb[] zeroBombs = new ZeroBomb[getNumberOfZeros()]; //assign necessary size of the array
        int zeroBombsIndex = 0;

        for (int rowNumber = 0; rowNumber < rows; rowNumber++)
            for (int columnNumber = 0; columnNumber < columns; columnNumber++)
                if (matrix[rowNumber][columnNumber] == 0)
                    zeroBombs[zeroBombsIndex++] = new ZeroBomb(rowNumber, columnNumber);

        return zeroBombs;
    }

    /**
     * wipes rows and colums that have a '0' in them by setting the whole row and column with 0s
     */
    public void matrixAfterBomb() {
        ZeroBomb[] zeroBombs = getZeroLocations();

        for (int rowNumber = 0; rowNumber < matrix.length; rowNumber++)
            for (int columnNumber = 0; columnNumber < matrix[rowNumber].length; columnNumber++)
                for (int zeroBombIndex = 0; zeroBombIndex < zeroBombs.length; zeroBombIndex++)
                    if (rowNumber == zeroBombs[zeroBombIndex].rowNumber || columnNumber == zeroBombs[zeroBombIndex].columnNumber)
                        matrix[rowNumber][columnNumber] = 0;
    }

    public int[][] getMatrix() {
        return matrix;
    }


    /**
     * This class is for each 0 in the matrix. Holding its row and column number
     */
    public static class ZeroBomb {
        private int rowNumber;
        private int columnNumber;

        public ZeroBomb(int rowNumber, int columnNumber) {
            this.rowNumber = rowNumber;
            this.columnNumber = columnNumber;
        }

        @Override
        public String toString() {
            return "Bomb at - row: " + rowNumber + " - column: " + columnNumber;
        }
    }
}
