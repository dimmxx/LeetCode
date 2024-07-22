package org.example;

public class Utils {

    public static long getCurrentNano(){
        return System.nanoTime();
    }

    public static void printTimeElapsed(long start, String methodName){
        long diff = System.nanoTime() - start;
        double msDiff = (double) diff/1000_000;
        System.out.printf("Method [%s] time: %s ms\n", methodName, Double.toString(msDiff));
    }
}
