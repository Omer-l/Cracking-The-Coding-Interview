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
        Q01<Integer> q01 = new Q01<>(4, 1, 5);

        q01.add(1, 5);
        q01.add(1, 25);
        q01.add(1, 889);
        q01.add(1, 5);
        q01.add(1, 25);
        q01.add(2, 55);
        q01.add(2, 12345);
        q01.add(3, 500);
        q01.add(3, 123123123);
        q01.add(3, 123123123);
        q01.add(3, 123123123);
        q01.add(3, 9999999);
        q01.add(4, 8999999);
        q01.add(4, 8899999);
        q01.add(4, 8889999);
        q01.add(4, 8888999);
    }

    /** <b> Q2 </b> */


}