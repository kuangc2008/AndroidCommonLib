package com.kc.androidlib.algo;

import org.junit.Test;

public class _70_爬楼梯 {

    @Test
    public void method1() {
        int n = 4;
        System.out.println(climbStairs2(n));
    }

    /**
     * f(n) = f(n-1) + f(n-2)
     *
     * f(1) = 1
     * f(2) = 2
     * @param n
     * @return
     *
     * O(n^2)
     */
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return climbStairs(n-1) + climbStairs(n-2);
    }

    /**
     * 滚动数组
     * @param n
     * @return
     *
     * O(n)
     */
    public int climbStairs2(int n) {
        int p = 0;
        int q = 0;
        int r = 1;
        for (int i = 1; i <= n ; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }







}
