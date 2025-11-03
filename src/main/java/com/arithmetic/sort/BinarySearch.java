package com.arithmetic.sort;

public class BinarySearch {

    public static void main(String[] args) {
        // nums = [-1,0,3,5,9,12], target = 9
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int index = binarySearch(nums, target);
        System.out.println(index);
    }
    public static int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;

        while (left <= right){
            int mid = left + (right - left) / 2; // 避免溢出
            if (arr[mid] == target){
                return mid; // 找到目标
            }else if (arr[mid] < target){
                left = mid + 1; //右侧查找
            }else {
                right = mid - 1; // 左侧查找
            }

        }
        return -1;

    }
}
