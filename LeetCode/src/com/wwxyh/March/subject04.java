package com.wwxyh.March;

import java.util.HashSet;
import java.util.Set;

public class subject04 {
    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数
     *
     * 示例1：
     *      输入：nums1 = [1,3], nums2 = [2]
     *      输出：2.00000
     *      解释：合并数组 = [1,2,3] ，中位数 2
     *
     * 示例2：
     *      输入：nums1 = [1,2], nums2 = [3,4]
     *      输出：2.50000
     *      解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     *
     * 示例3：
     *      输入：nums1 = [0,0], nums2 = [0,0]
     *      输出：0.00000
     *
     * 示例4：
     *      输入：nums1 = [2], nums2 = []
     *      输出：2.00000
     */

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //两数组合并后的长度，为奇数时取中间数，偶数时取中间两位/2
        int len = m + n;
        int left = 0,right = 0;
        //当前指向 A 数组和 B 数组的位置
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2;i++){
            //将上一次循环的值 right 赋给 left
            left = right;
            // (1)aStart < m && bStart >= n: nums1还没遍历完且nums2以遍历完
            //（2）nums1[aStart] < nums2[bStart]
            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])){
                right = nums1[aStart++];
            }else {
                right = nums2[bStart++];
            }
        }
        if (len % 2 == 0 || len == 0){
            return (left + right) / 2.0;
        }else {
            return right;
        }
    }

    public static void main(String[] args) {
        int[] num1 = {2};
        int[] num2 = {};
        double aaa = findMedianSortedArrays(num1, num2);
        System.out.println(aaa);
    }
}
