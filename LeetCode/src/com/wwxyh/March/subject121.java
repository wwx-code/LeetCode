package com.wwxyh.March;

/**
 * @Description: 买卖股票的最佳时机
 * @Author: wwx
 * @Date: 2021/6/5 22:45
 */
public class subject121 {
    
    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     *
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     *
     * 输入：[7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
     **/

    public static int maxProfit(int[] arr){
        //最大利润
        int maxPro = 0;
        //当前最大利润
        int currMax = 0;
        //最小买入时的天数
        int min = 0;
        //最大卖出时的天数
        int max = 1;
        //[3,2,6,5,0,3]
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[min]){
                min = i;
                max = i;
                continue;
            }
            if (arr[i] >= arr[max]){
                max = i;
                currMax = arr[max] - arr[min];
                maxPro = maxPro > currMax ? maxPro : currMax;
            }
        }
        return maxPro;
    }

    //官方，只用两变量
    public int maxProfitOfficial(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,6,5,0,3};
        int i = maxProfit(arr);
        System.out.println(i);
    }
}
