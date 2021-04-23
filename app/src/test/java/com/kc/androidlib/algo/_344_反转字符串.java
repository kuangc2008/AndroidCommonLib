package com.kc.androidlib.algo;

import org.junit.Test;

public class _344_反转字符串 {

    @Test
    public void method1() {
        String work = "kuangcheng love sunlihui lalala";
        char[] s = work.toCharArray();


        System.out.println( reverseWorkds2(s));
    }


    /**
     *
     * 原地解法
     */
    public String reverseWorkds2(char[] s) {
        int n = s.length;
        for (int left = 0, right = n -1; left < right; ++left, --right) {
            swap(s, left, right);
        }
        return new String(s);
    }

    private void swap(char[] bytes, int left, int right) {

        char tmp  = bytes[left];
        bytes[left] = bytes[right];
        bytes[right] = tmp;
    }

}
