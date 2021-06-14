package com.wwxyh.PrimaryAlgorithms.String;

/**
 * @Description: 整数翻转
 * @Author: wwx
 * @Date: 2021/6/14 16:22
 */
public class subject02 {

    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     *
     * 输入：x = 123
     * 输出：321
     *
     * 输入：x = 120
     * 输出：21
     *
     * 输入：x = -123
     * 输出：-321
     **/

    public static int reverse(int x) {
        int res = 0;
        while (x != 0){
            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int temp = x % 10;
            x /= 10;
            res = res * 10 + temp;
        }
        return res;
    }

    public static void main(String[] args) {
        int reverse = reverse(123);
        System.out.println(reverse);
    }
}
