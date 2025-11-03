package com.arithmetic.leetcode;

/**
 *  541. 反转字符串II
 *  给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 *  如果剩余字符少于 k 个，则将剩余字符全部反转。
 *  如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 *  示例 1：
 *      输入：s = "abcdefg", k = 2
 *      输出："bacdfeg"
 *
 *  示例 2：
 *      输入：s = "abcd", k = 2
 *      输出："bacd"
 */
public class ReverseString2 {
    public static void main(String[] args) {
        String s1 = "abcdefg"; int k1=2;
        String reverseStr1 = reverseStr(s1, k1);
        System.out.println(reverseStr1);
        String s2 = "abcdefgh"; int k2 = 3;
        String reverseStr2 = reverseStr(s2, k2);
        System.out.println(reverseStr2);
        String s3 = ""; int k3=2;
        System.out.println(reverseStr(s3,k3));
        String s4 = "abc"; int k4=4;
        System.out.println(reverseStr(s4,k4));
    }

    public static String reverseStr(String s,int k){
        int length = s.length();
        char[] chars = s.toCharArray();
        for (int i=0; i< chars.length; i += 2*k){
            int left=i;
            int right= Math.min(left+k-1,length-1);
            while (left < right){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        return String.valueOf(chars);
    }
}
