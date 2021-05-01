package com.kc.androidlib.algo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _78_子集 {



    @Test
    public void method1() {
        int[] array = new int[] {1,2,3,4};
        List<List<Integer>> lists = subSets3(array);

        for(List<Integer> set : lists) {
            System.out.println((set));
        }
    }

    /**
     * 000
     * 001
     * 010
     * 011
     * 100
     * 101
     * 110
     * 111
     * @param array
     * @return
     */
    public List<List<Integer>> subSet(int[] array) {
        int size = (int) (Math.pow(2, array.length));

        System.out.print(size);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            List<Integer> set = new ArrayList<>();

            int index = 0;
            int value = i;
            while (value > 0) {
                if ( value%2 == 1) {   //把10位转换为二进制，注意了，这样不好，看下面
                    set.add(  array[index] );
                }

                index++;
                value >>= 1;
            }

            result.add(set);
        }


        return result;


    }


    /**
     *      * 000
     *      * 001
     *      * 010
     *      * 011
     *      * 100
     *      * 101
     *      * 110
     *      * 111
     * @param array
     * @return
     */
    public List<List<Integer>> subSets2(int[] array) {
//        int size = (int) (Math.pow(2, array.length));

        List<List<Integer>> result = new ArrayList<>();
        int n = array.length;
        List<Integer> set = new ArrayList<>();
        for (int mask = 0; mask < (1<<array.length); ++mask) {
            set.clear();

            for (int i = 0; i < n ; ++i) {
                // 转换为二进制的递归
                if ( (mask & (1 << i)) != 0) {   //!!!!!!!
                    set.add(array[i]);
                }
            }

            result.add(set);
        }


        return result;


    }

    /**
     * 回溯算法
     *
     *
     * 递归（参数） 「
     *      if（终止条件）
     *         要做的操作
     *         return；
     *
     *      for（循环遍历）
     *          要做的操作
     *          递归
     *          撤销刚刚的操作
     *
     * 」
     *
     *
     *
     *
     *
     * @param array
     * @return
     */
    public List<List<Integer>> subSets3(int[] array) {
        int len = array.length;
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        dfs(result, array, len, path, 0);
        return result;

    }

    /**

     * arrary[0]  ---------
 *     array[1]  ----------
     *       array[2] ----------
     *            array[3]
     *            remove
     *
     *
     */
    private void dfs(List<List<Integer>> result, int[] array, int len, LinkedList<Integer> path, int begin) {
        result.add(new ArrayList<>(path));
        if (len == begin) {
            return;
        }

        for (int i = begin; i < len; i++) {
            path.add(array[i]);
            dfs(result, array, len, path, i + 1);
            path.removeLast();
        }
    }
}
