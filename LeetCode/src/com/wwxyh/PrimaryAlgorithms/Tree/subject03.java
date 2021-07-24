package com.wwxyh.PrimaryAlgorithms.Tree;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * @Description: 对称二叉树
 * @Author: wwx
 * @Date: 2021/7/24 21:18
 */
public class subject03 {

    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * true
     *
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     * false
     **/

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
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }

    boolean isMirror(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }

        if (left == null || right == null){
            return false;
        }

        return (left.val == right.val)
                && isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }
}
