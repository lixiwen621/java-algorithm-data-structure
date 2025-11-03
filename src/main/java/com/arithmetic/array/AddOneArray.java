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
        int[] newNums1 = addOneInArray2(nums1);
        int[] newNums2 = addOneInArray22(num2);
        System.out.println(Arrays.toString(newNums1));
        System.out.println(Arrays.toString(newNums2));
    }

    public static int[] addOneInArray(int[] nums){
        int carry=0, right= nums.length-1;

        while (right >= 0){
            nums[right] = nums[right] + 1;
            //判断是否有进位
            carry = nums[right]/10;
            if (carry == 0){
                return nums;
            }
            nums[right]= 0;
            right--;

        }
        // 说明需要new 一个数组来进位了
        if (carry > 0 ){
            int[] newNums = new int[nums.length+1];
            newNums[0]=1;
            System.arraycopy(nums,0,newNums,1,newNums.length-1);
            return newNums;
        }
        return nums;

    }

    public static int[] addOneInArray2(int[] digits){
        int n = digits.length;
        for (int i=n-1; i>=0; i--){
            if (digits[i] < 9){
                digits[i]++;
                return digits;
            }
            // 需要进位
            digits[i] = 0;
        }

        // 如果到这里, 说明原生数组是 [9,9,9....]
        int[] result = new int[digits.length+1];
        result[0] = 1;
        return result;
    }

    public static int[] addOneInArray22(int[] digits){
        int n = digits.length;
        for (int i=n-1; i >= 0; i--){
            if (digits[i] < 9){
                digits[i]++;
                return digits;
            }
            // 等于9 说明需要进位
            digits[i] = 0;
        }
        // 如果到这里, 说明原生数组是  [9,9,9 ...] 一类的
        int[] result = new int[digits.length+1];
        result[0] = 1;
        return result;
    }
}
