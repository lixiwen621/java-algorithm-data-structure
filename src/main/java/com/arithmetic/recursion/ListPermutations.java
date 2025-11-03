package com.arithmetic.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 *  列表排列(List Permutations)
 *   List Permutations (排列)是指给定一个列表(或数组), 生成它所有的可能的全排列
 *   例如: 给一个列表[1,2,3]
 *      返回 它的所有排列[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]
 */
public class ListPermutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }

    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums,new ArrayList<>(),used,result);
        return result;
    }

    private static void backtrack(int[] nums,List<Integer> path, boolean[] used, List<List<Integer>> result){
        // 终止条件: 所有数已选
        if (nums.length == path.size()){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i=0; i<nums.length; i++){
            // 如果已经选过, 跳过
            if (used[i]) continue;

            // 做选择
            path.add(nums[i]);
            // 标记为已使用
            used[i] = true;
            // 递归下一层
            backtrack(nums,path,used,result);
            // 回溯: 撤销选择
            path.remove(path.size()-1);
            used[i] = false;
        }
    }
}
