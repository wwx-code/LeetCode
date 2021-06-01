package com.wwxyh.March;

import java.util.Arrays;

/**
 * @Description: 合并两个有序数组
 * @Author: wwx
 * @Date: 2021/6/1 21:11
 */
public class subject88 {

    /*
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
     *
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     *
     * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
     * 输出：[1]
     **/

    public static int[] mergeArray(int[] arr1, int[] arr2){
        int len1 = arr1.length;
        int len2 = arr2.length;
        int len3 = len1 - len2;
        for (int i = 0; i < len2; i++) {
            arr1[len3 + i] = arr2[i];
        }

        //排序
        for (int i = 0; i < len1-1; i++) {
            for (int j = 0; j < len1-i-1; j++) {
                if (arr1[j] > arr1[j+1]){
                    int temp = arr1[j];
                    arr1[j] = arr1[j+1];
                    arr1[j+1] = temp;
                }
            }
        }
        //Arrays.sort(arr1);
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,0,0};
        int[] arr2 = {2,4};
        mergeArray(arr1,arr2);
        for (int i : arr1) {
            System.out.println(i);
        }
    }
}
