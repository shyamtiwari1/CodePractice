package LeetCode.Tree;

public class LowestCommonAncestorBST {

//    https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree



    // here we're checking if both p & q lies on the same side of current root , call for that side root as it is BST
//     if both lies opposite side of node , as soon as we first encounter that kind of node we return recursively
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            if(root==null){
                return null;
            }
            if(root.val >p.val && root.val > q.val){
                return lowestCommonAncestor(root.left , p , q);

            }

            if(root.val <p.val && root.val < q.val){
                return lowestCommonAncestor(root.right, p , q);
            }
            return root;

        }
    }
}
