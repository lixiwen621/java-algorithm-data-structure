package com.arithmetic.leetcode;

import java.util.*;

/**
 *  字母异位词分组
 *  给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *  字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 *
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupAnagramsList = groupAnagrams3(strs);
        System.out.println(groupAnagramsList);
        System.out.println('e'-'a');
    }

    public static List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars); // 排序后作为字符串的key

            map.compute(key,(k,v)->{
                if (v == null){
                    v = new ArrayList<>();
                }
                v.add(str);
                return v;
            });
        }
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagrams2(String[] strs){
        Map<String,List<String>> map = new HashMap<>();

        for (String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key,k -> {
                return new ArrayList<>();
            }).add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     *  不通过 排序的 方式来实现
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams3(String[] strs){
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26]; // 记录字母频率
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            // 构建唯一的 key：如 a1b0c0...z0
            StringBuilder sb = new StringBuilder();
            for (int num : count) {
                sb.append('#');  // 加分隔符防止歧义
                sb.append(num);
            }
            String key = sb.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

}
