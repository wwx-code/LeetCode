package com.wwxyh.PrimaryAlgorithms.Array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Description: 存在重复元素
 * @Author: wwx
 * @Date: 2021/6/7 20:45
 */
public class subject04 {

    /**
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     *
     * 输入: [1,2,3,1]
     * 输出: true
     *
     * 输入: [1,2,3,4]
     * 输出: false
     **/

    public static boolean isExistRepeat(int[] arr){
        //用set来存储不重复的元素
        HashSet<Integer> set = new HashSet<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            set.add(arr[i]);
        }
        int setSize = set.size();
        //arr长度和set集合大小相等说明没有重复元素，否则存在重复元素
        return len == setSize ? false : true;
    }

    public static boolean isExistRepeat1(int[] arr){
        //对数组进行排序
        Arrays.sort(arr);
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            //如果相邻元素有相等的，说明存在重复元素
            if (arr[i] == arr[i+1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,1,3};
        boolean existRepeat = isExistRepeat1(arr);
        System.out.println(existRepeat);
    }
}
