package LeetCode.Tree;

public class MaximumDepthOfBinaryTree {

//    https://leetcode.com/problems/maximum-depth-of-binary-tree/description/



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
        public int maxDepth(TreeNode root) {

            return preOrderTraversal(root);

        }

        public int preOrderTraversal(TreeNode root){
            if(root==null){
                return 0;
            }
            return 1+ Math.max(preOrderTraversal(root.left) , preOrderTraversal(root.right));



        }
    }
}
