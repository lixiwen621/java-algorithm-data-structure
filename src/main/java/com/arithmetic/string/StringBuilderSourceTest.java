package com.arithmetic.string;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StringBuilderSourceTest {

    /**
     *  追加字符串到Builder中
     */
    @Test
    public void append(){
        StringBuilder builder = new StringBuilder();
        builder.append("hello");
        builder.append(" ");
        builder.append("worlds");
        System.out.println(builder);
    }

    /**
     *  在指定位置插入 字符
     */
    @Test
    public void insert(){
        StringBuilder builder = new StringBuilder("hello");
        builder.insert(5," Java");
        System.out.println(builder);
    }

    @Test
    public void setCharAt(){
        StringBuilder builder = new StringBuilder("hello");
        builder.setCharAt(0,'j');
        System.out.println(builder);
    }
}
