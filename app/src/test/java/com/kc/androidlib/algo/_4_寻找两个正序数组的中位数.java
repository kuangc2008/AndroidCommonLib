package com.kc.androidlib.algo;

import org.junit.Test;

public class _4_寻找两个正序数组的中位数 {

    @Test
    public void method1() {
        int[] a1 = new int[] {1, 3};
        int[] a2 = new int[] {2, 4};

        float middle = finaMiddle(a1, a2);
        System.out.println(middle);
    }




    public float finaMiddle(int[] array1, int[] array2) {
        int total = array1.length + array2.length;
        int middle1;
        int middle2;
        if ( (total & 1) == 0) {
            middle1 = (total - 1)/2;
            middle2 = middle1 + 1;
        } else {
            middle1 = total/2;
            middle2 = middle1;
        }

        int middle1Value = 0;
        int middle2Value = 0;

        for (int i = 0, j = 0;  i < array1.length && j < array2.length; ) {
            if (i == array1.length - 1) {
                ++j;
            } else if (j == array2.length - 1) {
                ++i;
            } else if (array1[i] <= array2[j]) {
                ++i;
            } else {
                ++j;
            }
            if (i + j == middle1) {
                middle1Value = Math.min(array1[i], array2[j]);
                if (middle1 == middle2) {
                   return middle1Value;
                }
            }else if (i + j == middle2) {
                middle2Value = Math.min(array1[i], array2[j]);
                break;
            }
        }
        return (middle1Value + middle2Value) * 1f /2;


    }



}
