package org.example.p0006;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P0006_ZigZagConversion {

    public static void main(String[] args) {

        org.example.p0006.Solution solution = new org.example.p0006.Solution();

        //System.out.println(solution.convert("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 5));

        System.out.println(solution.convert("ABc", 2));

    }
}

class Solution {

    public String convert(String s, int numRows) {
        char[] array = s.toCharArray();
        List<Character> list = new ArrayList<>();
        if(numRows == 1){
            return s;
        }
        for (int i = 0; i < numRows; i++) {
            int j = i;
            while (j < s.length()) {
                list.add(array[j]);
                j += numRows + numRows - 2;
                if (i != 0 & i != numRows - 1) {
                    try {
                        list.add(array[j - 2 * i]);
                    } catch (ArrayIndexOutOfBoundsException ignored) {
                    }
                }
            }
        }
        //return list.stream().map(String::valueOf).collect(Collectors.joining());

        StringBuilder stringBuilder = new StringBuilder();
        for(Character ch : list){
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
}