package org.example.tiproblems;

import java.util.*;

public class MergeArrays {

    public static void main(String[] args) {

        int[] a2 = new int[]{20, 50, 60};
        int[] a1 = new int[]{3, 3, 3, 0, 0, 0};


        for (int num : a2){
            for (int k = 0; k < a1.length; k++){
                if(num <= a1[k]){
                    shift(a1, k);
                    a1[k] = num;
                    break;
                }

                if(a1[k] == 0){
                    a1[k] = num;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(a1));
    }

    private static void shift(int[] array, int pos){
        int temp = 0;
        for(int i = pos; i < array.length; i++){
            int innerTemp = array[i];
            array[i] = temp;
            temp = innerTemp;
        }
    }
}


/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109
*/