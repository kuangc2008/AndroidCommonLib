package com.kc.androidlib.algo;

import org.junit.Test;

import java.util.LinkedHashMap;

public class _557_反转字符串中的单词3 {

    @Test
    public void method1() {
        String work = "kuangcheng love sunlihui lalala";

        System.out.println( reverseWorkds2(work));
    }

    /**
     *
     * 额外空间
     * o(N)  o(n)
     * @param s
     * @return
     */
    public String reverseWorkds(String s) {
        StringBuffer ret = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = start; p < i; p++) {
                ret.append(s.charAt(start + i -1 -p));
            }

            while (i < length && s.charAt(i) == ' ') {
                i++;
                ret.append(' ');
            }
        }
        return ret.toString();
    }


    /**
     *
     * 原地解法
     * o(N)  o(n)
     * @param s
     * @return
     */
    public String reverseWorkds2(String s) {
        int length = s.length();
        int i = 0;
        byte[] bytes = s.getBytes();
        while (i < length) {
            int start = i;
            while (i < length && bytes[i] != ' ') {
                i++;
            }

            int left = start;
            int right = i -1;
            while (left < right) {
                swap(bytes, left, right);
                left++;
                right--;
            }

            while (i < length && bytes[i] == ' ') {
                i++;
            }
        }
        return new String(bytes);
    }

    private void swap(byte[] bytes, int left, int right) {

        byte tmp  = bytes[left];
        bytes[left] = bytes[right];
        bytes[right] = tmp;
    }

}
