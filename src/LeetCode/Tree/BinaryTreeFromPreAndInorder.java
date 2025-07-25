package LeetCode.Tree;

import java.util.HashMap;

public class BinaryTreeFromPreAndInorder {

//    https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/




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

    
        public TreeNode buildTree(int[] preorder, int[] inorder) {

            HashMap<Integer, Integer> inOrderIndexMap = new HashMap<>();

            for(int i = 0 ; i < inorder.length; i++){
                inOrderIndexMap.put(inorder[i] , i);

            }
            return recursion(preorder , 0,preorder.length-1, inorder, 0 , inorder.length-1 , inOrderIndexMap);

        }

        public TreeNode recursion(int[] preorder,int preStart , int preEnd ,  int[] inorder , int inStart , int inEnd , HashMap<Integer, Integer>inOrderIndexMap){

            if(preStart>preEnd || inStart>inEnd){
                return null;
            }
            int rootVal = preorder[preStart];
            TreeNode root = new TreeNode(rootVal);
            int inRootIndex = inOrderIndexMap.get(rootVal);

            int numsLeft = inRootIndex-inStart;

            root.left = recursion( preorder, preStart+1 ,  preStart+numsLeft ,   inorder ,  inStart ,  inRootIndex , inOrderIndexMap);
            root.right = recursion( preorder, preStart+numsLeft+1 ,  preEnd ,   inorder ,  inRootIndex+1 ,  inEnd , inOrderIndexMap);
            return root;
    }
}
