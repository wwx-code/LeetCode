package com.wwxyh.PrimaryAlgorithms.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 只出现一次的数字
 * @Author: wwx
 * @Date: 2021/6/8 20:59
 */
public class subject05 {
    
    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     *
     * 输入: [2,2,1]
     * 输出: 1
     *
     * 输入: [4,1,2,1,2]
     * 输出: 4
     **/

    public static Integer appearOne(int[] arr){
        //hashmap存放，key为数字，value为出现次数
        //感觉有点low，再想想其他方法
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)){
                map.put(i,2);
            }else {
                map.put(i,1);
            }
        }
        //遍历map集合
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return -1;
    }

    //官方
    /**
     * 异或规律：
     * 1^1=0;
     * 1^0=1;
     * 0^1=1;
     * 0^0=0;
     *
     * 异或运算 满足交换律 a^b^a = a^a^b = b 所以数组经过异或运算，单独的值就剩下了
     *
     * 2 ^ 3：
     * 0010
     * 0011
     * 0001
     **/
    public static int singleNumber(int[] arr){
        int reduce = 0;
        for (int i : arr) {
            System.out.println(i);
            reduce = reduce ^ i;
        }
        return reduce;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,4,2};
        Integer integer = singleNumber(arr);
        System.out.println(integer);
    }
}
