package com.kc.androidlib.algo;

import org.junit.Test;

public class _61_旋转链表 {

    @Test
    public void method1() {
        ListNode node = new ListNode(1).next(new ListNode(2).next(new ListNode(3).next(new ListNode(4))));

        ListNode reverse = reverse(node);
        reverse.print();

    }

    public ListNode reverse(ListNode head) {
        ListNode pre = head;
        ListNode curr  = head.next;
        ListNode next = head.next == null? null : head.next.next;

        pre.next = null;
        while (curr != null) {
            curr.next = pre;
            pre = curr;
            if (next == null) {
                break;
            }
            curr = next;
            next = next.next;
        }
        return curr;
    }




}
