package com.arithmetic.sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  1. 两数之和
 *  给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值target的那两个整数，并返回它们的数组下标。
 *  你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 *  你可以按任意顺序返回答案。
 *  示例 1：
 *   输入：nums = [2,7,11,15], target = 9
 *   输出：[0,1]
 *   解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 *  示例 2：
 *   输入：nums = [3,2,4], target = 6
 *   输出：[1,2]
 *
 *  示例 3：
 *   输入：nums = [3,3], target = 6
 *   输出：[0,1]
 */
public class twoSum {
    public static void main(String[] args) {
        int[] nums1 = {2,7,11,15}; int target1 = 9;
        System.out.println(Arrays.toString(twoSum2(nums1,target1)));
        int[] nums2 = {3,2,4}; int target2 = 6;
        System.out.println(Arrays.toString(twoSum2(nums2,target2)));
        int[] nums3 = {3,3}; int target3 = 6;
        System.out.println(Arrays.toString(twoSum2(nums3,target3)));

    }

    /**
     *  暴力破解法
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums,int target){
        for (int i=0; i<nums.length-1; i++){
            for (int j=i+1; j<nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }


    /**
     *  使用Map 记录数组中的值和 下标的位置
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i< nums.length; i++){
            int thatNum = target - nums[i];
            if (map.containsKey(thatNum) && map.get(thatNum)!= i){
                return new int[]{map.get(thatNum),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
