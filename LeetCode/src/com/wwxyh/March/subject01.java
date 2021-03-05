package com.wwxyh.March;


public class subject01 {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，
     * 并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * 7:0,2:1,-2:2,-6:3
     * 示例：
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] aaa = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for(int j = i + 1;j < nums.length;j++){
                if (target == nums[i] + nums[j]){
                    aaa[0] = i;
                    aaa[1] = j;
                }
            }
        }
        return aaa;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        int target = 11;
        int[] ints = twoSum(nums, target);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
