package com.arithmetic.sort;

import java.util.Arrays;

/**
 *  冒泡排序
 *  什么是冒泡排序呢，就是相邻的2个数进行比较(两两比较), 比较出来大或者小的交换位置
 *  从开始的位置两两比较，找出大或小的数，放到最后或者最前
 */
public class bubble {
    public static void main(String[] args) {
        int[] nums = {22,13,15,20,36,27};
        int[] nums2 = {132, 110, 122, 90, 50};
        bubbleSort(nums2);
        System.out.println(Arrays.toString(nums2));
    }

    public static void bubbleSort(int[] nums){
        int temp;
        // 外层控制排序的次数, 6个数字, 排序5次就可以了
        for (int i=1; i< nums.length; i++){
            for (int j=0; j< nums.length-i; j++){
                if (nums[j] > nums[j+1]){
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
            System.out.println("第"+i+"次排序:" +Arrays.toString(nums));
        }
    }
}
