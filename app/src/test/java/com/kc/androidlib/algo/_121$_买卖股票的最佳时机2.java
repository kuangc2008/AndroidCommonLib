package com.kc.androidlib.algo;

import org.junit.Test;

public class _121$_买卖股票的最佳时机2 {



    @Test
    public void method1() {
       int[] a1 = new int[] {7, 1, 5, 3, 6, 4};
       int[] a2 = new int[] {7, 6, 4, 3, 1};
       int[] a3 = new int[] {1, 2, 3, 4, 5};

       System.out.println(  getMaxProfit3(a1));
       System.out.println(  getMaxProfit3(a2));
       System.out.println(  getMaxProfit3(a3));
    }

    public int getMaxProfit(int[] a) {

        int lowPrice = Integer.MAX_VALUE;
        int highPrice = 0;

        int result = 0;

        boolean canBuy =  false;
        for (int i = 0; i < a.length; ++i) {
            if (!canBuy && a[i] < lowPrice) {
                lowPrice = a[i];
            }

            if (!canBuy && a[i] > lowPrice) {
                highPrice = a[i];
                canBuy = true;
            }


            if (canBuy) {
                if (a[i] > highPrice) {
                    highPrice = a[i];
                }

                if (a[i] < highPrice || (highPrice > lowPrice && (i == a.length - 1))) {
                    result += (highPrice - lowPrice);
                    canBuy = false;
                    lowPrice = a[i];
                }
            }
        }

        return result;
    }


    /**
     * 贪心算法
     * @param a
     * @return
     */
    public int getMaxProfit2(int[] a) {
        int ans = 0;

        int n = a.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, a[i] - a[i - 1]);
        }
        return ans;
    }

    /**
     * 动态规划
     * @param a
     * @return
     *
     *
     * [0]没有股票时的最大利润
     * 【1】有股票时的最大利润
     *
     * dp[i][0] = max {dp[i-1][0] , dp[i-1[1] + prices[i]}
     *  dp[i][1] = max {dp[i-1][1] , dp[i-1[0] - prices[i]}
     *
     *  最后为： dp[n-1][0]
     */
    public int getMaxProfit3(int[] a) {
        int n = a.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -a[0];
        for (int i = 1; i < n ; ++i) {
            dp[i][0] = Math.max(dp[i -1][0], dp[i-1][1] + a[i]);
            dp[i][1] = Math.max(dp[i -1][1], dp[i-1][0] - a[i]);
        }
        return dp[n-1][0];
    }
}
