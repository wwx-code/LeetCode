package com.wwxyh.March;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 杨辉三角
 * @Author: wwx
 * @Date: 2021/6/2 21:41
 */
public class subject118 {
    
    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     *
     * 输入: 5
     * 输出:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     **/
    
    
    public static List<int[]> yhTriangle(int num){
        /**
         * [
         *      [1],
         *     [1,1],
         *    [1,2,1]
         *  ]
         **/
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            //生成数组，初始容量大小 为当前i+1
            int[] arr = new int[i+1];
            for (int j = 0; j <= i; j++) {
                //数组第一个元素和最后一个元素为1
                if (j == 0 || i == j){
                    arr[j] = 1;
                }else {
                    // arr[i][j] = arr[i-1][j-1] + arr[i-1][j]
                    int curr = list.get(i - 1)[j-1] + list.get(i-1)[j];
                    arr[j] = curr;
                }
            }
            list.add(arr);
        }
        return list;
    }

    //官方
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rest = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j){
                    row.add(1);
                }else {
                    row.add(rest.get(i-1).get(j-1) + rest.get(i-1).get(j));
                }
            }
            rest.add(row);
        }
        return rest;
    }

    public static void main(String[] args) {
        List<int[]> list = yhTriangle(1);
        for (int[] ints : list) {
            String s = Arrays.toString(ints);
            System.out.println(s);
        }
    }
}
