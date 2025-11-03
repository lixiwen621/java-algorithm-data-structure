package com.arithmetic.leetcode;

/**
 *  42. 接雨水
 *  给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *  示例图 请看有道笔记吧
 */
public class CatchRainwater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height2 = {4,2,0,3,2,5};
        int trap = trap(height);
        int trap2 = trap(height2);
        System.out.println(trap);
        System.out.println(trap2);
    }

    public static int trap(int[] height){
        int total=0; int left=0; int right= height.length-1;
        int leftMax=0; int rightMax=0;
        while (left < right){
            // 因为 当前位置能接的水量 = min(左侧最大高度, 右侧最大高度)- 当前高度
            // height[left] < height[right]，说明 min的是 height[left]
            if (height[left] < height[right]){
                //说明当前left 决定了这段的水位上限，我们可以放心处理left并移动left++;
                if (height[left] >= leftMax){
                    leftMax = height[left];
                }else {
                    total += leftMax-height[left];
                }
                left++;
            }else {
                if (height[right] >= rightMax){
                    rightMax = height[right];
                }else {
                    total += rightMax-height[right];
                }
                right--;
            }
        }
        return total;
    }
}
