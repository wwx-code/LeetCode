package com.wwxyh.PrimaryAlgorithms.String;

import com.sun.xml.internal.ws.util.StreamUtils;
import com.sun.xml.internal.ws.util.StringUtils;

/**
 * @Description: 外观数列
 * @Author: wwx
 * @Date: 2021/6/24 21:10
 */
public class subject08 {

    /**
     * 给定一个正整数 n ，输出外观数列的第 n 项。
     * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
     *
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 第一项是数字 1
     * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
     * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
     * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
     * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
     **/

    public static void main(String[] args) {
        String s = countAndSay(2);
        System.out.println(s);
    }

    //2 ms
    public static String countAndSay1(int n) {
        if (n == 1){
            return "1";
        }
        String str = countAndSay1(n - 1);
        StringBuilder res = new StringBuilder();
        int length = str.length();
        int start = 0;
        for (int i = 0; i < length + 1; i++) {
            // 字符串最后一位直接拼接
            if (i == length) {
                res.append(i - start).append(str.charAt(start));
                // 直到start位的字符串和i位的字符串不同，拼接并更新start位
            } else if (str.charAt(i) != str.charAt(start) ) {
                res.append(i - start).append(str.charAt(start));
                start = i;
            }
        }
        return res.toString();
    }

    //双指针 + 递归
    //18 ms
    public static String countAndSay(int n) {
        if (n == 1){
            return "1";
        }
        String preString = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        int left = 0;
        int right = 0;
        while (right < preString.length()){
            //左右指针指向的值不同，对left指向的值进行总结
            if (preString.charAt(right) != preString.charAt(left)){
                //出现的次数
                int num = right - left;
                //当前值
                String s = Character.toString(preString.charAt(left));
                result.append(num + s);
                //拼接后将left指针移动到right处
                left = right;
                continue;
            }
            //遍历到最后，说明left到right都是同样的值，进行描述
            if (right == preString.length() - 1){
                int num = right - left + 1;
                String s = Character.toString(preString.charAt(left));
                result.append(num + s);
                break;
            }
            right++;
        }
        return result.toString();
    }
}
