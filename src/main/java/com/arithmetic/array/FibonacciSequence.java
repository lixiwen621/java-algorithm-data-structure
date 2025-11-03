package com.arithmetic.array;

/**
 *  斐波那契数列
 *  Fibonacci Sequence 的定义
 *      1.数列的前两项为：
 *          F(0)=0 ,  F(1)=1
 *      2.从第三项开始，每一项等于前两项之和：
 *          F(n) = F(n−1) + F(n−2)  for n≥ 2
 *      数列的前几项：0,1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89,…
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        int fibonacciRecursive = fibonacciRecursive(10);
        System.out.println(fibonacciRecursive);
        int fibonacciDynamic = fibonacciDynamic(10);
        System.out.println(fibonacciDynamic);
    }

    /**
     *  斐波那契数列的 递归实现
     * @param n
     * @return
     */
    public static int fibonacciRecursive(int n){
        if (n <= 1){
            return n;
        }
        int i = fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        //System.out.println(i);
        return i;
    }

    /**
     *  斐波那契数列的动态实现
     * @param n
     * @return
     */
    public static int fibonacciDynamic(int n){
        if (n <= 1){
            return n;
        }
        int previous = 0;
        int latter = 1;
        int sum=0;
        for (int i=2; i<=n; i++){
            sum = previous + latter;
            previous = latter;
            latter = sum;
        }
        return sum;
    }
}
