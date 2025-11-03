package com.arithmetic.recursion;

/**
 *  反转字符串
 */
public class ReverseStringRecursive {
    public static void main(String[] args) {
        String a = "abcd";
        String reverse = reverse(a);
        System.out.println(reverse);
    }

    /**
     *  反转字符串, 使用栈来进行反转，但是如果字符串很长，需要注意避免栈溢出
     * @param str
     * @return
     */
    public static String reverse(String str){
        if (str == null || str.length() <= 1){
            return str;
        }

        return reverse(str.substring(1))+str.charAt(0);
    }
}
