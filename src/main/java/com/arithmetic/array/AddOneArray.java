package com.arithmetic.array;

import java.util.Arrays;

/**
 * 数组中实现加1
 *  例如：{1,2,3} 加1 为{1,2,4}
 *      {9,9,9} 加1 为{1,0,0,0}
 */
public class AddOneArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] num2 = {9,9,9};
        int[] newNums1 = addOneInArray(nums1);
        int[] newNums2 = addOneInArray(num2);
        System.out.println(Arrays.toString(newNums1));
        System.out.println(Arrays.toString(newNums2));
    }

    public static int[] addOneInArray(int[] nums){
        for (int i= nums.length-1; i >= 0; i--){
            nums[i] = nums[i] + 1;
            if (nums[i] % 10 != 0){
                return nums;
            }
            nums[i] = 0;
        }

        int[] newNums = new int[nums.length+1];
        newNums[0] = 1;
        // System.arraycopy 有下面这种效果
        // for (int n=1; n<newNums.length; n++){
        //            newNums[n] = nums[n-1];
        //        }
        System.arraycopy(nums, 0, newNums, 1, newNums.length - 1);
        return newNums;
    }
}
