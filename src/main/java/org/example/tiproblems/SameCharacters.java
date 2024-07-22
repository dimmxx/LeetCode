package org.example.tiproblems;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SameCharacters {

    public static void main(String[] args) {

        String[] arr = {"abcd", "java", "dcba", "ajav", "xyz", "epam", "pame", "aepm"};

        Map<Integer, List<String>> map1 = process1(arr);
        Map<String, List<String>> map2 = process2(arr);
        Map<String, List<String>> map3 = process3(arr);

        System.out.println(map1);
        System.out.println(map2);
        System.out.println(map3);

    }

    private static Map<String, List<String>> process3(String[] array){
        Function<String, String> sortFunction = s -> {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        };
        return Arrays.stream(array)
            .collect(Collectors.groupingBy(sortFunction))
            .entrySet().stream()
            .filter(e -> e.getValue().size() > 1)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static Map<String, List<String>> process2(String[] array) {
        Map<String, List<String>> map = new HashMap<>();
        for (String string : array) {
            String temp = sortCharsInString(string);
            if (!map.containsKey(temp)) {
                map.put(temp, new ArrayList<>(List.of(string)));
            } else {
                map.get(temp).add(string);
            }
        }
        return map.entrySet().stream().filter(e -> e.getValue().size() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            }

    private static String sortCharsInString(String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private static Map<Integer, List<String>> process1(String[] array) {
        Map<Integer, List<String>> map = new HashMap<>();
        Arrays.stream(array).forEachOrdered(e -> {
            if (map.get(calculateCharSum(e)) == null) {
                List<String> list = new ArrayList<>();
                list.add(e);
                map.put(calculateCharSum(e), list);
            } else {
                map.get(calculateCharSum(e)).add(e);
            }
        });
        return map.entrySet().stream().filter(e -> e.getValue().size() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static int calculateCharSum(String string) {
        return string.chars().sum();
    }
}

/*
Identify the strings which have same characters.
Input:
String[] arr = { "abcd", "java", "dcba", "ajav", "xyz", "epam", "pame", "aepm" };
Output:
[epam, pame, aepm] contains same characters
[java, ajav] contains same characters
[abcd, dcba] contains same characters
 */