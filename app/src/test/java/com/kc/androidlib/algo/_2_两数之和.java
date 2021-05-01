package com.kc.androidlib.algo;

import org.junit.Test;

public class _2_两数之和 {

    @Test
    public void method1() {
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;

        int carry = 0;

        while (l1 != null || l2 != null) {
            int n1 = l1 != null? l1.value : 0;
            int n2 = l2 != null? l2.value : 0;


            int sum = n1 + n2 + carry;

            if (head == null) {
                // 值
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            // 进位
            carry = sum/10;
            if (l1 != null) {
                l1  = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        return head;

    }




}
