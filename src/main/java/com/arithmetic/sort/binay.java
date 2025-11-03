package com.arithmetic.sort;

/**
 * @Title: binay  二分法查找
 * @Description:
 * @Auther: lixiwen
 * @Version: 1.0
 * @create 2020/9/27 22:33
 */
public class binay {
    public static void main(String[] args) {
        int[] nums = {1,6,15,18,27,50};
        System.out.println(nums.length);
        int findValue = 27;
        // 为什么start从0开始，因为下标从0开始计算的
        int binayResult = binaySearch(nums, 0, nums.length - 1, 27);
        System.out.println(binayResult);
    }

    public static int binaySearch(int[] nums,int start, int end,int findValue){
        if (start <= end){
            //中间位置
            int middle = start + (end - start)/2;
            //中间位置的值
            int middleValue = nums[middle];
            if (findValue == middleValue){
                return middle;
            }else if (findValue < middleValue){
                return binaySearch(nums,start,middle-1,findValue);
            }else {
                return binaySearch(nums,middle+1,end,findValue);
            }
        }
        return -1;
    }
}
