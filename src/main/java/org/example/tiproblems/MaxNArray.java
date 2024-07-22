package org.example.tiproblems;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxNArray {

    public static void main(String[] args) {

        int[] array = {3, 8, 2, 3, 3, 2};
        System.out.println(solutionLoop(array));
        System.out.println(solutionStream(array));

    }
    
    private static Integer solutionStream(int[] array) {
        Map<Integer, Long> collect = Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return collect.entrySet().stream()
                .filter(e -> Objects.equals(Long.valueOf(e.getKey()), e.getValue()))
                .map(Map.Entry::getKey)
                .max(Comparator.naturalOrder()).orElse(0);
    }

    private static int solutionLoop(int[] array) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int j : array) {
            if (map.get(j) == null) {
                map.put(j, new ArrayList<>());
                map.get(j).add(j);
            } else {
                map.get(j).add(j);
            }
        }

//        map.forEach((k, v) -> System.out.println(k + ":" + v));

        int max = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getKey().equals(entry.getValue().size()) && entry.getKey() > max) {
                max = entry.getKey();
            }
        }
        return max;
    }
}


/*
Write a function

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns the biggest value X, which occurs in A exactly X times. If there is no such value, the function should return 0.

Examples:

        1. Given A = [3, 8, 2, 3, 3, 2], the function should return 3. The value 2 occurs exactly two times and the value 3 occurs exactly three times, so they both meet the task conditions. The value 8 occurs just once, thus it does not meet the task conditions. The maximum of 2 and 3 is 3.

        2. Given A = [7, 1, 2, 8, 2], the function should return 2. The value 1 occurs exactly one time; the value 2 occurs exactly two times.

        3. Given A = [3, 1, 4, 1, 5], the function should return 0. There is no value which meets the task conditions.

4. Given A = [5, 5, 5, 5, 5], the function should return 5.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [1..1,000,000,000].

*/