package com.leetcode.dayday2;

/**
 * [*合并二叉树*:
 * 给你两棵二叉树： root1 和 root2 。
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
 * 你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；
 * 否则，不为 null 的节点将直接作为新二叉树的节点。返回合并后的二叉树。
 * 注意: 合并过程必须从两个树的根节点开始]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/8/14 20:50]
 */
public class Demo9 {
    public static void main(String[] args) {
        //创建二叉树
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        TreeNode left2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(3);
        root2.left = left2;
        root2.right = right2;
        left2.right = new TreeNode(4);
        right2.right = new TreeNode(7);

        Solution9 solution9 = new Solution9();
        TreeNode treeNode = solution9.mergeTrees(root, root2);
        // 前序遍历
        solution9.preOrder(treeNode);
    }
}

class Solution9 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        // 递归
        // 1. 递归终止条件
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }

        // 2. 递归过程
        root1.val += root2.val;// 合并两个节点的值
        root1.left = mergeTrees(root1.left, root2.left);// 递归左子树,返回值是合并后的左子树
        root1.right = mergeTrees(root1.right, root2.right);// 递归右子树,返回值是合并后的右子树

        return root1;
    }

    /**
     * 前序遍历
     * @param treeNode 二叉树
     */
    public void preOrder(TreeNode treeNode) {
        // 1. 递归终止条件
        if (treeNode == null) {
            return;
        }

        // 2. 递归过程
        System.out.println(treeNode.val);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }
}


/**
 * 二叉树节点的定义
 */
class TreeNode {
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
