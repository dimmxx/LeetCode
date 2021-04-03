package org.example.p0003;

public class P0003_LongestSubstringWithoutRepeating {

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.lengthOfLongestSubstring("abchc"));
    }
}

class Solution {

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int counter = 1;
            for (int j = i; j < s.length() - 1; j++) {
                if (array[j] != array[j + 1]) {
                    counter++;
                    if (j != s.length() - 2) {
                        continue;
                    }
                }
                if (counter > result) {
                    result = counter;
                }
                break;
            }
        }
        return result;
    }
}
