package com.arithmetic.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 =  "[](){}]";
        String s3 =  "([])";
        boolean valid1 = isValid(s1);
        System.out.println(valid1);
        boolean valid2 = isValid(s2);
        System.out.println(valid2);
        boolean valid3 = isValid(s3);
        System.out.println(valid3);
    }

    public static boolean isValid(String s){
        Map<Character,Character> characterMap = new HashMap<>();
        characterMap.put('}','{');
        characterMap.put(']','[');
        characterMap.put(')','(');
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (characterMap.containsValue(c)){
                stack.push(c);
            }else if (characterMap.containsKey(c)){
                if (stack.isEmpty() || characterMap.get(c) != stack.pop()){
                    return false;
                }

            }
        }

        return stack.isEmpty();
    }

    /**
     *  这种简单的解决办法
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else {
                if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }

        return stack.isEmpty();
    }
}
