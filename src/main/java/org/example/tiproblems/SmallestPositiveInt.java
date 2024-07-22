package org.example.tiproblems;

import java.util.Arrays;

public class SmallestPositiveInt {


    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[] array = {1, 3, 6, 4, 1, 2};
        int[] array = {1, 2, 3, 3};

        System.out.println(solution.solution(array));
    }

    static class Solution {
        public int solution(int[] A) {
            Arrays.sort(A);
            int num = 1;
            for (int i = 0; i < A.length; i++) {
                if (A[i] <= 0) {
                    continue;
                }
                if (i < A.length - 1 && A[i] == A[i + 1]) {
                    continue;
                }
                if (A[i] > num) {
                    return num;
                }
                if (A[i] == num || i == A.length - 1) {
                    num++;
                }
            }
            return num;
        }
    }


}

/*

Write a function:

class Solution {
    public int solution(int[] A);
    }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
Given A = [1, 2, 3], the function should return 4.
Given A = [−1, −3], the function should return 1.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].

*/