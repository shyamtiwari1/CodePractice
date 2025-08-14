package Code.LeetCode.Tree;

public class SymmetricTree {
//    https://leetcode.com/problems/symmetric-tree/description/

    // first check value of child nodes , then call recursively for
//    & check for (child1 .left , child2.right) && (child1 .right , child2.left)


//      Definition for a binary tree node.
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

    public boolean isSymmetric(TreeNode root) {
            return isMirror(root.left , root.right);

        }
        public boolean isMirror(TreeNode root1 , TreeNode root2){

            if(root1==null && root2==null){
                return true;
            }
            if(root1==null || root2==null){
                return false;
            }
            if(root1.val==root2.val && isMirror( root1.right ,  root2.left) && isMirror( root2.right ,  root1.left)){
                return true;
            }
            return false;




    }
}
