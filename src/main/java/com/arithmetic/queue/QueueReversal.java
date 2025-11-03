package com.arithmetic.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *  反转队列
 */
public class QueueReversal {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);
        System.out.println(queue);
        reverser2(queue);
        System.out.println(queue);
    }

    /**
     * 通过 递归的方式, 求解
     * @param queue
     */
    public static void reverser(Queue<Integer> queue){
        if (queue.isEmpty()){
            return;
        }
        Integer top = queue.poll();
        reverser(queue);
        queue.offer(top);
    }

    /**
     *  通过
     * @param queue
     */
    public static void reverser2(Queue<Integer> queue){
        if (queue.isEmpty()){
            return;
        }

        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()){
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()){
            queue.add(stack.pop());
        }

    }
}
