package com.datastructure.tree;

public class LowestCommonAncestorBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val &&
                    root.val > q.val)
                root = root.left;
            else if (root.val < p.val &&
                    root.val < q.val)
                root = root.right;
            else break;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(6);
        head.left = new TreeNode(2);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(0);
        head.left.right = new TreeNode(4);
        head.left.right.left = new TreeNode(3);
        head.left.right.right = new TreeNode(5);
        head.right.left = new TreeNode(7);
        head.right.right = new TreeNode(9);
        LowestCommonAncestorBinarySearchTree l = new LowestCommonAncestorBinarySearchTree();
        l.lowestCommonAncestor(head, head.left.left, head.left.right.right);
    }

    static class TreeNode {
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
}
