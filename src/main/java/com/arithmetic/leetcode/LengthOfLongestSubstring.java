package com.arithmetic.leetcode;

import java.util.*;

/**
 *  给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 *
 *  示例 1:
 *    输入: s = "abcabcbb"
 *    输出: 3
 *    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *  示例 2:
 *    输入: s = "bbbbb"
 *    输出: 1
 *    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *  示例 3:
 *
 *    输入: s = "pwwkew"
 *    输出: 3
 *    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring2(s1));
        String s2 = "bbbbb";
        System.out.println(lengthOfLongestSubstring2(s2));
        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring2(s3));
    }

    public static int lengthOfLongestSubstring(String s){
        Set<Character> set = new HashSet<>();
        int left=0, right=0, maxLength=0;

        while (right < s.length()){
            char c = s.charAt(right);

            // 如果字符已存在, 移动左指针直到窗口合法
            while (set.contains(c)){
                // 把 字符串中最左边的字符给移除
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            maxLength = Math.max(maxLength, right - left+1);
            right++;
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring2(String s){
        Map<Character, Integer> map = new HashMap<>();
        int maxLen=0, start=0;
        for (int end=0; end <s.length(); end++){
            char c = s.charAt(end);
            // map 记录字符的索引, 如果出现重复的向前滑动
            if (map.containsKey(c)){
                // 注意: start 只能向前滑动
                start = Math.max(map.get(c)+1,start);
            }
            map.put(c,end);
            maxLen = Math.max(maxLen, end-start+1);
        }
        return maxLen;
    }
}
