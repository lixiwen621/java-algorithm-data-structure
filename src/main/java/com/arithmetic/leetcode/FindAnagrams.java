package com.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  438. 找到字符串中所有字母异位词
 *  给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 *  示例 1:
 *      输入: s = "cbaebabacd", p = "abc"
 *      输出: [0,6]
 *      解释:
 *      起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 *      起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 *  示例 2:
 *      输入: s = "abab", p = "ab"
 *      输出: [0,1,2]
 *      解释:
 *      起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 *      起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 *      起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 *  思路：
 *      1.用长度为 26 的数组（因为只有小写字母）分别记录：
 *          - 模式串 p 中每个字母出现的次数。
 *          - 窗口内当前字母出现的次数。
 *      2.使用固定长度为 p.length() 的滑动窗口在 s 上滑动，每次滑动一位：
 *          - 进入窗口的字符频率 +1，移出窗口的字符频率 -1。
 *          - 比较窗口内频率数组是否等于目标频率数组，相等说明是异位词。
 */
public class FindAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd"; String p = "abc";
        String s1 = "abab"; String p1 = "ab";
        //List<Integer> anagrams = findAnagrams(s, p);
        List<Integer> anagrams2 = findAnagrams(s1, p1);
        //System.out.println(anagrams);
        System.out.println(anagrams2);
    }

    public static List<Integer> findAnagrams(String s, String p){
        List<Integer> list = new ArrayList<>();
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // 统计p的频率
        for (char c : p.toCharArray()){
            pCount[c-'a']++;
        }

        // 滑动窗口
        for (int i=0; i<s.length(); i++){
            sCount[s.charAt(i)-'a']++; // 加入右端
            // 当前长度大于 p.length(), 缩左端
            if (i >= p.length()){
                sCount[s.charAt(i-p.length())-'a']--;
            }

            // 判断两个计数数组是否相等
            if (Arrays.equals(pCount,sCount)){
                list.add(i-p.length()+1);
            }
        }

        return list;
    }
}
