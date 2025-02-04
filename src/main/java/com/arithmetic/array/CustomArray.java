package com.arithmetic.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  定义一个一维数组
 */
public class CustomArray {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    private int size;
    private int arrayIndex=0;
    Object[] elementData;

    public CustomArray(int initialCapacity){
        if (initialCapacity > 0){
            this.elementData = new Object[initialCapacity];
        }else if (initialCapacity == 0){
            this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        }else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    public CustomArray(){
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }


    /**
     * 对数组末尾添加 Object类型的元素
     * @param value
     */
    public boolean append(Object value){
        append(value,elementData,size);
        return true;
    }

    private void append(Object value,Object[] elementData,int s){
        if (s == elementData.length)
            elementData = grow();
        elementData[s] = value;
        size = s + 1;
    }

    private Object[] grow(){
        return new Object[10];
    }

    /**
     *  在对应的index索引出插入Object类型的元素
     * @param index
     * @param value
     */
    public void insert(int index,Object value){
        //检查索引是否合法
        checkIndex(index);

        for (int i=elementData.length-1; i>0; i--){
            elementData[i] = elementData[i-1];
        }
        elementData[index] = value;
        size++;
    }

    /**
     *  检查索引是否合法
     * @param index
     * @return
     */
    private void checkIndex(int index){
        if (index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException("Array Index Out of Bounds");
        }
    }


    public boolean isEmpty(){
        return size == 0;
    }

    public static void printCustomArray(CustomArray array){
        Object[] elementData = array.elementData;
        System.out.println(Arrays.toString(elementData));
    }

    public static void main(String[] args) {
        CustomArray array = new CustomArray(4);
        array.append(2);
        array.append("xiwen");
        array.insert(0,"li");
        printCustomArray(array);
    }
}
