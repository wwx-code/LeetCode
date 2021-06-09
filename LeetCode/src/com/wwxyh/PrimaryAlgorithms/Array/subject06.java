package com.wwxyh.PrimaryAlgorithms.Array;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 两个数组的交集 II
 * @Author: wwx
 * @Date: 2021/6/9 20:01
 */
public class subject06 {

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2,2]
     *
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[4,9]
     *
     * 说明：
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * 我们可以不考虑输出结果的顺序。
     **/

    public static int[] intersect(int[] nums1, int[] nums2) {
        //对数组进行排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //定义左右两个指针分别指向两数组的头部
        int left = 0;
        int right = 0;
        List<Integer> list = new ArrayList<>();
        while (left < nums1.length && right < nums2.length){
            if (nums1[left] == nums2[right]){
                //当值相等时，将当前值放入集合
                list.add(nums1[left]);
                //两指针同时后移
                left++;
                right++;
            }else {
                //不相等，值小的数组指针后移一位
                if (nums1[left] > nums2[right]) {
                    right++;
                } else {
                    left++;
                }
            }
        }
        //返回数组
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] num1 = {4,9,5};
        int[] num2 = {9,4,9,8,4};
        int[] intersect = intersect(num1, num2);
        for (int i : intersect) {
            System.out.println(i);
        }
    }
}
