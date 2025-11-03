package com.arithmetic.string;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StringSourceTest {

    /**
     *  返回某个字符或子字符串首次出现的索引
     */
    @Test
    public void indexOf(){
        String a = "hello";
        System.out.println(a.indexOf("e"));
        // 也可以通过 字符的 ASCII值 来查找, e的 ASCII值是 101
        System.out.println(a.indexOf(101));
    }

    /**
     *  用于在字符串中每一行添加或删除缩进空格, 非常适合处理多行字符串
     */
    @Test
    public void indent(){
        String a = "hello";
        System.out.println(a.indent(2));
        // 也可以处理多行 加空格
        String text = "Hello\nWorlds";
        System.out.println(text.indent(2));
    }

    /**
     *  返回当前索引的 字符
     */
    @Test
    public void charAt(){
        String a = "hello";
        char c = a.charAt(0);
        System.out.println(c);
    }
}
