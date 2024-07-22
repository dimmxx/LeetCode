package org.example.tiproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayCommonElements {

    public static void main(String[] args) {

        int[] ar1 = {1, 5, 10, 19, 20, 40, 80};
        int[] ar2 = {5, 6, 7, 19, 20, 30, 40, 50, 80};
        int[] ar3 = {3, 4, 15, 19, 20, 30, 40, 50, 60, 77, 80};

        System.out.println(decision1(ar1, ar2, ar3));
        System.out.println(decision2(ar1, ar2, ar3));
        System.out.println(decision3(ar1, ar2, ar3));
        System.out.println(decision4(ar1, ar2, ar3));
        System.out.println(decision5(ar1, ar2, ar3));
        System.out.println(decision6(ar1, ar2, ar3));
    }

    private static List<Integer> decision6(int[] ar1, int[] ar2, int[] ar3) {
        List<Integer> com = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while (i < ar1.length && j < ar2.length && k < ar3.length) {
            if (ar1[i] == ar2[j] && ar2[j] == ar3[k]) {
                com.add(ar1[i]);
                i++;
                j++;
                k++;
            } else if (ar1[i] < ar2[j]) {
                i++;
            } else if (ar2[j] < ar3[k]) {
                j++;
            } else {
                k++;
            }
        }
        return com;
    }
    
    private static List<Integer> decision5(int[] array1, int[] array2, int[] array3) {
        List<Set<Integer>> collect = Stream.of(array1, array2, array3)
                .map(a -> Arrays.stream(a)
                        .boxed()
                        .collect(Collectors.toSet()))
                .toList();
        collect.get(0).retainAll(collect.get(1));
        collect.get(0).retainAll(collect.get(2));
        return new ArrayList<>(collect.get(0)).stream().sorted().collect(Collectors.toList());
    }

    private static List<Integer> decision4(int[] array1, int[] array2, int[] array3) {
        return Arrays.stream(array1).boxed().filter(e ->
                        Arrays.stream(array2)
                                .boxed()
                                .toList().contains(e) && Arrays.stream(array3)
                                .boxed().toList().contains(e))
                .distinct()
                .collect(Collectors.toList());
    }

    private static List<Integer> decision1(int[] array1, int[] array2, int[] array3) {
        List<Integer> result = new ArrayList<>();
        for (int i : array1) {
            if (searchElement(array2, i) && searchElement(array3, i)) {
                result.add(i);
            }
        }
        return result;
    }

    private static List<Integer> decision2(int[] array1, int[] array2, int[] array3) {
        List<Integer> result = new ArrayList<>();
        List<Integer> list2 = Arrays.stream(array2)
                .boxed()
                .toList();
        List<Integer> list3 = Arrays.stream(array3)
                .boxed()
                .toList();
        for (int i : array1) {
            if (list2.contains(i) && list3.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private static List<Integer> decision3(int[] array1, int[] array2, int[] array3) {
        return Arrays.stream(array1)
                .boxed()
                .filter(e ->
                        IntStream.of(array2)
                                .boxed()
                                .toList().contains(e) &&
                                IntStream.of(array3)
                                        .boxed()
                                        .toList().contains(e))
                .toList();
    }

    //recursive binary search
    private static boolean searchElement(int[] array, int element) {
        if (array.length > 1) {
            int[] array1 = Arrays.copyOfRange(array, 0, array.length / 2);
            int[] array2 = Arrays.copyOfRange(array, array.length / 2, array.length);
            return searchElement(array1, element) || searchElement(array2, element);
        }
        return array[0] == element;
    }
}

/*
You are given 3 sorted arrays, find common elements for all the arrays.
int ar1[] = { 1, 5, 10, 20, 40, 80 };
int ar2[] = { 5, 6, 7, 20, 30, 40, 50,80 };
int ar3[] = { 3, 4, 15, 20, 30, 40, 50, 60, 77, 80 };
output 20,40,80
 */