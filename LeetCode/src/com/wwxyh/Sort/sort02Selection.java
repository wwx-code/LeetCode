package com.wwxyh.Sort;

/**
 * @Description: 选择排序
 * @Author: wwx
 * @Date: 2021/5/6 21:08
 */
public class sort02Selection {

    public static void main(String[] args) {
        int[] arr = {1,3,5,6,8};
        int[] sort = selectionSort(arr);
        for (int i : sort) {
            System.out.println(i);
        }
    }

    /**
     * 1、首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
     * 2、再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾
     * 3、重复第二步，直到所有元素均排序完毕
     **/
    public static int[] selectionSort(int[] array){
        int len = array.length;
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            int temp = 0;
            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < len; j++) {
                if (array[min] > array[j]){
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }
            // 将找到的最小值和i位置所在的值进行交换
            if (i != min){
                temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        return array;
    }
}
