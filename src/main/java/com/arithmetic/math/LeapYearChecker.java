package com.arithmetic.math;

public class LeapYearChecker {
    public static void main(String[] args) {
        boolean leapYear = isLeapYear(2025);
        System.out.println(leapYear);
    }

    /**
     *  判断是否闰年
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year){
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            return true;
        }
        return false;
    }
}
