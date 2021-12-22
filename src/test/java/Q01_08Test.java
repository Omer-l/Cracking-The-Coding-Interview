import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Q01_08Test {

    @Test
    public void initialise() {
        Q01_08 q01_08 = new Q01_08(7, 9);
        int[][] matrix = q01_08.getMatrix();
        printMatrix(matrix);
    }

    @Test
    public void getNumberOfZeroBombs() {
        Q01_08 q01_08 = new Q01_08(7, 9);
        int[][] matrix = q01_08.getMatrix();

        int expected = 2;
        int actual = q01_08.getNumberOfZeros();

        assertEquals(expected, actual);
    }

    @Test
    public void getZeroLocations() {
        Q01_08 q01_08 = new Q01_08(7, 9);
        int[][] matrix = q01_08.getMatrix();

    }

    @Test
    public void test0Bomb() {
        Q01_08 q01_08 = new Q01_08(7, 9);
        int[][] matrix = q01_08.getMatrix();

        Q01_08.ZeroBomb[] zeroBombs = q01_08.getZeroLocations();
        System.out.println(Arrays.toString(zeroBombs));
    }

    @Test
    public void destruction() {
        Q01_08 q01_08 = new Q01_08(7, 9);

        q01_08.matrixAfterBomb();
        int[][] matrixAfter = q01_08.getMatrix();
        printMatrix(matrixAfter);
    }

    private void printMatrix(int[][] matrix) {
        for(int rowNumber = 0; rowNumber < matrix.length; rowNumber++) {
            for (int columnNumber = 0; columnNumber < matrix[rowNumber].length; columnNumber++)
                System.out.print(matrix[rowNumber][columnNumber] + "\t");
            System.out.println();
        }
    }
}