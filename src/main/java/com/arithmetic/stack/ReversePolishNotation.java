package com.arithmetic.stack;

import java.util.Stack;

/**
 *  逆波兰表示法
 *  例如：中缀表达式 (3+4)*5, 逆波兰式：3 4 + 5 *
 *  从左到右扫描表达式
 *    1. 遇到操作数 -》入栈
 *    2. 遇到运算符 -》弹出栈顶2个元素进行运算 -》结果入栈
 *    3. 最终栈中唯一元素即为计算结果
 */
public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] rpn1 = {"2","1","+","3","*"};
        System.out.println(evalRPN(rpn1));
    }

    public static int evalRPN(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens){
            if (isOperator(token)){
                int element1 = stack.pop();
                int element2 = stack.pop();
                int calculate = calculate(element1,element2, token);
                stack.push(calculate);
            }else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("*")
                || s.equals("/");
    }

    private static int calculate(int a, int b, String op){
        switch (op) {
            case "+": return a+b;
            case "-": return a-b;
            case "*": return a*b;
            case "/": return a/b;
            default:throw new IllegalArgumentException();
        }
    }
}
