package com.arithmetic.leetcode;

/**
 *  5、最长回文子串
 *      给你一个字符串 s，找到 s 中最长的 回文 子串。
 *
 *      示例 1：
 *          输入：s = "babad"
 *          输出："bab"
 *          解释："aba" 同样是符合题意的答案。
 *      示例 2：
 *          输入：s = "cbbd"
 *          输出："bb"
 *
 *    对于长度为 n 的字符串 s，若满足：s[i] == s[n - 1 - i] 对所有的 0 <= i < n/2 成立，那么就是回文串
 *
 *    解题思路：一个回文字符串从中间向两边对称的, 因此我们可以：
 *          - 从每一个字符(或字符之间) 向两边扩展
 *          - 找出所有可能的回文, 更新最长长度和起始位置
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(s.substring(1,3));
        String longestPalindrome = longestPalindrome(s);
        System.out.println(longestPalindrome);
    }

    public static String longestPalindrome(String s){
        if (s == null || s.length() < 1) return "";

        int start=0, end=0;
        for (int i=0; i<s.length(); i++){
            // 以一个字符为中心, 奇数个 s的字符
            int len1 = expandFromCenter(s,i,i);
            // 以两个字符为中心, 偶数个 s的字符
            int len2 = expandFromCenter(s,i,i+1);

            int len = Math.max(len1,len2);
            // 更新最长回文起点和终点
            if (len > end - start){
                start = i-(len - 1)/2; // 注意这里的转换技巧
                end = i + len/2;
            }

        }
        System.out.println(start+"-"+end);
        return s.substring(start, end+1);
    }

    /**
     *  根据传入的 s中的字符位置, 从中心点向外找
     * @param s
     * @param left
     * @param right
     * @return
     */
    private static int expandFromCenter(String s, int left, int right){
        while (left >=0 && right < s.length() && s.charAt(left)==s.charAt(right)){
            left--; right++;
        }
        return right -left -1; // 回文长度
    }
}
