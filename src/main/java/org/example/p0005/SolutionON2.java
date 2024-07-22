package org.example.p0005;

import java.util.Arrays;

import static org.example.Utils.getCurrentNano;
import static org.example.Utils.printTimeElapsed;

class SolutionON2 {
    private final char dlmChar = '-';
    private String result = "";

    public String longestPalindrome(String s) {
        char[] populatedArray = populateDelimiterReturnArray(s);
        long start = getCurrentNano();
        for (int i = 0; i < populatedArray.length; i++) {
            char[] subArray = new char[0];
            for (int j = i - 1; j >= 0; j--) {
                int _j = 2 * i - j;
                if (j < 0 || _j > populatedArray.length - 1) {
                    break;
                }
                char l = populatedArray[j];
                char r = populatedArray[_j];

                if (l == r) {
                    subArray = Arrays.copyOfRange(populatedArray, j, _j + 1);
                } else {
                    break;
                }
            }
            if (subArray.length != 0) {
                addResultSubArray(subArray);
            }
        }
        printTimeElapsed(start, new Object() {
        }.getClass().getEnclosingMethod().getName());
        return result;
    }

    private char[] populateDelimiterReturnArray(String input) {
        long start = getCurrentNano();
        char[] array = input.toCharArray();
        char[] populatedArray = new char[array.length * 2 + 1];
        for (int i = 0; i < array.length; i++) {
            int j = i * 2 + 1;
            populatedArray[j - 1] = dlmChar;
            populatedArray[j] = array[i];
        }
        populatedArray[populatedArray.length - 1] = dlmChar;
        printTimeElapsed(start, new Object() {
        }.getClass().getEnclosingMethod().getName());
        return populatedArray;
    }

    private void addResultSubArray(char[] subArray) {
        long start = getCurrentNano();
        String palindrome = new String(subArray).replace(String.valueOf(dlmChar), "");
        if (result.length() < palindrome.length()) {
            result = palindrome;
        }
        printTimeElapsed(start, new Object() {
        }.getClass().getEnclosingMethod().getName());
    }
}
