package com.arithmetic.linked;

/**
 *  单向链表
 */
public class SinglyLinked<E> {
    private Node<E> head;
    int size;


    private static class Node<E>{
        E element;
        Node<E> next;

        Node(Node<E> next, E element){
            this.element = element;
            this.next = next;
        }
    }

    /**
     * 添加元素到节点尾部
     * @param element
     */
    public void append(E element){
        final Node<E> newNode = new Node<>(null,element);
        if (this.head == null){
            this.head = newNode;
        }else {
            Node<E> lastNode = this.head;
            while (lastNode.next != null){
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
        this.size ++;
    }

    /**
     *  在链表头节点添加数据
     * @param element
     */
    public void appendFirst(E element){
        final Node<E> newNode = new Node<>(null,element);
        newNode.next = this.head;
        this.head = newNode;
        size++;
    }

    /**
     *  删除元素
     * @param element
     */
    public void remove(E element){
        Node<E> current = this.head;

        // 如果删除的是头节点
        if (current != null && current.element.equals(element)){
            this.head = current.next;
            current = null; // help GC
            return;
        }
        // 查找要删除的节点，并保持对前一个节点的引用
        Node<E> prev = null;
        while (current != null && !current.element.equals(element)){
            prev = current;
            current = current.next;
        }

        // 如果未找到要删除的节点
        if (current == null)
            return;

        prev.next = current.next;
        current = null; // help GC
        size--;

    }
    /**
     *  根据索引获取Node
     * @param index
     * @return
     */
    public E get(int index){
        checkElementIndex(index);
        Node<E> x = this.head;
        for (int i=0; i < index; i++){
            x = x.next;
        }
        return x.element;
    }



    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("index越界");
    }

    private void unlink(Node<E> x){
        final E element = x.element;
        final Node<E> next = x.next;


    }

    public Object[] toArray(){
        Object[] result = new Object[size];
        Node<E> current = this.head;
        int i=0;
        while (current != null){
            result[i] = current.element;
            current = current.next;
            i++;
        }
        return result;
    }

    @Override
    public String toString() {
        Node<E> current = head;
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        while (current != null){
            builder.append(current.element);
            current = current.next;
            if (current == null)
                return builder.append("]").toString();

            builder.append(", ");
        }
        return builder.append("]").toString();
    }
}
