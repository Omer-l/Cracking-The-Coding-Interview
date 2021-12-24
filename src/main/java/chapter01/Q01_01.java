package chapter01;

import java.util.Scanner;

/**
 * s Unique: Implement an algorithm to determine if a string has all unique characters. What if you
 * cannot use additional data structures?
 * Hints: #44, #7 7 7, #732
 *
 *
 * My approach:
 * Create a boolean array of size ascii numbers.
 * Iterate through string, setting array ascii indexes to true.
 * If next character's allocated position in the hash table-like array is already true,
 * then this string does not contain all unique characters.
 */
public class Q01_01 {
    private static boolean[] containsElement = new boolean[128]; //to refer each letter in the string to
    private static String userInput = "";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string of unique characters: ");
        userInput = input.nextLine();
        System.out.println(uniqueString(userInput));
    }

    /**
     * Given a string, evaluates whether all characters are unique
     * @param userInput     is the string to evaluate
     * @return              true if all characters are unique.
     */
    public static boolean uniqueString(String userInput) {

        //loop through each character
        for(int characterIterator = 0; characterIterator < userInput.length(); characterIterator++) {
            char currentCharacter = userInput.charAt(characterIterator);
            int asciiIndex = (int)currentCharacter; //index of character in the containsElement array.
            if(containsElement[asciiIndex]) //determines if this ascii value has been seen already.
                return false;
            else
                containsElement[asciiIndex] = true;
        }

        return true;
    }
}
