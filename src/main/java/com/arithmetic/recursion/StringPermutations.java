package com.arithmetic.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 *  字符串全排列
 *      给定一个字符串, 生成它所有可能的字符顺序组合(顺序不同视为不同组合)
 *
 */
public class StringPermutations {
    public static void main(String[] args) {
        String s = "abc";
        List<String> result = permute(s);
        System.out.println(result);
    }

    public static List<String> permute(String s){
        // 准备返回的结果集 result
        List<String> result = new ArrayList<>();
        // 准备 used 数组, 记录哪些被使用过
        boolean[] used = new boolean[s.length()];
        backtrack(s.toCharArray(),new StringBuilder(),used,result);
        return result;
    }

    private static void backtrack(char[] chars, StringBuilder path, boolean[] used,List<String> result){
        //终止条件+ 添加到返回结果集合中
        if (chars.length == path.length()){
            result.add(path.toString());
            return;
        }

        // 遍历所有可能的条件
        for (int i=0; i< chars.length; i++){
            // 如果已选过, 则跳过
            if (used[i]) continue;
            // 做选择
            path.append(chars[i]);
            used[i]=true;
            // 递归到下一层
            backtrack(chars,path,used,result);
            // 撤销选择
            path.deleteCharAt(path.length()-1);
            used[i]=false;
        }
    }
}
