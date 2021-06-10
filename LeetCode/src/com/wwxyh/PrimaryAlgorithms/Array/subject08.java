package com.wwxyh.PrimaryAlgorithms.Array;

import java.util.Arrays;

/**
 * @Description: 移动零
 * @Author: wwx
 * @Date: 2021/6/10 21:01
 */
public class subject08 {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     * 说明:
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     **/

    public static void moveZeroes(int[] nums) {
        //定义初始指向位置
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            //遍历，当前数不为0时往前移动
            if (nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
        }
        //index开始后都为0
        while (index < nums.length){
            nums[index] = 0;
            index++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,9,3,12,15,0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
