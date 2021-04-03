package org.example.p0002;

import java.math.BigInteger;

public class P0002_AddTwoNumbers {

    public static void main(String[] args) {

        ListNode listNodeA3 = new ListNode(3);
        ListNode listNodeA2 = new ListNode(4, listNodeA3);
        ListNode listNodeA1 = new ListNode(2, listNodeA2);

        ListNode listNodeB3 = new ListNode(4);
        ListNode listNodeB2 = new ListNode(6, listNodeB3);
        ListNode listNodeB1 = new ListNode(5, listNodeB2);

        Solution solution = new Solution();

        System.out.println(solution.addTwoNumbers(listNodeA1, listNodeB1));
    }
}

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger num1 = getNumberReversed(l1);
        BigInteger num2 = getNumberReversed(l2);
        BigInteger sum = num1.add(num2);
        return packListNodeReversed(sum);
    }

    private ListNode packListNodeReversed(BigInteger number) {
        String num = String.valueOf(number);
        ListNode temp = new ListNode();
        ListNode result = null;
        for (int i = 0; i < num.length(); i++) {
            result = new ListNode(Integer.parseInt(String.valueOf(num.charAt(i))), temp.next);
            temp.next = result;
        }
        return result;
    }

    private BigInteger getNumberReversed(ListNode listNode) {
        String num = "";
        ListNode temp = listNode;
        while (true) {
            num = num + temp.val;
            temp = temp.next;
            if (temp == null) {
                break;
            }
        }
        return new BigInteger(new StringBuilder(num).reverse().toString());
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