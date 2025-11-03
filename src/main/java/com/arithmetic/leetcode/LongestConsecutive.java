package com.arithmetic.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 *  最长连续数列
 *  给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *   请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *   示例 1：
 *      输入：nums = [100,4,200,1,3,2]
 *      输出：4
 *      解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 *   示例 2：
 *      输入：nums = [0,3,7,2,5,8,4,6,0,1]
 *      输出：9
 *
 *   示例 3：
 *      输入：nums = [1,0,1,2]
 *      输出：3
 *
 *   思路：
 *      1.将所有元素加入 HashSet。
 *      2.遍历每个数字 num：
 *          - 如果 num - 1 不在集合中，说明它可能是连续序列的起点；
 *          - 向后查找 num+1, num+2, … 是否存在；
 *          - 统计连续长度；
 *          - 更新最大长度。
 */
public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {1,0,1,2};
        int[] nums2 = {100,4,200,1,3,2};
        int longestConsecutive = longestConsecutive(nums2);
        System.out.println(longestConsecutive);
    }

    public static int longestConsecutive(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;
        for (int num : set){
            // 只有num 是连续列的起点时才往后找
            if (!set.contains(num-1)){
                int currentNum = num;
                int currentLen = 1;
                while (set.contains(currentNum+1)){
                    currentNum++;
                    currentLen++;
                }

                maxLen = Math.max(maxLen,currentLen);
            }
        }
        return maxLen;
    }
}
