import chapter1.Q01_07;
import org.junit.Test;


public class Q01_07Test {

    @Test
    public void initialiseExercise() {
        Q01_07 q01_07 = new Q01_07();

    }

    @Test
    public void rotate90() {
        int[][] testImageMatrix = {
                {1,     2,  3,  4},
                {12,    1,  2,  5},
                {11,    4,  3,  6},
                {10,    9,  8,  7}};
        Q01_07 q01_07 = new Q01_07(testImageMatrix);
        int[][] actual = q01_07.rotate90();
    }
}