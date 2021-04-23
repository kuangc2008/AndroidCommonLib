package com.kc.androidlib.algo;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class _215_数组中第k个最大元素 {


    @Test
    public void method1() {
        int[] a = new int[] {3, 2, 1, 5, 6, 4};

        int value = findKthLargest(a, 2);
        System.out.println(value);
    }


    /**
     * 快速排序，但实际上可以做的更好
     *
     * 分解：  a(l...q-1]  < a[q]  <=  a[q+1...r】，
     * 解决：  递归调用来快速排序
     * 合并：  子数组都是排序的，不需要合并
     *
     * 所以只要找到了倒数第k个小标的  q时，就找到了答案，  子序列是否排序，不关心
     */
    private int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length -1 , nums.length - k );
    }

    private int quickSelect(int[] nums, int l, int r, int index) {
        int q = randomPartition(nums, l, r);
        if (q == index) {
            return nums[q];
        } else {
            return  q < index ? quickSelect(nums, q + 1, r, index) : quickSelect(nums,l, q -1, index);
        }
    }


    Random random = new Random();
    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt( r - l + 1) + l;
        Tools.swap(a, i, r);
        return partition(a, l, r);
    }

    public int partition(int[] a, int l, int r) {
        int x = a[r];
        int i = l -1;


        /**
         *         3  8   1  2  10   4   7
         *       index
         *         3  1   2  4  10   7   7
         *                    i
         */
        for (int j = l ;  j < r; ++j) {
            if (a[j] <= x) {
                Tools.swap(a, ++i, j);
            }
        }
        Tools.swap(a, i+1, r );
        return i + 1;

    }

}
