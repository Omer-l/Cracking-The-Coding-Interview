/**
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the
 * other.
 * Hints: #7, #84, #722, #737
 *
 * My Approach
 * Comparison of right elements of first string to left elements of second string, then iterate to the next elements.
 */
public class Q01_02 {

    public static void main(String[] args) {
        String string1 = "abcde";
        String string2 = "edcba";
        assert string1.length() == 0: "Not a valid input";
        System.out.println(permutationOfTheOther(string1, string2));
    }

    public static boolean permutationOfTheOther(String string1, String string2) {
        if (string1.length() != string2.length() || string1.length() == 0)
            return false;
        else
            for (int characterIterator = 0; characterIterator < string1.length(); characterIterator++) {
                char string1Char = string1.charAt(string2.length() - characterIterator - 1); //right of string 1
                char string2Char = string2.charAt(characterIterator); //left of string 2

                if(string1Char != string2Char)
                    return false;
            }

        return true;
    }
}
