package com.arithmetic.recursion;

/**
 *  汉诺塔问题:
 *      给定三根柱子（A、B、C）和 n 个大小不等的圆盘，最初所有圆盘按从大到小顺序叠在柱子 A 上
 *
 */
public class TowerOfHanoi {
    public static void main(String[] args) {
        int n=3;
        solve(n,'A','C','B');
    }

    public static void solve(int n, char from, char to, char aux){
        if (n == 1){
            System.out.println("Move disk 1 from "+from+" to "+to);
            return;
        }

        solve(n-1,from,aux,to); // step 1
        System.out.println("Move disk "+n+" from "+from+" to "+to); // step2
        solve(n-1,aux,to,from);
    }
}
