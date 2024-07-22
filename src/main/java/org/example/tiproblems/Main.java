package org.example.tiproblems;

import java.util.*;

class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        String[] arr = { "abcd", "java", "dcba", "ajav", "xyz", "epam", "pame", "aepm" };


        getSameCharatcherString(arr);

    }

    public static List<List<String>> getSameCharatcherString(String[] input){

        HashMap<String,List<String>> mp=new HashMap<>();

        for(int i=0;i<input.length;i++){

            char[] ch=input[i].toCharArray();
            Arrays.sort(ch);

            String curkey = "";
            for(char c:ch){
                curkey=curkey + c;
            }

            if(!mp.containsKey(curkey)){

                List<String> lst=new ArrayList<>();
                lst.add(input[i]);
                mp.put(curkey,lst);
            }else{
                List<String> similarString = mp.get(curkey);
                similarString.add(input[i]);
                mp.put(curkey,similarString);
            }
        }

        List<List<String>> opt=new ArrayList<>();

//        for(Map.Entry<String,List<String>> entry : mp.entryset()){
//
//            opt.add(entry.value);
//
//        }

        return opt;



    }
}