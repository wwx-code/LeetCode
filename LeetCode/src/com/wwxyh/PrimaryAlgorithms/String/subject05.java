package com.wwxyh.PrimaryAlgorithms.String;

/**
 * @Description: 验证回文串
 * @Author: wwx
 * @Date: 2021/6/20 21:41
 */
public class subject05 {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean result = isPalindrome1(s);
        System.out.println(result);
    }

    //使用正则匹配，把特殊字符过滤掉，只留下字母和数字，然后转化为小写，再反转，最后在判断是否相等
    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }

    //双指针2：先把
    public static boolean isPalindrome2(String s) {
        //字母全部转化为小写
        s.toLowerCase();
        int length = s.length();
        //定义左右指针
        int left = 0;
        int right = length - 1;
        while (left < right){
            //当前指针指向的值不是字母或数字字符时，相应的指针移动且进入下次循环
            if (!Character.isLetterOrDigit(s.charAt(left))){
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))){
                right--;
                continue;
            }
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //双指针
    public static boolean isPalindrome1(String s) {
        //转换成char数组
        char[] chars = s.toCharArray();
        int length = chars.length;
        //定义左右指针
        int left = 0;
        int right = length - 1;
        while (left < right){
            //当前指针指向的值不是字母或数字字符时，相应的指针移动且进入下次循环
            if (!Character.isLetterOrDigit(chars[left])){
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(chars[right])){
                right--;
                continue;
            }
            //将char转换成string后调用equalsIgnoreCase忽略大小写比较，不相等则返回false
            if (!String.valueOf(chars[left]).equalsIgnoreCase(String.valueOf(chars[right]))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
