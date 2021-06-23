package com.wwxyh.PrimaryAlgorithms.String;

/**
 * @Description: 实现 strStr()
 * @Author: wwx
 * @Date: 2021/6/23 22:06
 */
public class subject07 {

    /**
     * 实现 strStr() 函数。
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
     *
     * 说明：
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
     *
     * 输入：haystack = "hello", needle = "ll"
     * 输出：2
     *
     * 输入：haystack = "aaaaa", needle = "bba"
     * 输出：-1
     *
     * 输入：haystack = "", needle = ""
     * 输出：0
     **/

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        int i = strStr(haystack, needle);
        System.out.println(i);
    }

    //一般字符串匹配的时候，最简单的一种方式，就是子串从头开始和主串匹配。
    //如果匹配失败，子串再次从头开始，而主串从上次匹配的下一个字符开始
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0){
            return 0;
        }
        int right = 0;
        for (int i = 0;i < haystack.length();i++){
            if (!(haystack.charAt(i) == needle.charAt(right))){
                //如果不匹配，就回退，从第一次匹配的下一个开始，
                i -= right;
                right = 0;
                continue;
            }
            right++;
            if (right == needle.length()){
                return i - right + 1;
            }
        }
        return -1;
    }
}
