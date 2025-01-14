package com.arithmetic.math;

/**
 *  阶乘的算法
 *  5! = 1 * 2 * 3 * 4 * 5
 */
public class Factorial {

    private static int prod(int a, int b){
        return a * b;
    }

    private static int computeFactorial(int num){
        int i = 1;
        int n = i;
        while (num >= 1){
            n = prod(i,n);
            i += 1;
            num --;
        }
        return n;
    }

    public static void main(String[] args) {
        int factorial = computeFactorial(5);
        System.out.println(factorial);
    }
}
