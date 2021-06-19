package com.wwxyh.PrimaryAlgorithms.String;

import java.util.Arrays;

/**
 * @Description: 有效的字母异位词
 * @Author: wwx
 * @Date: 2021/6/19 22:23
 */
public class subject04 {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     *
     * 输入: s = "rat", t = "car"
     * 输出: false
     **/

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean b = isAnagram1(s, t);
        System.out.println(b);
    }

    public static boolean isAnagram(String s, String t) {
        //长度不相等不满足条件
        if (s.length() != t.length()){
            return false;
        }
        //转换成数组，之后进行排序
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar,tChar);
    }

    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] letterCount = new int[26];
        //统计字符串s中的每个字符的数量
        for (int i = 0; i < s.length(); i++)
            letterCount[s.charAt(i) - 'a']++;
        //减去字符串t中的每个字符的数量
        for (int i = 0; i < t.length(); i++) {
            //如果当前字符等于0，直接返回false，
            if (letterCount[t.charAt(i) - 'a'] == 0)
                return false;
            letterCount[t.charAt(i) - 'a']--;
        }
        return true;
    }
}
