package com.wwxyh.PrimaryAlgorithms.List;

/**
 * @Description:  删除链表的倒数第 N 个结点
 * @Author: wwx
 * @Date: 2021/6/28 21:02
 */
public class subject02 {

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     *
     * 输入：head = [1], n = 1
     * 输出：[]
     *
     * 输入：head = [1,2], n = 1
     * 输出：[1]
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

    //双指针
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        //一个指针fast先走n步，然后另一个指针slow从头结点开始
        //当fast为null时，slow指针指向的即为要删除的节点
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //如果fast为空，表示删除的是头结点
        if (fast == null){
            return fast.next;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        //这里最终slow不是倒数第n个节点，他是倒数第n+1个节点，
        //他的下一个结点是倒数第n个节点,所以删除的是他的下一个结点
        slow.next = slow.next.next;
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        int last = length(head) - n;
        //如果last等于0表示删除的是头结点
        if (last == 0){
            return pre.next;
        }
        //找到要删除链表的前一个结点
        for (int i = 0; i < last - 1; i++) {
            pre = pre.next;
        }
        //让前一个结点的next指向要删除节点的next
        pre.next = pre.next.next;
        return head;
    }

    //计算链表长度
    private int length(ListNode head){
        int len = 0;
        while (head != null){
            len++;
            head = head.next;
        }
        return len;
    }
}
