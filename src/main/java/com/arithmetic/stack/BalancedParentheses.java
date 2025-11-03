package com.arithmetic.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * 平衡括号（Balanced Parentheses）** 是栈（Stack）数据结构的经典应用场景，用于验证一个字符串中的括号是否按正确的顺序闭合
 *  给定一个仅包含括号字符（如 ()[]{}）的字符串，判断括号是否满足以下条件：
 * 1.每个左括号必须对应一个同类型的右括号
 * 2.左右括号的闭合顺序必须正确
 * 3.不允许存在未闭合的括号
 * **示例**：
 * - ✅ 有效："([]){}"，"({[]})"
 * - ❌ 无效："([)]"，"(()"，"}{"
 *
 * **核心思想**：利用栈的 **后进先出（LIFO）** 特性匹配最近的括号对。
 * **操作流程**：
 * 1.**遍历字符串**的每个字符
 * 2.**遇到左括号**时，将其压入栈
 * 3.**遇到右括号**时：
 * - 若栈为空 → 无效（没有对应的左括号）
 * - 弹出栈顶元素 → 检查是否与当前右括号匹配
 * 4.**最终检查栈是否为空** → 确保没有多余的左括号
 */
public class BalancedParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("([]){}"));
        System.out.println(isValid("({[]})"));

        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String s){
        CustomStackByLinked<Character> stack = new CustomStackByLinked<>();
        // 先用map 存储各个符号
        Map<Character,Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');

        for (Character chat: s.toCharArray()){
            // 如果是左边的字符就 push, 如果是右边的字符就pop
            if (brackets.containsValue(chat)){
                stack.push(chat);
            }else if (brackets.containsKey(chat)){
                if ( stack.isEmpty() ||stack.pop() != brackets.get(chat)){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
