package chapter01;

/**
 * String Rotation:Assumeyou have a method isSubstringwhich checks if oneword is a substring
 * of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one
 * call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
 * Hints: #34, #88, # 7 04
 *
 * My Approach 7 days
 * append s1 to itself.
 * If s1.contains s2 now, then s2 is a rotation.
 */

public class Q01_09 {
    private String substring1;
    private String substring2;

    public Q01_09(String substring1, String substring2) {
        this.substring1 = substring1;
        this.substring2 = substring2;
    }

    //Gets the beginning index of the two strings.
    public boolean isRotation() {
        int lengthOfString = substring1.length();

        /* Checks that substring1 and substring2 are equal length and not empty */
        if(lengthOfString == substring2.length() && lengthOfString > 0) {
            /* Concatenate substring1 and substring 2 within new buffer */
            String substring1substring1 = substring1 + substring1;
            return substring1substring1.contains(substring2);
        }

        return false;
    }
}
