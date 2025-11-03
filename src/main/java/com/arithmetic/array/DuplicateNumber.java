package com.arithmetic.array;

/**
 *  重复号码
 *  您已获得一个长度 = n 的数组。该数组包含从 0 到 n - 2 的整数。
 *  数组中的每个数字都只出现一次，但有一个数字出现两次。查找并返回数组中存在的重复数字
 *
 *  Example:
 * - arr = [0, 2, 3, 1, 4, 5, 3]
 * - output = 3 (because 3 is present twice)
 *
 * 预期时间复杂度为 O(n)，预期空间复杂度为 O(1)
 */
public class DuplicateNumber {
    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 1, 4, 5, 3};
        System.out.println(duplicateNumber2(arr));
    }

    public static int duplicateNumber(int[] arr){
        int current_sum = 0;
        int expected_sum = 0;
        int n = arr.length;
        // 先得到数组的实际值
        for (int i=0; i<arr.length; i++){
            current_sum += arr[i];
        }
        // 在得到0到数组n-2 的期望值, 使用等差数列更高效
        expected_sum = (n -2)*(n-1)/2;
//        for (int j=0;j<arr.length-1;j++){
//            expected_sum += arr[j];
//        }

        return current_sum - expected_sum;
    }

    public static int duplicateNumber2(int[] nums){
        int currentSum = 0;
        int expected = 0;
        int n = nums.length;
        for (int i=0; i<n; i++){
            currentSum += nums[i];
        }
        // 等差数列的前 n-2 项 数的和, 第一项从 0 开始
        expected = (n-2)*(n-1)/2;
        return currentSum - expected;

    }
}
