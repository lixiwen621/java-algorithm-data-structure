package com.arithmetic.stack;

public class CustomStackByArray<E> {
    private int initialSize;
    private Object[] initialArray;
    private int size=0;
    private int nextIndex = 0;

    public CustomStackByArray(){
        this(10);
    }

    public CustomStackByArray(int initialSize){
        this.initialSize = initialSize;
        initialArray = new Object[initialSize];
    }


    public synchronized E push(E item){
        // 判断是否扩容
        if (nextIndex == initialArray.length){
            // 扩容为原数组的2倍
            resizeStorage(initialArray.length * 2);
        }
        initialArray[nextIndex] = item;
        size++;
        nextIndex++;
        return item;
    }

    /**
     * 查看栈顶元素（不出栈）
     * @return
     */
    public synchronized E peek(){
        if (isEmpty()){
            return null;
        }
        return (E) initialArray[nextIndex - 1];
    }

    public synchronized E pop(){
        if (isEmpty()){
            return null;
        }
        size--;
        nextIndex--;
        E item = (E) initialArray[nextIndex];
        // 还要移除元素 help gc
        initialArray[nextIndex] = null;
        return item;
    }


    /**
     *  扩容的方法
     * @param newCapacity
     */
    private void resizeStorage(int newCapacity){
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(initialArray,0, newArray,0, size);
        initialArray = newArray;
    }

    public synchronized int size(){
        return this.size;
    }


    public boolean isEmpty(){
        return this.size == 0;
    }


    public static void main(String[] args) {
        CustomStackByArray stack = new CustomStackByArray();
        stack.push(1);
        stack.push("lixiwen");
        stack.push("5");
        stack.push(10);
        stack.push("lixin");

        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());
    }
}
