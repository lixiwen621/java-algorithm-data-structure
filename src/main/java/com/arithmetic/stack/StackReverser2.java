package com.arithmetic.stack;

import java.util.Stack;

/**
 *  反转Stack
 *  这里主要通过 原地反转法 O(1) 空间消耗 来进行
 */
public class StackReverser2 {
    public static void main(String[] args) {
        CustomStackByLinked<Integer> stack = new CustomStackByLinked<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.print();
        reverse4(stack);
        stack.print();

        Stack<Integer> stack1 = new Stack<>();
        stack1.push(10);
        stack1.push(20);
        stack1.push(30);
        stack1.push(40);
        System.out.println(stack1);
        reverse5(stack1);
        System.out.println(stack1);
    }

    /**
     * 原地反转法 O(1) 空间消耗
     * 通过链表实现的Stack里的reverse()方法
     * @param stack
     */
    public static void reverse4(CustomStackByLinked<Integer> stack){
        stack.reverse();
    }

    /**
     * 原地反转法 O(1) 空间消耗
     * 通过数组实现的栈 来完成
     * @param stack
     */
    public static void reverse5(Stack<Integer> stack){
        Object[] arr = stack.toArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right){
            int temp = (int) arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        stack.clear();
        for (int i=0; i< arr.length; i++){
            stack.push((int) arr[i]);
        }
    }
}
