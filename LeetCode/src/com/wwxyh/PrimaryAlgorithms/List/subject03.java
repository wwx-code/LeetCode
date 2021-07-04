package com.wwxyh.PrimaryAlgorithms.List;

import java.util.Stack;

/**
 * @Description: 反转链表
 * @Author: wwx
 * @Date: 2021/7/4 23:24
 */
public class subject03 {

    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     *
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     *
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     *
     * 输入：head = []
     * 输出：[]
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
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        //把链表节点全部摘掉放到栈中
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty()){
            return null;
        }

        ListNode node = stack.pop();
        ListNode dump = node;
        //栈中的结点全部出栈，然后重新连成一个新的链表
        while (!stack.isEmpty()){
            ListNode temp = stack.pop();
            node.next = temp;
            node = node.next;
        }
        //最后一个结点就是反转前的头结点，一定要让他的next等于空，否则会构成环
        node.next = null;
        return dump;
    }

    //假设存在链表 1 → 2 → 3 → ∅ ，我们想要把它改成 ∅ ← 1 ← 2 ← 3。
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (head != null){
            //        2
            ListNode temp = head.next;  //保存head的下一个结点
            //  1 -> null
            cur.next = pre;  //让cur的next指向pre，实现一次局部反转
            // pre = 1
            pre = cur;  //pre和 ur同时往前移动一个位置
            // cur = 2
            cur = temp;  //
        }
        return pre;
    }
}
