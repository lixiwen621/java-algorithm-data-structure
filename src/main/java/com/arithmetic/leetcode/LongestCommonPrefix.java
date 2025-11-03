package com.arithmetic.leetcode;

/**
 *  最长公共前缀
 *  编写一个函数来查找字符串数组中的最长公共前缀。
 *  如果不存在公共前缀，返回空字符串 ""。
 *
 *  示例 1：
 *      输入：strs = ["flower","flow","flight"]
 *      输出："fl"
 *
 *  示例 2：
 *      输入：strs = ["dog","racecar","car"]
 *      输出：""
 *      解释：输入不存在公共前缀。
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }

    public static String longestCommonPrefix(String[] strs) {
        for (int i=0; i<strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for (int j=1; j< strs.length; j++){
                // 如果第一个字符串的的索引 对于后面的字符串已经越界, 或字符不匹配, 说明前缀已确定完毕
                if (i >= strs[j].length() || strs[j].charAt(i) != c){
                    return strs[0].substring(0,i);
                }
            }
        }
        // 完全满足
        return strs[0];
    }
}
