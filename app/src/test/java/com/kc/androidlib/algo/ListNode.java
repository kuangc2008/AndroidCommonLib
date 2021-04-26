package com.kc.androidlib.algo;

class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode next(ListNode next) {
        this.next = next;
        return this;
    }
}
