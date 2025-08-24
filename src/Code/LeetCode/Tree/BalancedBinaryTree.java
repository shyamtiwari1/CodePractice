package Code.LeetCode.Tree;

public class BalancedBinaryTree {

//    https://leetcode.com/problems/balanced-binary-tree/description/



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
        public boolean isBalanced(TreeNode root) {
            return checkheight(root)!=-1;

        }
        public int checkheight(TreeNode root){
            if(root==null){
                return 0 ;
            }
            int leftheight = checkheight(root.left);
            if(leftheight ==-1){
                return -1;
            }
            int rightheight = checkheight(root.right);
            if(rightheight==-1){
                return -1;
            }
            if(Math.abs(leftheight-rightheight)>1){
                return -1;
            }else{
                return 1+Math.max(leftheight , rightheight);
            }
        }
    }
}
