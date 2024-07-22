package org.example.tiproblems;

import java.util.EmptyStackException;
import java.util.Stack;

public class ValidBrackets {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String brackets = "[{(<(a)(){}{}[]<>>)}]";
        System.out.println(solution.isValid(brackets));
    }

    static class Solution {
        public boolean isValid(String s) {

            String PARENTHESES = "()";
            String SQUARE = "[]";
            String CURLY = "{}";
            String ANGLE = "<>";

            Stack<Character> stack = new Stack<>();
            char[] array = s.toCharArray();

            for (char c : array) {
                String joint = String.join(PARENTHESES, SQUARE, CURLY, ANGLE);
                if (!joint.contains(String.valueOf(c))) {
                    continue;
                }
                if (c == PARENTHESES.charAt(0) || c == SQUARE.charAt(0) || c == CURLY.charAt(0) || c == ANGLE.charAt(0)) {
                    stack.push(c);
                } else {

                    char check;
                    try {
                        check = stack.peek();
                    } catch (EmptyStackException e) {
                        return false;
                    }

                    if (check == PARENTHESES.charAt(0) && c == PARENTHESES.charAt(1)) {
                        stack.pop();
                        continue;
                    }
                    if (check == SQUARE.charAt(0) && c == SQUARE.charAt(1)) {
                        stack.pop();
                        continue;
                    }
                    if (check == CURLY.charAt(0) && c == CURLY.charAt(1)) {
                        stack.pop();
                        continue;
                    }
                    if (check == ANGLE.charAt(0) && c == ANGLE.charAt(1)) {
                        stack.pop();
                        continue;
                    }
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }


}

/*

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.




*/