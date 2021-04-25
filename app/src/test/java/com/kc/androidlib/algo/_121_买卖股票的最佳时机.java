package com.kc.androidlib.algo;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class _121_买卖股票的最佳时机 {



    @Test
    public void method1() {
       int[] a1 = new int[] {7, 1, 5, 3, 6, 4};
       int[] a2 = new int[] {7, 6, 4, 3, 1};

       System.out.println(  getMaxProfit2(a1));
       System.out.println(  getMaxProfit2(a2));
    }

    /**
     * 暴力
     * @param a
     * @return
     */
    public int getMaxProfit(int[] a) {

        int length = a.length;

        int maxPrice = 0;
        for (int i = 0 ;  i< a.length - 1; ++i) {
            for (int j = i + 1; j < a.length; ++j) {
                int price = a[j] - a[i];
                if (price > maxPrice) {
                    maxPrice = price;
                }
            }
        }

        return maxPrice;
    }

    /**
     * 从左到右，会一直想要右边的最小值
     * @param a
     * @return
     */
    public int getMaxProfit2(int[] a) {
        int minPrice = Integer.MAX_VALUE;

        int result = 0;
        for (int i = 0 ;  i< a.length; ++i) {
            if (a[i] < minPrice) {
                minPrice = a[i];
            } else {
                int price = a[i] - minPrice;
                if (price > result) {
                    result = price;
                }
            }
        }

        return result;
    }

}
