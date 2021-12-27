import chapter03.*;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Chapter3AllTests {

    /** <b> Q1 </b> */

    @Test
    public void add3Stacks() {

    }

    @Test
    public void resizeStack1() {
        Q01<Integer> q01 = new Q01<>(3, 1, 5);

        q01.add(1, 5);
        q01.add(1, 25);
        q01.add(3, 500);
    }

    /** <b> Q2 </b> */


}