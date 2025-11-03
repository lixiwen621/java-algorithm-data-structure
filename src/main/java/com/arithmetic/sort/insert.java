package com.arithmetic.sort;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *  插入排序：核心思想就是把数组分为已排序和未排序
 *   用未排序部分 跟 已排序部分进行比较
 *
 */
public class insert {
    public static void main(String[] args) {
        int[] nums = {18,1,6,27,15};
        insertSort(nums);
        System.out.println("排序好为: "+Arrays.toString(nums));
    }

    /**
     *  插入排序
     */
    public static void insertSort(int[] nums){
        // temp作为临时存储 已排序的变量值
        int temp;
        // 我们从数组下标1开始, 假如下标1 之前的是已排序，下标1之后的是未排序
        for (int i=1; i< nums.length; i++){
            //i 指的是未排序的部分, j指的是已排序的部分, temp临时存储 nums[i]
            int j=i-1;
            temp = nums[i];
            // while中就是, i 跟 j中所有已排序的部分进行比较, 找出所有比i大的数进行右移
            // 因为 i是从第二数开始比较的, 所以每次比较好排序, 已排序的部分都是ok的
            while (j >= 0 && temp < nums[j]){
                nums[j+1] = nums[j];
                j--;
            }
            // 将当前元素插入到合适的位置
            nums[j+1] = temp;
            System.out.println("第"+i+"次排序: "+ Arrays.toString(nums));
        }
    }
}
