package chapter1;

/**
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation
 * is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat", "atco eta", etc.)
 * Hints: #106, #121, #134, #136
 *
 * My Approach
 * Count the number of letter occurences.
 * build an integer array representing a hash table of the number of occurences of a letter
 * As letter occurences are counted, if two different letters occur an odd number of times, then the string is has no
 * palindrome permutations.
 */
public class Q01_04 {
    private final String string;

    public Q01_04(String palindromeString) {
        this.string = palindromeString;
    }

    /**
     * Evaluates the string. Whether it can be permuted into a palindrome
     *
     * @return true if it is a palindrome
     */
    public boolean canBePalindrome() {

        int[] characterFrequencyTable = buildCharacterFrequencyTable();
        return checkMaxOneOdd(characterFrequencyTable);
    }

    public boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;

        for (int count : table) {
            if (count % 2 == 1)
                if (foundOdd) //if it's the second odd
                    return false;
                else
                    foundOdd = true;
        }

        return true;
    }

    /**
     * Gets the ch value of the given letter, that is, if it is a letter
     *
     * @param ch is the character to evaluate
     * @return value of letter, -1 if the character isn't a letter
     */
    public int getCharacterNumber(char ch) {
        int z = Character.getNumericValue('z');
        int a = Character.getNumericValue('a');
        int characterNumber = Character.getNumericValue(ch);

        if (a <= characterNumber && characterNumber <= z)
            return characterNumber - a;
        else
            return -1;
    }

    /**
     * Builds an array of length 25, length of the alphabet
     *
     * @return array representing a hash table
     */
    public int[] buildCharacterFrequencyTable() {
        int[] characterFrequencyTable = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for (char ch : string.toCharArray()) {
            int characterNumber = getCharacterNumber(ch);
            if (characterNumber != -1)
                characterFrequencyTable[characterNumber]++;
        }


        return characterFrequencyTable;
    }
}
