package com.kc.androidlib.algo;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _104_二叉树深度 {

    @Test
    public void method1() {
        TreeNode treeNode = new TreeNode();
        treeNode.value = 1;

        treeNode.left = new TreeNode();
        treeNode.left.value = 2;

        treeNode.left.left = new TreeNode();
        treeNode.left.left.value = 3;

        treeNode.left.right = new TreeNode();
        treeNode.left.right.value = 4;

        treeNode.left.right.left = new TreeNode();
        treeNode.left.right.left.value = 5;

        treeNode.left.right.right = new TreeNode();
        treeNode.left.right.right.value = 6;

        treeNode.right = new TreeNode();
        treeNode.right.value = 7;

        System.out.println(maxDepth2(treeNode));
    }

    /**
     * 深度优先
     * @param root
     * @return
     * 时间： O(n)   空间 O(heigh)
     */
   public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
   }


    /**
     * 广度优先算法
     * @param root
     * @return
     *
     * 时间O(n)    空间最坏o(n)
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }

            ans++;
        }
        return ans;
    }

}
