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


    public void print() {
        System.out.println(value);
        ListNode a = next;
        while (a != null) {
            System.out.println(a.value);
            a = a.next;
        }
    }
}
