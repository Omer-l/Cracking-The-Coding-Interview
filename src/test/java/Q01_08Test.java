import chapter01.Q01_08;
import org.junit.Test;

public class Q01_08Test {

    @Test
    public void initialise() {
        Q01_08 q01_08 = new Q01_08(7, 9);
        int[][] matrix = q01_08.getMatrix();
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
    }

    @Test
    public void destruction() {
        Q01_08 q01_08 = new Q01_08(7, 9);
        int[][] matrix = q01_08.getMatrix();
        System.out.println("Before");
        printMatrix(matrix);
        q01_08.matrixAfterBomb();
        int[][] matrixAfter = q01_08.getMatrix();
        System.out.println("After");
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