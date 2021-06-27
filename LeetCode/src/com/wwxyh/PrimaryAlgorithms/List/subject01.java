package com.wwxyh.PrimaryAlgorithms.List;

import com.wwxyh.March.subject02;

/**
 * @Description:  删除链表中的节点
 * @Author: wwx
 * @Date: 2021/6/27 22:43
 */
public class subject01 {

    /**
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
     *
     * 输入：head = [4,5,1,9], node = 5
     * 输出：[4,1,9]
     * 解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     *
     * 输入：head = [4,5,1,9], node = 1
     * 输出：[4,5,9]
     * 解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     **/

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        //把要删除结点的下一个结点的值赋给要删除的结点
        node.val = node.next.val;
        //然后删除下一个结点
        node.next = node.next.next;
    }
}
