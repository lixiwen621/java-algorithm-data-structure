package com.arithmetic.queue;

/**
 *  基于数组实现的Queue
 */
public class ArrayQueue<E> {
    private Object[] arr;
    // 指向队首的元素索引
    private int front;
    // 指向下一个可以插入元素的索引
    private int rear;
    // 当前队列元素个数
    private int size;
    private int capacity;

    public ArrayQueue(int capacity){
        this.capacity = capacity;
        arr = new Object[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    /**
     *  入队操作
     * @param item
     */
    public void enqueue(E item){
        if (isFull()){
            throw new IllegalStateException("Queue is full");
        }

        arr[rear]=item;
        rear=(rear+1)%capacity;
        size++;
    }

    // 出队操作
    public E dequeue(){
        if (isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }

        E value = (E) arr[front];
        front = (front+1)%capacity;
        size--;
        return value;
    }

    // 查看队首元素
    public E peek(){
        if (isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        return (E) arr[front];
    }

    public void print(){
        StringBuilder builder = new StringBuilder();
        builder.append("Queue: ");
        for (int i=0; i<size; i++){
            builder.append(arr[(front+i)%capacity]+ " ");
        }
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.print();

        Integer dequeue = queue.dequeue();
        System.out.println(dequeue);
        queue.print();
    }
}
