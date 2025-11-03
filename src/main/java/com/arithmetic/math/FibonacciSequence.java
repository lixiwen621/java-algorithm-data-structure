package com.arithmetic.math;

/**
 * Fibonacci Sequence 是一个经典的数列，每一项的值等于前两项的和。
 * 这个数列由意大利数学家 Leonardo Fibonacci 在 1202 年提出，用于描述兔子的繁殖问题，因此得名 Fibonacci 数列。
 *
 * 1.数列的前两项为：
 * F(0)=0 ,  F(1)=1
 * 2.从第三项开始，每一项等于前两项之和：
 * F(n) = F(n−1) + F(n−2)  for n≥ 2
 *
 * 数列的前几项：0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89,…
 *
 * 这里需要得出Fibonacci Sequence数列当前项的值
 * 例如输入 10, 得到55 。 我上面的数是从0开始的, 这样方便看和找规律, 实际上第一项是1
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        System.out.println(fibonacciSequence(3));
    }

    /**
     *  n表示第几项
     *  动态规划实现 时间复杂度为 O(n) 空间复杂度 O(1)
     * @param n
     * @return
     */
    public static int fibonacciSequence(int n){
        if (n <= 1)
            return n;
        // 构建出第一项和第二项
        int first= 0; int second = 1;
        int current = 0;
        for (int i=2; i<=n; i++){
            current = first + second;
            first = second;
            second = current;
        }

        return current;
    }
}
