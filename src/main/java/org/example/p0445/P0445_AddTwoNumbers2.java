package org.example.p0445;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;

public class P0445_AddTwoNumbers2 {

    public static void main(String[] args) {

        ListNode listNodeA4 = new ListNode(3);
        ListNode listNodeA3 = new ListNode(4, listNodeA4);
        ListNode listNodeA2 = new ListNode(2, listNodeA3);
        ListNode listNodeA1 = new ListNode(7, listNodeA2);
//
//
//        ListNode listNodeB3 = new ListNode(6);
//        ListNode listNodeB2 = new ListNode(1, listNodeB3);
//        ListNode listNodeB1 = new ListNode(9, listNodeB2);

        ListNode listNodeB1 = new ListNode(0);


        Solution solution = new Solution();

        System.out.println(solution.addTwoNumbers(listNodeA1, listNodeB1));
    }
}

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = packStack(l1);
        Stack<ListNode> stack2 = packStack(l2);

        int nextDigitIncrement = 0;
        Stack<ListNode> result = new Stack<>();

        AtomicBoolean finished1 = new AtomicBoolean(false);
        AtomicBoolean finished2 = new AtomicBoolean(false);

        while (!finished1.get() || !finished2.get()) {
            int num1 = calculateNum(stack1, finished1);
            int num2 = calculateNum(stack2, finished2);
            int sum = num1 + num2;
            if ((sum / 10) >= 1) {
                sum = sum % 10 + nextDigitIncrement;
                nextDigitIncrement = 1;
                finished1.set(false);
                finished2.set(false);
            } else {
                sum = sum + nextDigitIncrement;
                nextDigitIncrement = 0;
                if ((sum / 10) >= 1) {
                    sum = sum % 10;
                    nextDigitIncrement = 1;
                    finished1.set(false);
                    finished2.set(false);
                }

            }
            ListNode resultListNode = new ListNode(sum, calculateNext(result));
            result.push(resultListNode);
        }
        if (result.lastElement().val == 0) {
            result.pop();
        }
        return result.pop();
    }

    private ListNode calculateNext(Stack<ListNode> stack) {
        ListNode listNode;
        if (stack.size() == 0) {
            listNode = null;
        } else {
            listNode = stack.peek();
        }
        return listNode;
    }

    private int calculateNum(Stack<ListNode> stack, AtomicBoolean finished) {
        if (stack.size() == 0) {
            finished.set(true);
            return 0;
        } else {
            return stack.pop().val;
        }
    }
    
    private Stack<ListNode> packStack(ListNode listNode) {
        Stack<ListNode> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }
        return stack;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
