package com.kc.androidlib.algo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _235_二叉搜索树的最近公共祖先 {


    /**
     *       4
     *     2      6
     *  1   3  5   7
     **/
    @Test
    public void method1() {
        TreeNode treeNode = new TreeNode();
        treeNode.value = 4;

        treeNode.left = new TreeNode();
        treeNode.left.value = 2;

        treeNode.left.left = new TreeNode();
        treeNode.left.left.value = 1;

        treeNode.left.right = new TreeNode();
        treeNode.left.right.value = 3;

        treeNode.right = new TreeNode();
        treeNode.right.value = 6;

        treeNode.right.left = new TreeNode();
        treeNode.right.left.value = 5;

        treeNode.right.right = new TreeNode();
        treeNode.right.right.value = 7;


        TreeNode treeNode1 = lowestCommonAncestor(treeNode, treeNode.left.left, treeNode.left.right);
        System.out.println(treeNode1.value);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path_p = getPath(root, p);
        List<TreeNode> path_q = getPath(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < path_p.size() && i < path_q.size(); ++i) {
            if (path_p.get(i) == path_q.get(i)) {
                ancestor = path_p.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    public List<TreeNode> getPath(TreeNode  root, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            if (target.value < node.value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        path.add(node);
        return path;
    }




}
