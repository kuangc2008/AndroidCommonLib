package com.kc.androidlib.algo;

import org.junit.Test;

public class _61_旋转链表 {

    @Test
    public void method1() {
        ListNode node = new ListNode(1).next(new ListNode(2).next(new ListNode(3).next(new ListNode(4))));

        ListNode reverse = rotateRight(node, 2);
        reverse.print();

    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int len = 1;
        ListNode node = head;
        while (node.next != null) {
            len++;
            node = node.next;
        }

        node.next = head;
        k = k % len;

        for (int i = 0; i < (len - k  - 1); i++) {
            head = head.next;
        }
        ListNode reusult = head.next;
        head.next = null;

        return reusult;




    }

    /**
     * 这个是反转链表
     * @param head
     * @return
     */
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
