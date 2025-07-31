package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

public class KthsmallestElementInBinaryTree {


//    https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/




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
        int count = 0 ;
        int res = -1;
        public int kthSmallest(TreeNode root, int k) {



            List<Integer> ans   =new ArrayList<>();
            inorder(root,k );
            return res;

        }

        public void inorder(TreeNode root , int k ){
            if(root == null){
                return ;
            }
            inorder(root.left , k  );
            count++;
            if(count ==k){
                res =  root.val;
                return ;
            }
            inorder(root.right , k);

        }


    }
}
