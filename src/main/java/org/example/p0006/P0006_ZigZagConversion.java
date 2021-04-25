package org.example.p0006;

import java.util.ArrayList;
import java.util.List;

public class P0006_ZigZagConversion {

    public static void main(String[] args) {

        org.example.p0006.Solution solution = new org.example.p0006.Solution();

        System.out.println(solution.convert("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 5));
    }
}

class Solution {

    public String convert(String s, int numRows) {
        char[] array = s.toCharArray();
        List<Character> list = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            int j = i;
            while (j < s.length()){
                list.add(array[j]);

//                if(i != 0 & i != s.length() - 1){
//                    try {
//                        list.add(array[j + numRows - 1 - 1]);
//                    }catch (ArrayIndexOutOfBoundsException ignored){
//                    }

                j += numRows + numRows - 2;
            }
            list.add('-');
        }

        System.out.println(list);

        return "";
    }


}
