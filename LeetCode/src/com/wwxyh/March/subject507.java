package com.wwxyh.March;

/**
 * @Description: 斐波那契数
 * @Author: wwx
 * @Date: 2021/8/3 22:37
 */
public class subject507 {

    //递归
    public int fib1(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        return fib1(n-1) + fib1(n-2);
    }

    /**
     * 动态规划解题步骤：
     *      1、确定dp数组以及下标的含义
     *      2、确定递推公式
     *      3、dp数组如何初始化
     *      4、确定遍历顺序
     *      5、举例推导dp数组
     **/
    public int fib2(int n) {
        if (n <= 1){
            return n;
        }
        //dp[i]的定义为：第i个数的斐波那契数值时dp[i]
        int[] dp = new int[n + 1];
        //初始化dp数组
        dp[0] = 0;
        dp[1] = 1;
        //dp[i]是依赖 dp[i - 1] 和 dp[i - 2]，遍历顺序是从前往后遍历
        for (int i = 2; i <= n; i++){
            //递推公式为：dp[i] = dp[i-1] + dp[i-2];
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
