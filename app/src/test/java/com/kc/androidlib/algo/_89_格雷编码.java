package com.kc.androidlib.algo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _89_格雷编码 {



    @Test
    public void method1() {
        List<Integer> integers = grayCode(3);

        System.out.print(integers);
    }


    /**
     * 找规律，镜像算法
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);

        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() -1 ;  j >= 0; j--) {
                res.add(  head + res.get(j) );
            }
            head <<= 1;
        }
        return res;
    }


}
