package org.example.p0020;

import java.util.Stack;

class Solution {

    Stack<Character> stack = new Stack<>();

    char oSquare = '[';
    char cSquare = ']';
    char oRound = '(';
    char cRound = ')';
    char oFigure = '{';
    char cFigure = '}';

    public boolean isValid(String s) {
        char[] array = s.toCharArray();
        boolean closed = false;

        for (int i = 0; i < array.length; i++) {

            if (array[i] == oFigure || array[i] == oRound || array[i] == oSquare) {
                if (array[i] == oFigure) {
                    stack.add(cFigure);
                    continue;
                }
                if (array[i] == oRound) {
                    stack.add(cRound);
                    continue;
                }
                if (array[i] == oSquare) {
                    stack.add(cSquare);
                }
            } else {
                if (stack.size() != 0 && array[i] == stack.pop()) {
                    closed = true;
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0 && closed;
    }
}
