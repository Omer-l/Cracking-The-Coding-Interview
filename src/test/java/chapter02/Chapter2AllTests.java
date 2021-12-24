package chapter02;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class Chapter2AllTests {

    /** <b> Q1 </b> */

    @Test
    public void existsDuplicate() {
        LinkedList<String> testList = new LinkedList<>();
        testList.add("hello");
        testList.add("mello");
        testList.add("tello");
        testList.add("hello");

        Q01 q01 = new Q01(testList);

        assertTrue(q01.existsDuplicate());
    }

    @Test
    public void existsNoDuplicate() {
        LinkedList<String> testList = new LinkedList<>();
        testList.add("hello");
        testList.add("mello");
        testList.add("tello");
        testList.add("nello");

        Q01 q01 = new Q01(testList);
        boolean expected = false;
        boolean actual = q01.existsDuplicate();

        assertEquals(expected, actual);
    }

    @Test
    public void removeDuplicates() {
        LinkedList<String> testList = new LinkedList<>();
        testList.add("hello");
        testList.add("mello");
        testList.add("tello");
        testList.add("hello");

        Q01 q01 = new Q01(testList);

        q01.removeDuplicates();

        boolean expected = false;
        boolean actual = q01.existsDuplicate();

        assertEquals(expected, actual);
    }


    /** <b> Q2 </b> */


}