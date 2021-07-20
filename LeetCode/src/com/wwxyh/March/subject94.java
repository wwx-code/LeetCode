package com.wwxyh.March;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 二叉树的中序遍历
 * @Author: wwx
 * @Date: 2021/7/19 18:34
 */
public class subject94 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list;
    }

    public void inorder(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }

    // 迭代遍历
    // 遍历顺序：左中右
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null && !stack.isEmpty()){
            if (cur != null){
                // 不为空，将当前结点放入栈中，继续向左遍历
                stack.push(cur);
                cur = cur.left;
            } else {
                // 为空，弹出栈中的最新结点
                cur = stack.pop();
                // 加入遍历结果集中
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }
}
