package com.arithmetic.sort;

import java.util.Arrays;

/**
 *  归并排序
 *  归并排序（Merge Sort）是一种 分治法（Divide and Conquer） 思想的经典排序算法。
 *  它将一个大问题分解成小问题，分别解决后再合并结果
 *      例如：
 *      先分解步骤
 *      [5, 2, 4, 7, 1, 3, 6, 8]
 *      => [5, 2, 4, 7] 和 [1, 3, 6, 8]
 *      => [5, 2] 和 [4, 7]，    [1, 3] 和 [6, 8]
 *      => [5], [2], [4], [7], [1], [3], [6], [8]
 *      合并过程
 *      => [2, 5], [4, 7], [1, 3], [6, 8]
 *      => [2, 4, 5, 7], [1, 3, 6, 8]
 *      => [1, 2, 3, 4, 5, 6, 7, 8]
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {5,2,4,7,1,3,6,8};
        mergeSort(nums,0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     *  先分解, 这样的方式分解 left -> mid, mid -> right
     * @param arr
     * @param left
     * @param right
     */
    public static void mergeSort(int[] arr, int left, int right){
        if (left >= right) return;

        int mid = left + (right - left)/2;

        // 左边的分解, left -> mid
        mergeSort(arr,left,mid);
        // 右边的分解, mid -> right
        mergeSort(arr,mid+1,right);
        // 合并
        merge(arr,left,mid,right);

    }

    /**
     *  合并
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    private static void merge(int[] arr, int left, int mid, int right){
        int[] temp = new int[right-left+1];
        int i=left, j=mid+1, k=0;

        while (i <= mid && j <= right){
            if (arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p=0; p<temp.length; p++){
            arr[left+p] = temp[p];
        }

    }
}
