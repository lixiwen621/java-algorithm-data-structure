package com.arithmetic.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 *  KeypadCombinations 是数字键盘组合相关问题
 *      这个问题源自手机键盘的输入方式:
 *      给定一串数字字符串(如"23"), 要求返回该数字字符串在手机键盘上 所有可能的字母组合
 *      就是我们手机输入法中常用的 九宫格
 */
public class KeypadCombinations {

    // 映射表 (0和1 没有对应的字母)
    private static final String[] KEYPAD = {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs",// 7
            "tuv", // 8
            "wxyz" // 9
    };

    public static void main(String[] args) {
        String input = "23";
        List<String> combinations = letterCombinations(input);
        System.out.println(combinations);
    }

    public static List<String> letterCombinations(String digits){
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        backtrack(digits,0,new StringBuilder(),result);
        return result;
    }

    private static void backtrack(String digits, int index, StringBuilder path, List<String> result){
        // 结束条件
        if (digits.length() == index){
            result.add(path.toString());
            return;
        }

        // 当前数字对应的字符
        String letters = KEYPAD[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()){
            // 做选择
            path.append(c);
            // 递归下一位
            backtrack(digits, index+1, path, result);
            // 回溯
            path.deleteCharAt(path.length()-1);
        }
    }

}
