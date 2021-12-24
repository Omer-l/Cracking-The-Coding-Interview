package chapter01;

/**
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the
 * other.
 * Hints: #7, #84, #722, #737
 *
 * My Approach
 *
 * */
public class Q01_02 {

    public static void main(String[] args) {
        String string1 = "aab1crde";
        String string2 = "edcbara1";
        System.out.println(permutationOfTheOther(string1, string2));
    }

    /**
     * Iterates from the far right of string1 and the far left of string2 and determines whether they are a permutation
     * @param string1       is string 1 to evaluate
     * @param string2       is string 2 to evaluate
     * @return              true if the two strings are a permutation.
     */
    public static boolean permutationOfTheOther(String string1, String string2) {
        int lengthOfString = string1.length(); //length of string(s)
        int[] containsElement = new int[128]; //element will be counting if contains the ascii index number

        if (string1.length() != string2.length() || lengthOfString == 0)
            return false;
        else {
            for (int string1Iterator = 0; string1Iterator < lengthOfString; string1Iterator++)
                containsElement[string1Iterator]++;   //sets a standard in the int array to evaluate with string 2

            //now evaluating string 2, does it contain all the elements of string 1 the exact same number of times?
            for(int string2Iterator = 0; string2Iterator < lengthOfString; string2Iterator++) {
                containsElement[string2Iterator]--;
                if(containsElement[string2Iterator] < 0) //ensures that string 2 doesn't contain a different character
                    return false;
            }
        }

        return true;
    }
}
