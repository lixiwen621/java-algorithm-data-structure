package com.arithmetic.sort;

import java.util.Arrays;

/**
 * @Title: select  选择排序
 * @Description:
 * @Auther: lixiwen
 * @Version: 1.0
 * @create 2020/9/28 17:30
 */
public class select {
    public static void main(String[] args) {
        int[] nums = {18,1,6,27,15};
        System.out.println("排序前:" + Arrays.toString(nums));
        selectSort(nums);
        System.out.println("排序后:" + Arrays.toString(nums));
    }

    public static void selectSort(int[] nums){
        int index;
        int temp;
        for (int i=0; i < nums.length-1; i++){
            index = i;
            for (int j=i+1; j < nums.length; j++){
                if (nums[j] < nums[index]){
                    index = j;  // 记录新的最小值的索引
                }
            }

            if (i != index){
                temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
            System.out.println("第" + (i+1) +"次排序:"+Arrays.toString(nums));
        }
    }
}
