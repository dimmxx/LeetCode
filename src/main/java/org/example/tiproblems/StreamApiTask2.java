package org.example.tiproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiTask2 {

    public static void main(String[] args) {

        List<List<Integer>> nestedLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(3, 4, 5),
                Arrays.asList(5, 6, 7),
                Arrays.asList(7, 8, 9)
        );

        List<Double> collect = nestedLists.stream()
                .flatMap(Collection::stream)
                .distinct()
                .map(Math::sqrt)
                .collect(Collectors.toList());

        List<Double> collect1 = nestedLists.stream()
                .flatMap(l -> l.stream())
                .distinct()
                .map(n -> Math.sqrt(n))
                .collect(Collectors.toList());

        System.out.println(collect);
        System.out.println(collect1);
    }
}

/*
You are given a list of lists containing integers. Calculate square root of every unique integer element and collect these elements to a list
List<List<Integer>> nestedLists = Arrays.asList(
Arrays.asList(1, 2, 3),
Arrays.asList(3, 4, 5),
Arrays.asList(5, 6, 7),
Arrays.asList(7, 8, 9)
);
 */