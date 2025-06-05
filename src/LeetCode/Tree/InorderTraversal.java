package LeetCode.Tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public static void main(String args[]) {
//        TreeDataStructure treeDataStructure = new TreeDataStructure();
//        treeDataStructure.root = new Node(27);
//        treeDataStructure.root.leftChild = new Node(12);
//        treeDataStructure.root.rightChild = new Node(3);
//        treeDataStructure.root.leftChild.leftChild = new Node(44);
//        treeDataStructure.root.leftChild.rightChild = new Node(17);
//        treeDataStructure.root.rightChild.leftChild = new Node(56);
//        System.out.println("Inorder traversal: ");
//        treeDataStructure.inOrderTraversal(treeDataStructure.root);

    }

//    @AllArgs
//https://leetcode.com/problems/binary-tree-inorder-traversal/


    //inorder --> left -> root -> right
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans   =new ArrayList<>();
            inorder(root , ans);
            return ans;


        }
        public void inorder(TreeNode root , List<Integer> ans){
            if(root == null){
                return ;
            }
            inorder(root.left , ans);
            ans.add(root.val);
            inorder(root.right, ans);

    }

}
