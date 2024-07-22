package org.example.tiproblems;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaxSubArraySum {

    public static void main(String[] args) {
        int[] array = {4, 1, 5, 7, 2, 3};
        System.out.println(calculateSum(array, 7));


    }


    private static int calculateSum(int[] array, int subArrayLength) {
        int result = 0;

        if ((array.length - subArrayLength) < 0) {
            return 0;
        }

        for (int i = 0; i < array.length - subArrayLength + 1; i++) {
            int temp = IntStream.of(Arrays.copyOfRange(array, i, i + subArrayLength)).sum();
            if (temp > result) {
                result = temp;
            }
        }
        return result;
    }
}

/*
Given an integer array numbers, find a subarray of length equal to 'k' with the maximum sum value. Output the maximum sum value.
Input: [4, 1, 5, 7, 2, 3], k = 3
Output: 14
 */