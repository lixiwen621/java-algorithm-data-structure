package com.arithmetic.string;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CharSourceTest {

    /**
     *  字符之间的计算
     *  数字是在 0< num < 9, 就可以 这样计算
     */
    @Test
    public void test(){
        char c = '8';
        char c1 = (char) (c + 1);
        System.out.println(c1);
    }

    @Test
    public void test2(){
        char c = '5';
        int num = c - '0';
        System.out.println(num);
    }

    @Test
    public void test3(){
        int num = 7;
        char c = (char) (num + '0');
        System.out.println(c);
    }
}
