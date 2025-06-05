package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {


//    https://leetcode.com/problems/binary-tree-preorder-traversal/description/
//    PreOrder -> Root->left -> right



    public class TreeNode {
        int val;
        PreorderTraversal.TreeNode left;
        PreorderTraversal.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, PreorderTraversal.TreeNode left, PreorderTraversal.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preOrder(root , ans);
        return ans;

    }

    public void preOrder(TreeNode root , List<Integer> ans){
        if(root==null){
            return;
        }
        ans.add(root.val);
        preOrder(root.left , ans);
        preOrder(root.right , ans);
    }

}
