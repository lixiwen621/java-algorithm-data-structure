package com.arithmetic.stack;

public class CustomStackByLinked<E> {
    private Node<E> head;
    private int size;

    private static class Node<E>{
        private E element;
        private Node<E> next;

        Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }
    }

    public void push(E item){
        final Node<E> newData = new Node<>(item,null);
        if (head == null){
            head = newData;
        }else {
            // 请注意基于链表的Stack, 每次插入元素是放在最前面，也就是从前面插入
            newData.next = head;
            head = newData;
        }
        size++;
    }

    public E pop(){
        if (isEmpty()){
            return null;
        }
        Node<E> current = head;
        head = head.next;
        E element = current.element;
        current = null; // help GC
        size--;
        return element;
    }

    /**
     * 反转链表（标准实现）
     */
    public void reverse(){
        Node<E> prev = null;
        Node<E> current = head;
        Node<E> next = null;

        while (current != null){
            next = current.next; // 1. 先保存next
            current.next = prev; // 2. current的next指向prev
            prev = current; // 3. 更新prev
            current = next; // 4. current 下移

        }

        head = prev; // 更新 head
    }

    // 打印链表
    public void print(){
        Node<E> current = head;
        StringBuilder builder = new StringBuilder();
        while (current != null){
            builder.append(current.element);
            current = current.next;
            if (current != null){
                builder.append("->");
            }
        }
        System.out.println(builder);
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public static void main(String[] args) {
        CustomStackByLinked stackByLinked = new CustomStackByLinked();
        stackByLinked.push(10);
        stackByLinked.push(20);
        stackByLinked.push(30);
        stackByLinked.push(40);
        stackByLinked.push(50);

        stackByLinked.reverse();
        stackByLinked.print();
    }
}
