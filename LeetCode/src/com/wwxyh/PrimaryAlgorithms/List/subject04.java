package com.wwxyh.PrimaryAlgorithms.List;

/**
 * @Description: 合并两个有序链表
 * @Author: wwx
 * @Date: 2021/7/6 21:29
 */
public class subject04 {

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     *
     * 输入：l1 = [], l2 = []
     * 输出：[]
     *
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode dumpy = new ListNode(0);
        ListNode curr = dumpy;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        //然后把那个不为空的链表挂到新的链表中
        curr.next = l1 == null ? l2 : l1;
        return dumpy;
    }
}
