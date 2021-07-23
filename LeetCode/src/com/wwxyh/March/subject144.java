package com.wwxyh.March;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 二叉树的前序遍历
 * @Author: wwx
 * @Date: 2021/7/19 12:00
 */
public class subject144 {

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

    //递归遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root,res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null){
            return;
        }
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
    }


    //迭代遍历
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        if (!stack.isEmpty() || node != null){
            if (node != null){
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }

    //迭代第二种方式
    public List<Integer> preorderTraversal3(TreeNode root) {
        //定义一个栈
        Stack<TreeNode> stack = new Stack<>();
        //定义一个list存放遍历结果
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        //将树的头结点放进去
        stack.push(root);
        //
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            //栈先进后出的特性，先放入树的右节点
            if (node.right != null){
                stack.push(node.right);
            }
            //之后才放入左节点
            if (node.left != null){
                stack.push(node.left);
            }
        }
        return list;
    }

}
