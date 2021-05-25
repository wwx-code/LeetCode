package com.wwxyh.March;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @Description:  删除有序数组中的重复项
 * @Author: wwx
 * @Date: 2021/5/24 23:05
 */
public class subject26 {

    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * 示例1：
     *      输入：nums = [1,1,2]
     *      输出：2, nums = [1,2]
     *      解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2
     *
     * 示例2：
     *      输入：nums = [0,0,1,1,1,2,2,3,3,4]
     *      输出：5, nums = [0,1,2,3,4]
     **/

    //双指针解法
    public static int RemoveDuplicates(int[] nums) {
        int len = nums.length;
        //j指向有效数组的最后一个位置
        int j = 0;
        //i指针循环遍历
        for (int i = 0; i < len; i++) {
            //当 i 所指向的值和 j 不一致（不重复）
            if (nums[i] != nums[j]){
                //当前j指向的下一个元素存储当前指向的元素
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

    public static int myRemoveDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Object> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)){
                continue;
            }
            set.add(num);
            list.add(num);
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return list.size();
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4};
        int size = myRemoveDuplicates(nums);
        System.out.println("数组长度:" + size);
    }
}
