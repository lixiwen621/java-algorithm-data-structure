package com.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *  和为K的子数组
 *  给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *  子数组是数组中元素的连续非空序列。
 *
 *  示例 1：
 *   输入：nums = [1,1,1], k = 2
 *   输出：2
 *  示例 2：
 *   输入：nums = [1,2,3], k = 3
 *   输出：2
 */
public class SubarraySum {
    public static void main(String[] args) {
        int[] nums = {1,-1,0};
        int count = subarraySum2(nums, 0);
        System.out.println(count);
    }

    /**
     *  暴力破解法
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k){
        // count 统计 和为k的个数
        int count=0;
        for (int i=0; i <nums.length; i++){
            int j=i;
            int sum=0;
            while (j < nums.length){
                sum += nums[j];
                if (sum == k){
                    count++;
                    // 如果是 1 -1 0 的话，1-1=0; 1-1+0=0; 如果有负数所以这里不能break
                }
                j++;
            }
        }
        return count;
    }

    /**
     *  采用Map来处理
     *  k为 子数组的和, 并且k是连续的 子数组
     *  根据推导出来的公式：
     *  其中 i和j 都是数组下标, j肯定在i的后面
     *  sum[i-1] == sum[j] - k;
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum2(int[] nums, int k) {
        // 前缀和 -> 出现次数
        Map<Integer,Integer> map = new HashMap<>();
        // 前缀和为0 出现 1次
        map.put(0,1);

        int preSum=0; int count=0;
        for (int i=0; i<nums.length; i++){
            preSum += nums[i];
            //理解这个公式 sum[i-1] == sum[j] - k
            if (map.containsKey(preSum-k)){
                count += map.get(preSum-k);
            }

            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return count;
    }


}
