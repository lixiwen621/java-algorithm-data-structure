package com.arithmetic.array;

import java.util.Arrays;

/**
 *  帕斯卡三角形
 *  Pascal's Triangle 是一种经典的数学结构，它是一个以三角形形式排列的数字集合，每一行中的数字由上一行的数字通过特定的规则计算得出
 * Row 0:        1
 * Row 1:       1   1
 * Row 2:      1   2   1
 * Row 3:     1   3   3   1
 * Row 4:    1   4   6   4   1
 * Row 5:   1   5  10  10   5   1
 *
 * C(n,k)=C(n−1,k−1)+C(n−1,k), 其中n表示行号 k为列  C(4,2)=C(3,1) + C(3,2)   如上图
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        int[] current = generatePascalsTriangle(4);
        System.out.println(Arrays.toString(current));
    }

    /**
     *
     * @param n n为行号
     * @return
     */
    public static int[] generatePascalsTriangle(int n){
        int[] first = {1};
        int[] previous = {1,1};
        if (n == 0)
            return first;
        if (n == 1)
            return previous;
        // current为当前行的数组,previous为上一行的数组
        int[] current = null;
        for (int i=2; i <= n; i++){
            current = new int[i+1];
            current[0] = 1;
            current[i] = 1;
            for (int j=1; j < i; j++){
                current[j] = previous[j-1] + previous[j];
            }
            // 修改prev
            previous = current;
        }
        return current;
    }
}
