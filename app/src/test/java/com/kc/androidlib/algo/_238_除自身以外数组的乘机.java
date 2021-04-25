package com.kc.androidlib.algo;

import org.junit.Test;

public class _238_除自身以外数组的乘机 {

    @Test
    public void method1() {

    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        int[] L = new int[length];
        int[] R = new int[length];
        int[] answer = new int[length];


        L[0] = 1;
        for (int i =1; i <length; i++) {
            L[i] = nums[i - 1] * L [i - 1];
        }

        R[length - 1] = 1;
        for (int i = length -2 ; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }

        for (int i = 0; i <length; i++) {
            answer[i] = L[i] * R[i];
        }
        return answer;
    }

    public int[] productExceptSelf2(int[] nums) {
        int length = nums.length;

//        int[] L = new int[length];
//        int[] R = new int[length];
        int[] answer = new int[length];


        answer[0] = 1;
        for (int i =1; i <length; i++) {
            answer[i] = nums[i - 1] * answer [i - 1];
        }

//        R[length - 1] = 1;
        int R = 1;
        for (int i = length -1 ; i >= 0; i--) {
//            R[i] = nums[i + 1] * R[i + 1];

            answer[i] = answer[i] * R;
            R *= nums[i];
        }

//        for (int i = 0; i <length; i++) {
//            answer[i] = L[i] * R[i];
//        }
        return answer;
    }





}
