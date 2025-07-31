package LeetCode.Tree;

public class DiameterOfBinaryTree {

//    https://leetcode.com/problems/diameter-of-binary-tree/


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

        int maxdiameter = 0 ;

        public int diameterOfBinaryTree(TreeNode root) {

            dfs(root);
            return maxdiameter;

        }

        public int dfs(TreeNode root){
            if(root==null){
                return 0;
            }

            int leftheight = dfs(root.left);
            int rightheight = dfs(root.right);

            maxdiameter = Math.max(maxdiameter , leftheight+rightheight);

            return Math.max(leftheight, rightheight)+1;


        }
    }
}
