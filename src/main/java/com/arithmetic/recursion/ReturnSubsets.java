package com.arithmetic.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 *  返回子集
 *
 */
public class ReturnSubsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }

    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(),result);
        return result;
    }

    private static void backtrack(int[] nums,int index,List<Integer> path,List<List<Integer>> result){
        // 每一步的 path 都是一个子集
        result.add(new ArrayList<>(path));

        for (int i=index; i<nums.length; i++){
            path.add(nums[i]); // 做选择
            backtrack(nums,i+1,path,result); // 递归到下一层
            path.remove(path.size()-1); // 回溯撤销选择
        }
    }

}
