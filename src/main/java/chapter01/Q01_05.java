package chapter01;

/**
 * 1.5
 * One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bae -> false
 *
 * My Approach 7 days later
 * If both strings are same length -> count up the difference between the two, if more than 1 diff, return false, if no diff, return false.
 * If s1 is larger than s2, then look out for when s1 is different and +1 to its index in the iteration / vice versa if s2 was larger.
 *
 */
public class Q01_05 {
    private final String original;

    public Q01_05(String original) {
        this.original = original;
    }

    /**
     * Compares edited string to this original string
     * @param edited        string to compare
     * @return              true if only 1 edit is made.
     */
    public boolean edited(String edited) {

        if(original.length() == edited.length()) { //a replaced character?
            return oneEditReplace(edited);
        } else if(original.length() + 1 == edited.length()) { //one character is removed
            return oneEditInsertedOrRemoved(original, edited);
        } else if(original.length() - 1 == edited.length()) {
            return oneEditInsertedOrRemoved(edited, original);
        }
        //more than 1 character is missing or added
        return false;
    }

    /**
     * finds differences in the edited string
     * @param editedString      edited string to compare
     * @return                  true if edited string has only 1 change compared to the original.
     */
    public boolean oneEditReplace(String editedString) {
        int differenceCounter = 0;

        for(int characterNumber = 0; characterNumber < original.length(); characterNumber++) {
            char originalCharacter = original.charAt(characterNumber);
            char editedCharacter = editedString.charAt(characterNumber);

            if(originalCharacter != editedCharacter)
                differenceCounter++;

            if(differenceCounter > 1) //as there are is clearly more than one difference
                return false;
        }

        return true;
    }

    /**
     * compares two strings, for which, string 1 is bigger
     * @param string1   the string bigger by 1
     * @param string2   the string less in length by 1
     * @return          true if only one character is added and none replaced
     */
    public boolean oneEditInsertedOrRemoved(String string1, String string2) {

        int index1 = 0;
        int index2 = 0;

        while(index1 < string1.length() && index2 < string2.length()) {
            char originalCharacter = string1.charAt(index1);
            char editedCharacter = string2.charAt(index2);

            if(originalCharacter != editedCharacter) {
                if (index1 != index2)
                    return false;
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

}
