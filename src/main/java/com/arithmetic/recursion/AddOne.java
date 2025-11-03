package com.arithmetic.recursion;

import java.util.Arrays;

/**
 *  使用递归进行加1的操作
 */
public class AddOne {
    public static void main(String[] args) {
        int[] digits = {9,9,9};
        int[] plusOne = plusOne(digits);
        System.out.println(Arrays.toString(plusOne));

        String digits2 = "999";
        String plusOne2 = plusOne(digits2);
        System.out.println(plusOne2);
    }

    /**
     *  数组加1
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits){
        if (addOneRecursive(digits, digits.length-1)){
            // 如果最高位需要进位, 999 -> 1000
            int[] newDigits = new int[digits.length+1];
            newDigits[0]=1;
            return newDigits;
        }
        return digits;
    }

    /**
     *  递归函数: 对第 index 位加一
     * @param digits
     * @param index
     * @return 是否需要进位(true 表示当前为是9, 加一后需要进位)
     */
    private static boolean addOneRecursive(int[] digits, int index){
        if (index < 0){
            return true; // 到最前还需要进位
        }

        if (digits[index] < 9){
            digits[index]++;
            return false; // 加完无需进位
        }else {
            digits[index] = 0;
            return addOneRecursive(digits, index-1); // 递归向前进位
        }

    }

    /**
     *  字符串加1
     * @param str
     * @return
     */
    public static String plusOne(String str){
        // 递归加一，从末尾开始(最后一个字符)
        StringBuilder builder = new StringBuilder(str);
        if (addOneRecursive(builder,str.length()-1)){
            //说明最高位也要加1
            builder.insert(0,'1');
        }
        return builder.toString();
    }

    /**
     *  对StringBuilder 中的第 index 位加一
     * @param str
     * @param index
     * @return
     */
    private static boolean addOneRecursive(StringBuilder str,int index){
        if (index < 0){
            return true; // 最高位需要进位
        }

        char c = str.charAt(index);
        if (c == '9'){
            str.setCharAt(index,'0');// 变为0, 进位
            return addOneRecursive(str,index-1); // 继续处理前一位
        }else {
            str.setCharAt(index, (char) (c+1));
            return false; //不需要进位
        }
    }
}
