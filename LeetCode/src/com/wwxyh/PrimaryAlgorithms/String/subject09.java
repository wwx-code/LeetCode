package com.wwxyh.PrimaryAlgorithms.String;

/**
 * @Description:  最长公共前缀
 * @Author: wwx
 * @Date: 2021/6/26 22:39
 */
public class subject09 {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     *
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     **/

    public static void main(String[] args) {
        subject09 subject = new subject09();
        String[] strs = {"flower", "flow", "flight"};
        String s = subject.longestCommonPrefix(strs);
        System.out.println(s);
    }

    //横向扫描，依次遍历每个字符串，更新最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return "";
        }
        int count = strs.length;
        String pre = strs[0];
        for (int i = 1; i < count; i++) {
            pre = longestCommonPrefix(pre, strs[i]);
            if (pre.length() == 0) {
                break;
            }
        }
        return pre;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int min = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < min && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}
