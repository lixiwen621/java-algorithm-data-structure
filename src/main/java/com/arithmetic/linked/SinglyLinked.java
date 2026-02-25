package com.arithmetic.linked;

import java.util.NoSuchElementException;

/**
 *  单向链表
 */
public class SinglyLinked<E> {

    public static void main(String[] args) {
        SinglyLinked<String> list = new SinglyLinked<>();
        list.linkLast("a");
        list.linkLast("b");
        list.linkLast("c");
        list.linkLast("d");
        list.linkLast("e");
        list.linkLast("f");
        list.linkLast("0");
        System.out.println(list);
        String removedFirst = list.removeFirst();
        System.out.println(removedFirst);
        System.out.println(list);


    }

    private Node<E> first;
    // 尾部节点，用于快速添加元素到尾部
    private Node<E> last;
    int size;


    private static class Node<E>{
        E item;
        Node<E> next;

        Node(E element, Node<E> next){
            this.item = element;
            this.next = next;
        }
    }

    /**
     *  从头部插入元素
     * @param e
     */
    public void linkFirst(E e){
        final Node<E> head = first;
        final Node<E> newNode = new Node<>(e,head);
        if (last == null){
            last = newNode;
        }
        first = newNode;
        size++;
    }

    /**
     *  从尾部插入元素
     * @param e
     */
    public void linkLast(E e){
        final Node<E> newNode = new Node<>(e,null);
        if (first == null){
            first = newNode;
            last = newNode;
        }else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    /**
     *  从头节点开始删除元素
     * @return
     */
    public E removeFirst(){
        final Node<E> f = first;
        if (f == null){
            throw new NoSuchElementException();
        }

        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (first == null){
            last = null;
        }
        size--;
        return element;
    }

    /**
     *  从尾部开始删除元素
     * @return
     */
    public E removeLast(){
        final Node<E> l = last;
        if (l == null){
            throw new NoSuchElementException();
        }

        final E element = l.item;
        if (first == last){
            first = null;
            last = null;
        }else {
            // 找到 last的上一个节点
            Node<E> prev = first;
            while (prev.next != last){
                prev = prev.next;
            }
            prev.next = null;
            l.item = null; // help GC
            last = prev;
        }
        size--;
        return element;
    }

    /**
     *  删除元素
     * @param element
     */
    public void remove(E element){


    }


    private void checkElementIndex(int index){
        if (!isElementIndex(index)){
            throw new IndexOutOfBoundsException("Index: "+ index + ", Size: "+size);
        }
    }

    private boolean isElementIndex(int index){
        return index >= 0 && index < size;
    }

    private Node<E> getNodeByIndex(int index){
        // 确保index 已经校验合法
        // 从first 开始
        Node<E> x = first;
        for (int i=0; i<index; i++){
            x = x.next;
        }
        return x;
    }

    private E unlink(Node<E> prev, Node<E> x){
        final E element = x.item;
        final Node<E> next = x.next;
        if (prev == null){
            first = next;
        }else {
            prev.next = next;
        }
        x.item = null;
        x.next = null; // help GC
        size--;
        return element;
    }

    public E getLast(){
        final Node<E> l = last;
        if (l == null){
            return null;
        }
        return l.item;
    }

    public void clear(){
        Node<E> f = first;
        while (f != null){
            Node<E> next = f.next;
            f.item = null;
            f.next = null;
            f = next;
        }
        first = null;
        last = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    @Override
    public String toString() {
        Node<E> head = first;
        if (head == null){
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head != null){
            sb.append(head.item);
            if (head.next != null){
                sb.append(", ");
            }
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
