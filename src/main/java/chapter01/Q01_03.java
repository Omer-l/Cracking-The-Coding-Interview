package chapter01;

/**
 * 1.3 URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: if implementing in Java, please use a character array so that you can
 * perform this operation in place.)
 * EXAMPLE
 * Input: "Mr John Smith ", 13
 * Output: "Mr%20John%20Smith"
 *
 *
 * My 7 days
 * Split String by " ". Then iterate through the array and append elements to StringBuilder object with a %20
 */
public class Q01_03 {

    public static void main(String[] args) {
        String input = "Mr John Smith        ";
        int inputLength = input.length();

        System.out.println(urlify(input, inputLength));
    }

    /**
     * Replaces all spaces with '%20'
     * @param input                 is the string to urlify
     * @param lengthOfString        is the length of the string
     * @return                      a url version of the string with '%20' replacing the spaces.
     */
    public static String urlify(String input, int lengthOfString) {
        String[] words = input.split(" ");
        StringBuilder url = new StringBuilder();
        for(int wordIterator = 0; wordIterator < words.length; wordIterator++) {
            String word = words[wordIterator];

            boolean atLastWord = wordIterator != words.length - 1;

            if(!atLastWord) //ensures %20 isn't added to the end of the url.
                url.append(word);
            else
                url.append(word + "%20");
        }

        return url.toString();
    }
}
