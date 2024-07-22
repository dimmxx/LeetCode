package org.example.tiproblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamApiTask5 {

    public static void main(String[] args) {




        String test = "Welcome to the EPAM Interview process";
        List<String> collect = Arrays.stream(test.split(" "))
                .sorted(Comparator.comparing(String::length).reversed()).toList();
        String result = collect.stream().limit(1).findFirst().orElse(null);
        System.out.println(result);




    }
}

/*
(Java 8 Stream) Find the word that has the largest length amongst all the words present in the String
String test = "Welcome to the EPAM Interview process";
 */