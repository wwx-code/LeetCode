package com.wwxyh.March;

/**
 * @Description: 加一
 * @Author: wwx
 * @Date: 2021/5/31 19:35
 */
public class subject66 {

    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * 输入：digits = [1,2,3]
     * 输出：[1,2,4]
     *
     * 输入：digits = [9,9,9]
     * 输出：[1,0,0,0]
     **/

    public static int[] addOne(int[] arr){
        int len = arr.length;

        for (int i = len - 1; i >= 0; i--){
            arr[i] = (arr[i] + 1) % 10;
            if (arr[i] != 0){
                return arr;
            }
        }
        int[] arr1 = new int[len + 1];
        arr1[0] = 1;
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr = {9,9};
        int[] ints = addOne(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
