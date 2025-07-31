package LeetCode.Tree;

public class ValidateBinarySearchTree {

//    https://leetcode.com/problems/validate-binary-search-tree/description/



//      Definition for a binary tree node.


    // here we're checking that all the values of left subtree are less than that of root node and right subtree are greater than that of root node
//    then recursively updating min and max the value of left subtree and right subtree to their node
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        public boolean isValidBST(TreeNode root) {

            return validateBST(root , Long.MAX_VALUE, Long.MIN_VALUE);

        }

        public boolean validateBST(TreeNode root , Long max , Long min){
            if(root==null){
                return true;
            }
            if(root.val<=min || root.val>=max){
                return false;
            }
            return validateBST(root.left , (long)root.val , min) && validateBST(root.right , max , (long)root.val);
        }
    }
}
