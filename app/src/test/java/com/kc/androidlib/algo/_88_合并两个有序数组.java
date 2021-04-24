package com.kc.androidlib.algo;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _88_合并两个有序数组 {



    @Test
    public void method1() {
        int[] a1 = new int[] {1,3,7,0, 0, 0};
        int[] a2= new int[] {2,4,6};

        merge(a1, 3, a2, 3);

        System.out.print(Arrays.toString(a1));
    }

    private void sort(int[] a1, int a1num, int[] a2, int a2Num) {

        int a1Index = a1num - 1;
        int a2Index = a2Num -1 ;

        while (a1Index >= 0 && a2Index >= 0) {
            if (a1[a1Index] <= a2[a2Index]) {
                a1[a1Index + a2Index + 1] = a2[a2Index];
                a2Index --;
            } else if (a1[a1Index] > a2[a2Index]) {
                a1[a1Index + a2Index + 1] = a1[a1Index];
                a1Index--;
            }
        }

        while (a2Index >= 0) {
            a1[a2Index] =  a2[a2Index];
            a2Index--;
        }

    }


    /**
     * 思路一样，leetcode方法
     * @param a1
     * @param a1num
     * @param a2
     * @param a2Num
     */
    private void merge(int[] a1, int a1num, int[] a2, int a2Num) {

        int a1Index = a1num - 1;
        int a2Index = a2Num -1 ;
        int tail = a1num + a2Num -1;
        int curr;

        while (a1Index >= 0 || a2Index >= 0) {
            if (a1Index == -1) {
                curr = a2[a2Index--];
            }  else if (a2Index == -1) {
                curr = a1[a1Index--];
            } else if (a1[a1Index] <= a2[a2Index]) {
                curr = a2[a2Index--];
            } else {
                curr = a1[a1Index--];
            }

            a1[tail--] = curr;
        }


    }

}
