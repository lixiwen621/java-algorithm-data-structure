package com.arithmetic.linked;

public class DoublyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E element, Node<E> next){
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }

    /**
     *  添加元素
     * @param element
     * @return
     */
    public boolean add(E element){
        addLast(element);
        return true;
    }

    void addLast(E element){
        final Node<E> newData = new Node<>(null,element,null);

        if(head == null && tail == null){
            head = tail = newData;
        }else {
            tail.next = newData;
            newData.prev = tail;
            tail = newData;
        }
        size ++;
    }

    void addFirst(E element){
        final Node<E> newData = new Node<>(null,element,null);

        if (head == null && tail == null){
            head = tail = newData;
        }else {
            head.prev = newData;
            newData.next = head;
            head = newData;
        }
        size ++;
    }

    /**
     * 根据 element 返回指定元素的 索引值
     * @param o
     * @return
     */
    public int indexOf(Object o){
        int index=0;
        if (o == null){
            for (Node<E> x=head; x != null; x=x.next){
                if (x.element == null){
                    return index;
                }
                index++;
            }
        }else {
            for (Node<E> x=head; x != null; x=x.next){
                if (x.element.equals(o)){
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    /**
     * 返回指定索引处的非空节点
     * @param index
     * @return
     */
    public Node<E> node(int index){
        checkElementIndex(index);
        // size >> 1 相当于 size / 2
        if (index < (size >> 1)){
            Node<E> x = head;
            for (int i=0; i < index; i++)
                x = x.next;
            return x;
        }else {
            Node<E> x = tail;
            for (int i = size-1; i > index; i--)
                x = x.prev;

            return x;
        }
    }

    private void checkElementIndex(int index){
        if (index >= size || index < 0){
            throw new ArrayIndexOutOfBoundsException("index不合法, 超出指定范围");
        }
    }


    public int size(){
        return size;
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
