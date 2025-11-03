package com.arithmetic.stack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Stack;

@ExtendWith(MockitoExtension.class)
public class StackSourceTest {

    @Test
    public void coreTest(){
        Stack<String> stack = new Stack<>();
        // push 方法是压栈
        stack.push("apple");
        stack.push("banana");
        stack.push("son");
        // pop 方法是 移除并返回顶点的元素
        stack.pop();
        System.out.println(stack);
        // peek 查看栈顶元素，但不移除
        System.out.println(stack.peek());
        // search(Object o) 返回元素距离栈顶的位置, 最顶点的为1
        System.out.println(stack.search("apple"));
    }

    @Test
    public void test(){
        Stack<String> stack = new Stack<>();
        stack.push("apple");
        stack.push("banana");
        // 获取元素大小
        System.out.println(stack.size());
        // 获取指定索引的元素，0 就是最下面的
        System.out.println(stack.get(0));
        // 使用add(0,"xiwen") 带索引的添加会破坏栈的数据结构
        stack.add(0,"xiwen");
        System.out.println(stack.peek());
        System.out.println(stack);
    }
}
