package com.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *  78.子集
 *      给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *      解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *  示例 1：
 *      输入：nums = [1,2,3]
 *      输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *  示例 2：
 *      输入：nums = [0]
 *      输出：[[],[0]]
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(),result);
        return result;
    }

    private static void backtrack(int[] nums,int index,List<Integer> path,List<List<Integer>> result){
        result.add(new ArrayList<>(path));

        for (int i=index; i< nums.length; i++){
            path.add(nums[i]); //做选择
            backtrack(nums,i+1,path,result); // 递归
            path.remove(path.size()-1); // 回溯, 撤销选择
        }
    }
}
