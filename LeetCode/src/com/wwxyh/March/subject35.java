package com.wwxyh.March;

import com.sun.xml.internal.bind.v2.model.core.ID;
import jdk.nashorn.internal.ir.IfNode;

/**
 * @Description:
 * @Author: wwx
 * @Date: 2021/5/29 18:33
 */
public class subject35 {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 你可以假设数组中无重复元素。
     *
     *
     * 输入: [1,3,5,6], 5
     * 输出: 2
     *
     * 输入: [1,3,5,6], 2
     * 输出: 1
     **/

    public static int location(int[] arr,int target){
        //二分法
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (arr[mid] > target){
                right = mid - 1;
            }if (arr[mid] < target){
                left = mid + 1;
            }if (arr[mid] == target){
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int location = location(arr, 7);
        System.out.println(location);
    }
}
