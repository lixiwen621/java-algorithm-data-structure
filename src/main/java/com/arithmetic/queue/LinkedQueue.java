package com.arithmetic.queue;

import com.arithmetic.linked.MergeTwoLinkedLists;

/**
 *  基于链表实现的 queue
 * @param <T>
 */
public class LinkedQueue<T> {

    // 队头
    private Node<T> head;
    // 队首
    private Node<T> tail;
    private int size;

    public LinkedQueue(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // 入队, 尾部添加数据
    public void offer(T item){
        Node<T> newData = new Node<>(item);
        if (tail == null){
            // 队列为空时，头和尾都指向新节点
            head = tail = newData;
        }else {
            tail.next = newData;
            tail = newData;
        }
        size++;
    }

    // 出队, 从头部移除元素
    public T poll(){
        if (head == null){
            return null;
        }
        Node<T> current = head;
        T data = current.data;
        current = null; // help GC
        head = head.next;
        if (head == null){
            tail = null;
        }
        size--;
        return data;
    }

    // 查看对头元素(不移除)
    public T peek(){
        if (head == null){
            return null;
        }

        return head.data;
    }

    public boolean isEmpty(){
        return head == null;
    }

    // 队列长度
    public int size(){
        return size;
    }
    private static class Node<T>{
        T data;
        Node<T> next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    private  void print(){
        Node node = head;
        StringBuilder builder = new StringBuilder();
        while (node != null){
            builder.append(node.data);
            if (node.next != null){
                builder.append("->");
            }
            node = node.next;
        }
        System.out.println(builder);
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);
        queue.print();
        Integer poll = queue.poll();
        System.out.println(poll);
        queue.print();

    }
}
