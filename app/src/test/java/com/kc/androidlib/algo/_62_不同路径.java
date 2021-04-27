package com.kc.androidlib.algo;

import org.junit.Test;

public class _62_不同路径 {

    @Test
    public void method1() {
        int allPath = getAllPath2(3, 7);
        System.out.println("allPath:" + allPath);
    }

    /**
     * 重复计算
     * @param m
     * @param n
     * @return
     */
    public int getAllPath(int m,int n ) {
        if (m == 1) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        return getAllPath(m - 1, n ) + getAllPath(m, n - 1);
    }

    /**
     * 动态规划
     * @param m
     * @param n
     * @return
     */
    public int getAllPath2(int m,int n ) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            f[0][j] = 1;
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n ; ++j) {
                f[i][j] = f[i - 1] [j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }







}
