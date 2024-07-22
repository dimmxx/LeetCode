package org.example.tiproblems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiTask1 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        int sum1 = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .mapToInt(n -> n)
                .sum();

        int sum2 = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, (a, b) -> a + b);

        int sum3 = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, Integer::sum);

        int sum4 = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.summingInt(n -> n.intValue()));

        int sum5 = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.summingInt(n -> n));

        System.out.println(sum1 + " " + sum2 + " " + sum3 + " " + sum4 + " " + sum5);

    }
}

/*
Given a list of integers, create a stream to filter out the even numbers and then square the remaining ones. Finally, find the sum of the squared values.

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
 */