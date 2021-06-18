package com.wwxyh.Sort;

import java.util.Arrays;

/**
 * @Description: 插入排序
 * @Author: wwx
 * @Date: 2021/6/18 21:05
 */
public class sort04Insert {

    /*
     插入排序：
        通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
            1.从第一个元素开始，该元素可以认为已经被排序；
            2.取出下一个元素，在已经排序的元素序列中从后向前扫描；
            3.如果该元素（已排序）大于新元素，将该元素移到下一位置；
            4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
            5.将新元素插入到该位置后；
     */

    public static void main(String[] args) {
        int[] arr = {7,2,5,3,4,6};
        int[] ints = insertSort(arr);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] insertSort(int[] array){
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int temp = array[i];
            int preIndex = i - 1;
            while (preIndex >= 0 && array[preIndex] > temp){
                array[preIndex+1] = array[preIndex];
                preIndex--;
            }
            array[preIndex+1] = temp;
        }
        return array;
    }
}
