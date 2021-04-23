package com.kc.androidlib.algo;

import android.util.Log;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _236$_二叉树的最近公共祖先 {

    /**
     *        1
     *     2    7
     *   3  4
     *     5  6
     *
     */
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


//        lowerstCommonAncestor(treeNode, treeNode.left.right.left,  treeNode.right );
//        System.out.println(  ans.value );

//        lowerstCommonAncestor(treeNode, treeNode.left.right.left,  treeNode.left.right.right );
//        System.out.println(  ans.value );


        TreeNode treeNode1 = lowerstCommonAncestor2(treeNode, treeNode.left.right.left, treeNode.right);
        System.out.println(  treeNode1.value );

        TreeNode treeNode2 = lowerstCommonAncestor2(treeNode, treeNode.left.right.left, treeNode.left.right.right);
        System.out.println(  treeNode2.value );
    }

    /**
     * 后续遍历，先看左边节点是不是跟节点；再看右边节点是不是p q节点
     */
    private static TreeNode ans;
    public static boolean lowerstCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson =  lowerstCommonAncestor(root.left, p, q);
        System.out.println( "root.left:" + (root.left == null ? "null":root.left.value) + "  is son:" + lson);

        boolean rson =  lowerstCommonAncestor(root.right, p, q);
        System.out.println("root.right:" + (root.right == null ? "null":root.right.value) + "  is son:" + rson);

        if ( (lson && rson) ||  ((root.value == p.value || root.value == q.value) && (lson || rson))) {

            System.out.println("result:" + root.value);
            ans = root;
        }

        System.out.println("******current:" +  root.value  + "  result:"  + (lson || rson || (root.value == p.value || root.value == q.value)) );
        return lson || rson || (root.value == p.value || root.value == q.value);
    }


    /**
     * 存储节点
     * @param root
     * @param p
     * @param q
     * @return
     */

    static Map<Integer, TreeNode> parent = new HashMap<>();
    static Set<Integer> visited = new HashSet<>();
    public static TreeNode lowerstCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        saveTree(root);

        while (p != null) {
            visited.add(p.value);
            p = parent.get(p.value);
        }

        while (q != null) {
            if (visited.contains(q.value)) {
                return q;
            }
            q = parent.get(q.value);
        }
        return null;

    }

    public static void saveTree(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.value, root);
            saveTree(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.value, root);
            saveTree(root.right);
        }
    }
}
