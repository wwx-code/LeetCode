package com.wwxyh.PrimaryAlgorithms.List;

import java.util.Stack;

/**
 * @Description: 回文链表
 * @Author: wwx
 * @Date: 2021/7/7 23:28
 */
public class subject05 {

    /**
     * 请判断一个链表是否为回文链表。
     *
     * 输入: 1->2
     * 输出: false
     *
     * 输入: 1->2->2->1
     * 输出: true
     **/

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //使用栈解决
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        //把链表节点的值存放到栈中
        while (temp != null){
            stack.push(temp.val);
            temp = temp.next;
        }
        //然后再出栈
        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            if (pop != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
