package com.arithmetic.string;

/**
 *  字符串 加1
 */
public class AddOneString {
    public static void main(String[] args) {
        String s1 = "129";
        String plusOne1 = plusOne(s1);
        System.out.println(plusOne1);
        String s2 = "999";
        String plusOne2 = plusOne(s2);
        System.out.println(plusOne2);
        String s3 = "123";
        String plusOne3 = plusOne(s3);
        System.out.println(plusOne3);
    }

    public static String plusOne(String str){
        StringBuilder builder = new StringBuilder(str);
        int i = builder.length()-1;
        while (i >= 0){
            char c = builder.charAt(i);
            if (c == '9'){
                builder.setCharAt(i,'0');
                i--;
            }else {
                builder.setCharAt(i,(char)(c+1));
                return builder.toString();
            }
        }
        // 能到这里说明字符串是 "999..."
        builder.insert(0,'1');
        return builder.toString();
    }
}
