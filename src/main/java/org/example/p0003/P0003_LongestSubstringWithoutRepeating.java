package org.example.p0003;

import java.util.HashSet;
import java.util.Set;

public class P0003_LongestSubstringWithoutRepeating {

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }
}

class Solution {

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {

           Set<Character> set = new HashSet<>();
           int counter = 0;
           for(int k = i; k < s.length(); k++){
               if(!set.add(array[k])){
                   if(counter > result){
                       result = counter;
                   }
                   break;
               }
               counter++;
               if(counter > result){
                   result = counter;
               }

           }
        }
        return result;
    }
}
