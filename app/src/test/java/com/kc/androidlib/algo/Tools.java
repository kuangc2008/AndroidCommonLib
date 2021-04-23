package com.kc.androidlib.algo;

class Tools {
    public static void swap(int[] bytes, int left, int right) {

        int tmp  = bytes[left];
        bytes[left] = bytes[right];
        bytes[right] = tmp;
    }
}
