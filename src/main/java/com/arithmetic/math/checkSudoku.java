package com.arithmetic.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Check if the n*n list satisfies Sudoku
 *  The rules of Sudoku:
 *    1.The numbers in each row cannot be repeated
 *    2.The numbers in each column cannot be repeated
 *  检查 n*n list 是不是满足数独
 */
public class checkSudoku {
    public static void main(String[] args) {
        // 合法的数独
        int[][] sudoku = {
                {1,2,3},
                {3,1,2},
                {2,3,1}
        };
        // 不合法的数独
        int[][] invalid_sudoku = {
                {1,2,3},
                {1,3,2},
                {2,3,1}
        };

        int[][] null_sudoku = {
                {},
                {},
                {}
        };

        System.out.println(null_sudoku.length);
        System.out.println(null_sudoku[0].length);
        System.out.println(checkSudokuMethod(sudoku));
        System.out.println(checkSudokuMethod(invalid_sudoku));
    }



    public static boolean checkSudokuMethod(int[][] sudoku){
        if (sudoku.length == 0){
            return false;
        }

        for (int[] ints : sudoku) {
            if (ints.length == 0) {
                return false;
            }

            if (ints.length != sudoku.length){
                return false;
            }
        }

        // 先检查每一行
        for (int row=0; row<sudoku.length; row++){
            List<Integer> numberList = new ArrayList<>();
            for (int k= sudoku.length; k > 0; k--){
                numberList.add(k);
            }

            for (int column=0; column<sudoku[row].length; column++){
                if (!numberList.contains(sudoku[row][column])){
                    return false;
                }
                numberList.remove(Integer.valueOf(sudoku[row][column]));
            }
        }

        // 检查每一列
        for (int column=0; column < sudoku.length; column++){
            List<Integer> numberList = new ArrayList<>();
            for (int k= sudoku.length; k > 0; k--){
                numberList.add(k);
            }

            for (int row=0; row < sudoku[column].length; row++){
                if (!numberList.contains(sudoku[row][column])){
                    return false;
                }
                numberList.remove(Integer.valueOf(sudoku[row][column]));
            }
        }

        return true;
    }

}
