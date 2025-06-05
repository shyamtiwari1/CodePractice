package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {

    //postOrder -> left -> right-> root
//    https://leetcode.com/problems/binary-tree-postorder-traversal/description/




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


        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            postOrder(root , ans);
            return ans;


        }

        public void postOrder(TreeNode root , List<Integer>ans){
            if(root==null){
                return ;
            }
            postOrder( root.left , ans);
            postOrder( root.right , ans);
            ans.add(root.val);

        }





}
