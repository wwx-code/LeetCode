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

    //快慢指针
    public boolean isPalindrome2(ListNode head) {
        ListNode fast = head, slow = head;
        //通过快慢指针找到中点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //如果fast不为空，说明链表的长度是奇数个
        if (fast != null) {
            slow = slow.next;
        }
        //反转后半部分链表
        slow = reverse(slow);

        fast = head;
        while (slow != null) {
            //然后比较，判断节点值是否相等
            if (fast.val != slow.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    //反转链表
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
