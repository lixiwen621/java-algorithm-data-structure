package com.arithmetic.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 最少括号反转(Minimum Bracket Reversals)
 *  输入: "}{{}}{{{"
 *      输出: 3
 *
 *  解释：
 *      step1: 反转第一个 `}` → `{`，变为：`{{{{}{{{`
 *      step2: 反转最后两个 `{` → `}`, 变为：`{{{}}{{}}`（有效）
 *      共 3 次反转。
 */
public class MinimumBracketReversals {
    public static void main(String[] args) {
        String expr1 = "}{{}}{{{";
        System.out.println("表达式: " + expr1);
        System.out.println("最小翻转次数: " + countMinReversals(expr1)); // 输出 3

        String expr2 = "{{{{";
        System.out.println("表达式: " + expr2);
        System.out.println("最小翻转次数: " + countMinReversals(expr2)); // 输出 2
    }

    /**
     *  算法思路
     *    1.长度为奇数 → 不可能平衡，直接返回 -1。
     *    2.使用栈处理括号：
     *      - 遇到 左边扩话 → 入栈；
     *      - 遇到 右边括号
     *          - 如果栈顶是左边相应括号 匹配成功，出栈
     *          - 否则(多余的 右边括号) -> 入栈
     *    3.最后栈中留下的要么是全 {，要么是全 }，或者交替。
     *      - 假设有 m 个 { 和 n 个 }，则最少翻转次数为：
     *      (m + 1) / 2 + (n + 1) / 2
     * @param expr
     * @return
     */
    public static int countMinReversals(String expr){
        int len = expr.length();
        // 如果长度是奇数, 肯定无法平衡
        if (len % 2 != 0){
            return -1;
        }

        // 先用map 存储各个符号
        Map<Character,Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');

        Stack<Character> stack = new Stack<>();
        // 遇到 左边扩话 → 入栈；
        // 遇到 右边括号
        //  - 如果栈顶是左边相应括号 匹配成功，出栈
        //  - 否则(多余的 右边括号) -> 入栈
        for (char c : expr.toCharArray()){
            if (brackets.containsValue(c)){
                stack.push(c);
            } else if (brackets.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == brackets.get(c)){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
        }

        //反转次数的表达式 (m + 1) / 2 + (n + 1) / 2
        int unmatched = stack.size();
        int openBraces = 0;
        //统计有多少个左边的和右边的括号
        while (!stack.isEmpty()){
            if (brackets.containsValue(stack.pop())){
                openBraces++;
            }
        }

        int closeBraces = unmatched - openBraces;
        return (openBraces + 1)/2 + (closeBraces + 1)/2;
    }
}
