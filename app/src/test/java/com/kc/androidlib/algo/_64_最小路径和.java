package com.kc.androidlib.algo;

import org.junit.Test;

import java.util.HashMap;

public class _64_最小路径和 {

    @Test
    public void method1() {
        // grid: [ [1,3,1], [1,5,1 , [4,2,1] ]
        // output: 7
        int[][] array = new int[][] {  {1,3,1}, {1,5,1} , {4,2,1} };
        System.out.println(  minPathSum(array) );

    }

    public int minLen(int[][] array) {
        if (array.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> results = new HashMap<>();

        int row = array.length;
        int colum = array[0].length;

        for (int i = 0 ; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                int result = array[i][j];
                int preMin = Integer.MAX_VALUE;
                if (i > 0) {
                    int preResult = results.get( (i - 1) * row + j );
                    if (preResult < preMin) {
                        preMin = preResult;
                    }
                }

                if (j > 0) {
                    int preResult = results.get( (i) * row + j - 1);
                    if (preResult < preMin) {
                        preMin = preResult;
                    }
                }
                results.put( row * i + j, (preMin == Integer.MAX_VALUE ? 0 : preMin) + result);
            }
        }

        return results.get( array.length * array[0].length - 1);

    }





    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int columns = grid[0].length;

        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min( dp[i-1][j] ,dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[rows -1 ][columns -1];
    }


}
