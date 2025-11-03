package com.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *  Z字形变换
 *
 *  比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *      P   A   H   N
 *      A P L S I I G
 *      Y   I   R
 *
 *  之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *  请你实现这个将字符串进行指定行数变换的函数：
 *      string convert(string s, int numRows);
 */
public class ZigzagTransformation {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING"; int numRows = 3;
        String convert = convert(s, numRows);
        System.out.println(convert);
    }

    public static String convert(String s, int numRows){
        // 如果只有一行, Z形不成立
        if (numRows == 1 || s.length() <= numRows) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i=0; i<numRows; i++){
            rows.add(new StringBuilder());
        }
        // 当前字符应放在哪一行
        int currentRow=0;
        // 表示当前移动方向
        boolean goingDown=false;
        for (char c : s.toCharArray()){
            rows.get(currentRow).append(c);
            //方向反转
            if (currentRow == 0 || currentRow == numRows-1){
                goingDown = ! goingDown;
            }
            currentRow += goingDown?1:-1;

        }
        // 拼接结果
        StringBuilder result = new StringBuilder();
        for (StringBuilder row:rows){
            result.append(row);
        }

        return result.toString();
    }
}
