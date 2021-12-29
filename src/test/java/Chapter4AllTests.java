import chapter04.Q01;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Chapter4AllTests {

    /** <b> Q1 </b> */

    @Test
    public void existsRoute() {
        int[][] directedGraph = {
                {1, 2},
                {3, 4},
                {},
                {},
                {5, 6},
                {3},
                {}
        };

        Q01 q01 = new Q01(directedGraph);

        boolean expected = true;
        boolean actual = q01.existsRoute(0, 6);

        assertEquals(expected, actual);
    }

    /** <b> Q2 </b> */
}