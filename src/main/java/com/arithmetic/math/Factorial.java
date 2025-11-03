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
        int n = 1;
        while (num > 1){
            n *= prod(num,num-1);
            num = num-2;
        }
        return n;
    }

    public static void main(String[] args) {
        int factorial = computeFactorial(6);
        System.out.println(factorial);
    }
}
