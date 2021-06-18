package com.wwxyh.PrimaryAlgorithms.String;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: 字符串中的第一个唯一字符
 * @Author: wwx
 * @Date: 2021/6/18 22:51
 */
public class subject03 {
    
    /*
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     *
     * s = "leetcode"
     * 返回 0
     *
     * s = "loveleetcode"
     * 返回 2
     **/

    public static void main(String[] args) {
        String s = "loveleetcode";
        int i = firstUniqChar(s);
        System.out.println(i);
    }

    //耗时长
    public static int firstUniqChar(String s) {
        //按加入顺序存储各字符出现的次数
        LinkedHashMap<Object, Integer> linkedHashMap = new LinkedHashMap<>();
        //存储各字符第一次出现时的下标
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (linkedHashMap.containsKey(c)){
                //存在该字符，出现次数+1
                Integer o = linkedHashMap.get(c);
                linkedHashMap.put(c,o+1);
                continue;
            }
            linkedHashMap.put(c,1);
            hashMap.put(c,i);
        }
        //遍历LinkedHashMap
        Iterator<Map.Entry<Object, Integer>> iterator = linkedHashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Object, Integer> entry = iterator.next();
            if (entry.getValue() == 1){
                Object key = entry.getKey();
                Integer integer = hashMap.get(key);
                return integer;
            }
        }
        return -1;
    }

    public static int firstUniqChar1(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) == s.lastIndexOf(c)){
                return i;
            }
        }
        return -1;
    }
}
