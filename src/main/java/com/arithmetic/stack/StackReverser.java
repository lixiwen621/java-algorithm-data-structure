package com.arithmetic.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *  反转Stack
 */
public class StackReverser {
    // 测试代码
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("原始栈: " + stack);
        reverse3(stack);
        System.out.println("反转后栈: " + stack);
    }

    /**
     * 递归反转栈
     * @param stack
     */
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        // 4,3,2,1
        int top = stack.pop();                  // 取出栈顶
        reverse(stack);                         // 递归反转剩余栈
        insertAtBottom(stack, top);             // 把原栈顶插入到底部
    }

    // 递归地将元素插入到栈底
    private static void insertAtBottom(Stack<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);                  // 到底了，直接插入
            return;
        }
        //1,2,3,4
        int top = stack.pop();                  // 弹出当前栈顶
        insertAtBottom(stack, value);           // 继续深入到底部
        stack.push(top);                        // 恢复原栈结构
    }

    /**
     * 使用Stack辅助进行翻转
     */
    public static void reverse2(Stack<Integer> stack){
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()){
            tempStack.push(stack.pop());
        }
        stack.addAll(tempStack);
    }

    /**
     * 使用Queue队列进行辅助
     * @param stack
     */
    public static void reverse3(Stack<Integer> stack){
        Queue<Integer> tempQueue = new LinkedList<>();
        while (!stack.isEmpty()){
            tempQueue.offer(stack.pop()); // 出栈入队
        }
        while (!tempQueue.isEmpty()){
            stack.push(tempQueue.poll()); // 出队入栈
        }
    }

}