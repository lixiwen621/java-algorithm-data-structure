package com.arithmetic.recursion;

/**
 *  最后一次出现的位置
 *      什么是last index问题
 *      给定一个整数数组arr[] 和一个目标值 x, 找出x在数组中最后一次出现 的索引位置
 *
 */
public class LastIndex {
    public static void main(String[] args) {
        int[] arr = {9,8,10,8}; int x = 8;
        System.out.println("Last index of "+x+": "+lastIndex(arr,x));
    }

    /**
     *  通过递归来实现
     * @param arr
     * @param x
     * @return
     */
    public static int lastIndex(int[] arr, int x){
        return helper(arr,x,0);
    }

    private static int helper(int[] arr,int x,int index){
        // base case: 已经遍历完整个数组
        if (index == arr.length){
            return -1;
        }

        // 递归向后查找
        int res = helper(arr,x,index+1);

        // 如果在后面找到了, 就返回后面的索引
        if (res != -1){
            return res;
        }

        // 否则检查当前元素
        if (arr[index] == x){
            return index;
        }

        //没找到
        return -1;
    }
}
