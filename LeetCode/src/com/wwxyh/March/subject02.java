package com.wwxyh.March;

import java.util.LinkedList;

public class subject02 {
    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，
     * 并且每个节点只能存储 一位 数字。请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例1：
     *      输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     *      输出：[8,9,9,9,0,0,0,1]
     *      解释：9999999 + 9999 = 1000998.
     * 示例2：
     *      输入：l1 = [1,2,3], l2 = [4,5,6]
     *      输出：[5,7,9]
     *      解释：321 + 654 = 975.
     */
    public class ListNode {
      int val;
      ListNode next;

      ListNode() {}

      ListNode(int val) {
          this.val = val;
      }

      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }
  }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        //初始化 p 和 q 分别为给定的两个链表 l1 和 l2 的头，也就是个位。
        ListNode p = l1,q = l2,curr = dummyHead;
        //进位
        int carry = 0;
        //循环，直到 l1 和 l2 全部到达 null 。
        while (p != null || q != null){
            //设置 x 为 p 节点的值，如果 p 已经到达了 null，设置 x 为 0
            int x = (p != null) ? p.val : 0;
            //设置 y 为 q 节点的值，如果 q 已经到达了 null，设置 y 为 0
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null){
                p = p.next;
            }
            if (q != null){
                q = q.next;
            }
        }
        if (carry > 0){
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static LinkedList addTwoNumbers(LinkedList l1, LinkedList l2) {
        int l1Length = l1.size();
        int l2Length = l2.size();
        //判断链表长度，取最大的
        int max = l1Length > l2Length ? l1Length : l2Length;
        int min = l1Length > l2Length ? l2Length : l1Length;
        int current;
        //是否进位
        int carry = 0;
        LinkedList<Integer> l3 = new LinkedList<Integer>();
        for (int i = max-1;i >= 0;i--){
            if (i<=min){

                int currentL2 = (int) l2.get(i);
                //取出当前的节点值
                int currentL1 = (int) l1.get(i);
                current = currentL1 + currentL2 + carry;
                if (current >= 10){
                    carry = 1;
                    current = current % 10;
                }else {
                    carry = 0;
                }
                l3.add(i,current);
            }else {
                //取出当前的节点值
                int currentL1 = (int) l1.get(i);
                current = currentL1 + carry;
                if (current >= 10){
                    carry = 1;
                    current = current % 10;
                }else {
                    carry = 0;
                }
                l3.add(i,carry);
            }
        }
        return l3;
    }

}
