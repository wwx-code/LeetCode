package com.wwxyh.Sort;

import java.util.Arrays;

/**
 * @Description: 快速排序
 * @Author: wwx
 * @Date: 2021/5/16 23:44
 */
public class sort03Quick {
    public static void main(String[] args){
        int[] arr = {1,5,6,7,2,3};
        sort03Quick quick = new sort03Quick();
        quick.quickSort(arr);
        String s = Arrays.toString(arr);
        System.out.println(s);
    }

    /**
     * 快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，
     * 则可分别对这两部分记录继续进行排序，以达到整个序列有序。
     *
     * 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
     * （1）从数列中挑出一个元素，称为 “基准”（pivot）；
     * （2）重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
     *     在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * （3）递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     **/

    public int[] quickSort(int[] array){
        return quickSort(array,0,array.length - 1);
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            //递归调用排序左边数组
            quickSort(arr, left, partitionIndex - 1);
            //递归调用排序右边数组
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        //从index处开始遍历比较
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
