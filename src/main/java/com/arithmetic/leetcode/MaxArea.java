package com.arithmetic.leetcode;

import java.util.Enumeration;

/**
 *  盛最多水的容器
 *  给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *  找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *  返回容器可以储存的最大水量。
 *
 *  输入：[1,8,6,2,5,4,8,3,7]输出：49 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。
 *  在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *  输入：height = [1,1]输出：1
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int maxArea = maxArea2(height);
        System.out.println(maxArea);
    }

    /**
     *  暴力法 (超时) 时间复杂度 O(n^2)
     * @param height
     * @return
     */
    public static int maxArea(int[] height){
        int maxArea=0;
        for (int i=0; i<height.length-1; i++){
            for (int j=i+1; j<height.length; j++){
                int x = j-i;
                int y = Math.min(height[i],height[j]);
                maxArea = Math.max(maxArea,x*y);
            }
        }

        return maxArea;
    }

    public static int maxArea2(int[] height){
        int maxArea = 0;
        int left=0; int right= height.length-1;

        while (left < right){
            int x = right - left;
            int y = Math.min(height[left],height[right]);
            maxArea = Math.max(maxArea,x*y);

            // 向内跳过相同或更矮的柱子
            while (left < right && height[left] <= y) left++;
            while (left < right && height[right] <= y) right--;
        }
        return maxArea;
    }
}
