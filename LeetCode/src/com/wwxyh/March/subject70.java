package com.wwxyh.March;

/**
 * @Description: 爬楼梯
 * @Author: wwx
 * @Date: 2021/6/15 21:19
 */
public class subject70 {

    //暴力递归解法
    public static int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }

        //第n级台阶：从第n-1级台阶爬1级或从n-2级台阶爬2级
        return climbStairs(n-1) + climbStairs(n - 2);
    }
    
    /**
     * 动态规划：（参考一周三练）
     * 1 确定dp数组以及下标定义：dp[i]表示爬到第i层楼梯的方法总数
     * 2 确定递推公式：
     * 爬到第1层楼梯有1种方法
     * 爬到第2层楼梯有2种方法
     * 爬到第3层楼梯有：爬到第1层楼梯后2步爬到第三层；爬上第2层楼梯后1步爬到第3层。所以爬到第三层楼梯的方法数量是：dp[1]+dp[2]
     * dp[i]=dp[i-1]+dp[i-2]
     * 3 初始化 dp[1]=1 dp[2]=2
     * 4 确定遍历顺序，本题由递推公式可以明确看出是顺序
     * 5 推导几个数验证一下
     **/
    public static int climbStairs2(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int i = climbStairs2(4);
        System.out.println(i);
    }
}
