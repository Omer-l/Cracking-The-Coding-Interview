/**
 * String Compression: Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 * Hints:#92, #110
 * <p>
 * My Approach
 * Get the size of the compression first, this is by counting the occurence of each letter and the occurence number's
 * length + the letter is added iteratively.
 * Once the size if acquired, we have a fixed size so no unnecessary capacity doubling in the string builder will be made.
 * Then iterate again through the string, adding the compression to the string every time a new letter is found.
 */
public class Q01_06 {
    private final String stringToCompress;

    public Q01_06(String stringToCompress) {
        this.stringToCompress = stringToCompress;
    }

    /**
     * Compresses the string by calculating the occurence of each letter from the start of the string.
     *
     * @return a compressed version of the string to compress
     */
    public String compress() {
        int compressionSize = countCompression();

        if (compressionSize >= stringToCompress.length())
            return stringToCompress;

        StringBuilder compressedString = new StringBuilder(compressionSize);

        int consecutiveLetterCounter = 0;
        for(int characterIndex = 0; characterIndex < stringToCompress.length(); characterIndex++) {
            consecutiveLetterCounter++;

            char currentCharacter = stringToCompress.charAt(characterIndex);
            if(characterIndex + 1 >= stringToCompress.length() || currentCharacter != stringToCompress.charAt(characterIndex + 1)) {
                compressedString.append(currentCharacter);
                compressedString.append(consecutiveLetterCounter);
                consecutiveLetterCounter = 0;
            }
        }
        return compressedString.toString();
    }

    /**
     * Counts the number of different letters in the String
     *
     * @return the space required for the compression
     */
    public int countCompression() {
        int lengthRequiredForCompression = 0;
        int consecutiveLetterCount = 0;

        for (int characterIndex = 1; characterIndex < stringToCompress.length(); characterIndex++) {
            char previousChar = stringToCompress.charAt(characterIndex - 1);
            char currentChar = stringToCompress.charAt(characterIndex);

            if (previousChar != currentChar || characterIndex == stringToCompress.length() - 1) {
                lengthRequiredForCompression += 1 + String.valueOf(consecutiveLetterCount).length();
                consecutiveLetterCount = 0; //new letter.
            }

            consecutiveLetterCount++;
        }

        return lengthRequiredForCompression;
    }
}
