package Code.LeetCode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

//    https://leetcode.com/problems/binary-tree-level-order-traversal/description/?envType=problem-list-v2&envId=tree




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

    
        public List<List<Integer>> levelOrder(TreeNode root) {


            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) return ans;

            queue.add(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                List<Integer> level = new ArrayList<>();
                for(int i = 0; i <size ;i++){
                    TreeNode x = queue.poll();
                    level.add(x.val);
                    if(x.left!=null) {queue.add(x.left);}
                    if(x.right!=null){queue.add(x.right);}
                }

                ans.add(level);

            }
            return ans;
            
    }



}
