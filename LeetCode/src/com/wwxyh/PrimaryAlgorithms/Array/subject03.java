package com.wwxyh.PrimaryAlgorithms.Array;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Arrays;

/**
 * @Description: 旋转数组
 * @Author: wwx
 * @Date: 2021/6/6 22:55
 */
public class subject03 {

    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     *
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     *
     *
     * 输入：nums = [-1,-100,3,99], k = 2
     * 输出：[3,99,-1,-100]
     * 解释:
     * 向右旋转 1 步: [99,-1,-100,3]
     * 向右旋转 2 步: [3,99,-1,-100]
     **/

    //直接复制一个新数组，将就数组的值一个一个放进去
    public static int[] rotateArray1(int[] arr, int k){
        int len = arr.length;
        int[] newArr = new int[len];
        for (int i = 0; i < len; i++) {
            //移动坐标后对数组长度取余
            int j = (i + k) % len;
            //赋值
            newArr[j] = arr[i];
        }
        arr = Arrays.copyOf(newArr,arr.length);
        return arr;
    }

    //生成一个长度为原数组+移动步数的新数组，将原数组整体移动k在新数组，然后补上新数组的前k位
    public static int[] rotateArray2(int[] arr, int k){
        int len = arr.length;
        //生成一个长度为原数组+移动步数的新数组
        int[] newArr = new int[len + k];
        for (int i = k; i < newArr.length; i++) {
            newArr[i] = arr[i-k];
        }   //{0,0,-1,-100,3,99}
        for (int i = 0;i < k;i++){
            newArr[i] = newArr[i+len];
        }  //{3,99,-1,-100,3,99}
        //截取结果数组的前len位为新数组，返回该新数组
        int[] ints = Arrays.copyOfRange(newArr, 0, len);  //{3,99,-1,-100}
        return ints;
    }

    public static void main(String[] args) {
        int[] arr = {-1,-100,3,99};
        int k = 2;
        int[] ints = rotateArray1(arr, k);
        String s = Arrays.toString(ints);
        System.out.println(s);
    }
}
