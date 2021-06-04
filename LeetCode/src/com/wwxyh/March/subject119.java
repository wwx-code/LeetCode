package com.wwxyh.March;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 杨辉三角||
 * @Author: wwx
 * @Date: 2021/6/4 21:32
 */
public class subject119 {

    /**
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     *
     * 输入: 3
     * 输出: [1,3,3,1]
     **/

    public static List<Integer> generate(int numRows) {
        List<List<Integer>> rest = new ArrayList<>();
        for (int i = 0; i <= numRows; i++) {
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
        List<Integer> list = rest.get(numRows);
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = generate(3);
        System.out.println(list);
    }
}
