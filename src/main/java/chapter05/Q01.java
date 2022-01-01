package chapter05;

/**
 * Insertion: You are given two 32-bit numbers, N and M, and two bit positions, i and
 * j. Write a method to insert M into N such that M starts at bit j and ends at bit i. You
 * can assume that the bits j through i have enough space to fit all of M. That is, if
 * M = 10011, you can assume that there are at least 5 bits between j and i. You would not, for
 * example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
 * EXAMPLE
 * Input: N 10000000000, M = 10011, i = 2, j = 6
 * Output: N = 10001001100
 * Hints: #137, #769, #215
 */
public class Q01 {

    private final int M;
    private final int N;

    public Q01(int m, int n) {
        M = m;
        N = n;
    }

    /** operates in almost the reverse of setBit. First, we create a number like 11101111 by creating
     * the reverse of it (00010000) and negating it. Then, we perform an AND with num. This will clear the
     * ith bit and leave the remainder unchanged.
     * @param num   the number to clear a bit from.
     * @param index the index to clear
     */
    public int clearBit(int num, int index) {
        int mask = ~(1 << index);
        return num & mask;
    }

    /**
     * Places M into N such that M fully fits into N with the given indexes
     * @param beginningIndex    the place where M start to merge in
     * @param endIndex          the end index of inside N
     * @return                  a 32 bit number where M is inside N
     */
    public int mergeMToN(int beginningIndex, int endIndex) {

        //sequence of 1s
        int allOnes = ~0;

        //1s before end index, then 0s. left = 1110000
        int left = allOnes << (endIndex + 1);

        //1's after start position. Right = 000000011
        int right = ((1 << beginningIndex) - 1);

        //All 1s, except for 0s between start and end index. mask = 11100011
        int mask = left | right;

        //Clear bits inbetween i and j then put M into it
        int nCleared = N & mask;
        int mShifted = M << beginningIndex; //move M into correct position

        return nCleared | mShifted; //OR them
    }
}
