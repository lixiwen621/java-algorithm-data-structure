package com.arithmetic.sort;

import java.util.Arrays;

/**
 * @Title: quick
 * @Description:
 * @Auther: lixiwen
 * @Version: 1.0
 * @create 2020/9/28 21:49
 */
public class quick {
    public static void main(String[] args) {
        // 快速排序调用
        int[] quickNums = {15, 1, 22, 27, 23};
        System.out.println("排序前：" + Arrays.toString(quickNums));
        quickSort(quickNums, 0, quickNums.length - 1);
        System.out.println("排序后：" + Arrays.toString(quickNums));
    }
    /**
     * 快速排序
     */
    private static void quickSort(int[] nums, int left, int right) {
        int f, t;
        int ltemp = left;
        int rtemp = right;
        // 分界值
        f = nums[(left + right) / 2];
        while (ltemp < rtemp) {
            while (nums[ltemp] < f) {
                ++ltemp;
            }
            while (nums[rtemp] > f) {
                --rtemp;
            }
            if (ltemp <= rtemp) {
                t = nums[ltemp];
                nums[ltemp] = nums[rtemp];
                nums[rtemp] = t;
                --rtemp;
                ++ltemp;
            }
        }
        if (ltemp == rtemp) {
            ltemp++;
        }
        System.out.println(Arrays.toString(nums));
        if (left < rtemp) {
            // 递归调用
            quickSort(nums, left, ltemp - 1);
        }
        if (right > ltemp) {
            // 递归调用
            quickSort(nums, rtemp + 1, right);
        }

    }
}
