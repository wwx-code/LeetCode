package com.wwxyh.PrimaryAlgorithms.Tree;

import java.util.Stack;

/**
 * @Description: 验证二叉搜索树
 * @Author: wwx
 * @Date: 2021/7/22 21:25
 */
public class subject02 {

    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     * 假设一个二叉搜索树具有如下特征：
     *
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     * 输入:
     *     2
     *    / \
     *   1   3
     * 输出: true
     *
     * 输入:
     *     5
     *    / \
     *   1   4
     *      / \
     *     3   6
     * 输出: false
     * 解释: 输入为: [5,1,4,null,null,3,6]。
     *      根节点的值为 5 ，但是其右子节点值为 4 。
     */

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

    // 迭代 中序遍历
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return true;
        }
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val)
                return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    // 递归
    public boolean isValidBST2(TreeNode root) {
        return recurse(root,null,null);
    }

    boolean recurse(TreeNode node, Integer lower, Integer upper){
        if (node == null){
            return true;
        }

        int val = node.val;
        if (lower != null && val <= lower){
            return false;
        }
        if (upper != null && val >= upper){
            return false;
        }

        if(!recurse(node.right, val, upper)){
            return false;
        }
        if(!recurse(node.left, lower, val)){
            return false;
        }
        return true;
    }
}
