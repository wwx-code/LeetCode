package com.wwxyh.March;

/**
 * @Description: 最大子序和
 * @Author: wwx
 * @Date: 2021/5/30 21:56
 */
public class subject53 {

    /*
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
     *
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     *
     * 输入：nums = [-1]
     * 输出：-1
     **/

    //贪心算法求解
    public static int maxSumGreedy(int[] arr){
        //最大和
        int maxSum = arr[0];
        //当前和
        int currentSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (currentSum < 0){
                //当前和小于0时，直接丢弃之前的结果
                //当前和赋值为当前元素
                currentSum = arr[i];
                maxSum = maxSum > currentSum ? maxSum : currentSum;
                continue;
            }
            currentSum = currentSum + arr[i];
            maxSum = maxSum > currentSum ? maxSum : currentSum;
        }
        return maxSum;
    }

    //动态规划
    public static int maxSumDynamic(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (dp[i-1] >= 0){
                dp[i] = dp[i-1] + arr[i];
            }else {
                dp[i] = arr[i];
            }
        }
        int max = dp[0];
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int[] arr = {-2,1};
//        int[] arr = {1,2,3,4,-12,6,2};
        int i = maxSumGreedy(arr);
        System.out.println(i);
        int j = maxSumDynamic(arr);
        System.out.println(j);
    }
}
