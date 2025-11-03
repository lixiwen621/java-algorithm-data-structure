package com.arithmetic.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  深度反转
 *      Deep Reverse 是对一个嵌套列表（或嵌套结构）进行完全反转的操作，既包括
 *      1. 最外层列表的顺序反转
 *      2. 每一个 子列表也要递归反转
 */
public class DeepReverse {
    /**
     *  把 [1, [2, 3], [4, [5, 6]]]
     *  反转成 [[[6, 5], 4], [3, 2], 1]
     * @param args
     */
    public static void main(String[] args) {
        List<Object> input = Arrays.asList(
                1,
                Arrays.asList(2,3),
                Arrays.asList(4,Arrays.asList(5,6))
        );

        List<Object> objectList = deepReverse(input);
        System.out.println(objectList);
    }

    public static List<Object> deepReverse(List<Object> list){
        List<Object> reversed = new ArrayList<>();

        // 先对每个元素递归处理(如果是 List)
        for (int i=list.size()-1; i>=0; i--){
            Object item = list.get(i);
            if (item instanceof List){
                // 递归处理子列表
                reversed.add(deepReverse((List<Object>) item));
            }else {
                // 原子元素直接加入
                reversed.add(item);
            }
        }
        return reversed;
    }
}
