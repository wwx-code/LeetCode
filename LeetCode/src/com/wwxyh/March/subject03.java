package com.wwxyh.March;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class subject03 {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     *
     * 示例1：
     *      输入: s = "abcabcbb"
     *      输出: 3
     *      解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例2：
     *      输入: s = "bbbbb"
     *      输出: 1
     *      解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例3：
     *      输入: s = ""
     *      输出: 0
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        //将已有的字符串存到 Hash 里
        Set<Character> set = new HashSet<>();
        /**
         * ans: 最长子串长度
         * left: 滑动窗口左坐标
         * right: 滑动窗口右坐标
         */
        int ans = 0, left = 0, right = 0;
        while (left < n && right < n) {
            //当前字符串不在hash
            if (!set.contains(s.charAt(right))){
                set.add(s.charAt(right++));
                ans = Math.max(ans, right - left);
            }
            else {
                set.remove(s.charAt(left++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabca";
        lengthOfLongestSubstring(s);
    }
    }

