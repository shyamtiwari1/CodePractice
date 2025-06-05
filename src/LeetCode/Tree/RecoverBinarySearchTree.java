package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree {

//    https://leetcode.com/problems/recover-binary-search-tree/description/?envType=problem-list-v2&envId=tree


    // here we're doing inorder traversal and then there arises two cases , if the misplaced nodes are adjecent or not
//    in both cases value are swapped


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

    
        public void recoverTree(TreeNode root) {

            List<TreeNode> inorderTraversal = new ArrayList<>();
            recursion(root, inorderTraversal);
            TreeNode first =  null;
            TreeNode middle = null;
            TreeNode second = null;

            for(int i = 0 ; i < inorderTraversal.size()-1 ; i ++){
                if(inorderTraversal.get(i).val>inorderTraversal.get(i+1).val){
                    if(first==null){
                        first = inorderTraversal.get(i);
                        middle = inorderTraversal.get(i+1);
                    }else{
                        second = inorderTraversal.get(i+1);
                    }

                }
            }

            if(second!=null){
                int temp = first.val;
                first.val = second.val;
                second.val = temp;
            }else{
                int temp = first.val;
                first.val = middle.val;
                middle.val = temp;

            }


        }

        public void recursion(TreeNode root , List<TreeNode> inorderTraversal){
            if(root == null){
                return ;
            }
            recursion(root.left ,inorderTraversal );
            inorderTraversal.add(root);
            recursion(root.right , inorderTraversal);

        }


    

}
