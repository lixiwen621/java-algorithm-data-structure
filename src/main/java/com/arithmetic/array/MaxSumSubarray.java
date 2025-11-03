package com.arithmetic.array;

/**
 *  最大和子数组
 *  您已获得一个包含数字的数组。查找并返回输入数组中连续子数组中的最大和
 *  Example 1:
 * - arr= [1, 2, 3, -4, 6]
 * - The largest sum is 8, which is the sum of all elements of the array.
 * - 最大的和是8，这是数组所有元素的和。
 *
 * Example 2:
 * - arr = [1, 2, -5, -4, 1, 6]
 * - The largest sum is 7, which is the sum of the last two elements of the array.
 * - - 最大和为 7，即数组最后两个元素的和。
 *
 *
 * Kadane's Algorithm 的核心思想
 * 1.子问题分析：
 * - 假设当前遍历到数组中的第 i 个元素，最大的连续子数组和可能有两种情况：
 * - 包含当前元素 nums[i] 的子数组最大和。
 * - 不包含当前元素，维持之前的最大和。
 * 2.决策逻辑：
 * - 如果前面的和（当前子数组的和）加上当前元素 nums[i] 是正的，那么继续累加当前元素。
 * - 如果前面的和是负的，则放弃前面的部分，从当前元素重新开始计算。(也就是 max(num, current_sum + num))
 * - 动态维护一个全局变量 max_sum 来记录遇到的最大值。
 * 3.贪心与动态规划结合：
 * - 通过每一步选择局部最优解（保留或舍弃之前的子数组），逐步构建出全局最优解。
 */
public class MaxSumSubarray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -4, 6};
        int[] arr2 = {1, 2, -5, -4, 1, 6};
        int[] arr3 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSumSubarray22(arr));
        System.out.println(maxSumSubarray(arr2));
        System.out.println(maxSumSubarray2(arr));
        System.out.println(maxSumSubarray2(arr2));
        System.out.println(maxSumSubarray(arr3));
        System.out.println(maxSumSubarray2(arr3));
    }

    /**
     * 方法1 暴力法破解
     *  每个数都相加来判断出最大子序列
     * @param arr
     * @return
     */
    public static int maxSumSubarray(int[] arr){
        int maxSum = 0;
        for (int i=0; i < arr.length-1; i++){
            int currentSum = 0;
            currentSum += arr[i];
            for (int j=i+1; j < arr.length; j++){
                currentSum += arr[j];
                maxSum = Math.max(currentSum,maxSum);
            }
        }
        return maxSum;
    }

    /**
     *  采用 Kadane's Algorithm
     * @param arr
     * @return
     */
    public static int maxSumSubarray2(int[] arr){
        int maxSum = 0;
        int currentSum = 0;
        for (int i=0; i < arr.length; i++){
            currentSum = Math.max(arr[i],currentSum + arr[i]);
            maxSum = Math.max(currentSum,maxSum);
        }
        return maxSum;
    }

    public static int maxSumSubarray22(int[] num){
        int maxSum = 0;
        int currentSum = 0;
        for (int i=0; i< num.length; i++){
            currentSum = Math.max(num[i],currentSum+num[i]);
            maxSum = Math.max(currentSum,maxSum);
        }
        return maxSum;
    }
}
