package com.arithmetic.recursion;

/**
 *  递归检查 字符串 是否是回文字符串
 *   递归逻辑:
 *   1. 终止条件
 *      如果字符串长度为0或1，那么它一定是回文
 *   2. 递归条件
 *      如果首尾字符相同，则递归检查 str[1... n-2] 是否是回文
 *      否则，不是回文
 */
public class PalindromeCheck {
    public static void main(String[] args) {
        String s1 = "racecar";
        String s2 = "hello";
        System.out.println(isPalindrome2(s1));
        System.out.println(isPalindrome2(s2));
    }

    /**
     *  方法1：使用字符串操作
     * @param str
     * @return
     */
    public static boolean isPalindrome(String str){
        if (str == null || str.length() <= 1){
            return true;
        }

        // 如果首尾字符不相等，返回 false
        if (str.charAt(0) != str.charAt(str.length()-1)){
            return false;
        }

        // 递归判断中间部分
        return isPalindrome(str.substring(1,str.length()-1));
    }

    /**
     *  方法2: 使用双指针(避免创建新字符串)
     * @param str
     * @return
     */
    public static boolean isPalindrome2(String str){
        return check(str,0,str.length()-1);
    }

    private static boolean check(String str, int left, int right){
        if (left >= right){
            return true;
        }

        if (str.charAt(left) != str.charAt(right)){
            return false;
        }

        return check(str,left+1,right-1);
    }
}
