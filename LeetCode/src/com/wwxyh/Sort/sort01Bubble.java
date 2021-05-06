package com.wwxyh.Sort;

/**
 * @Description: 冒泡排序
 * @Author: wwx
 * @Date: 2021/5/6 20:44
 */
public class sort01Bubble {

    public static void main(String[] args) {
        int[] arr = {1,3,5,6,8};
        int[] sort = bubbleSort(arr);
        for (int i : sort) {
            System.out.println(i);
        }
    }

    /**
     * 算法步骤：
     *      1、比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     *      2、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     *      3、针对所有的元素重复以上的步骤，除了最后一个。
     *      4、持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     **/
    public static int[] bubbleSort(int[] array){
        int len = array.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len-i-1; j++) {
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
}
