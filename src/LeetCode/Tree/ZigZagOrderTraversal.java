package LeetCode.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigZagOrderTraversal {
//    https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/





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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if(root==null){
                return ans;
            }

            Deque<TreeNode> dq = new LinkedList<>();


            dq.addFirst(root);
            int x = 0 ;
            while(!dq.isEmpty()){
                int n = dq.size();
                List<Integer> temp = new ArrayList<>();
                if(x==0){
                    while(n!=0){
                        TreeNode curr = dq.pollFirst();
                        temp.add(curr.val);
                        if(curr.left!=null){
                            dq.addLast(curr.left);
                        }
                        if(curr.right!=null){
                            dq.addLast(curr.right);
                        }
                        n--;
                    }

                }else{
                    while(n!=0){
                        TreeNode curr = dq.pollLast();
                        temp.add(curr.val);
                        if(curr.right!=null){
                            dq.addFirst(curr.right);
                        }
                        if(curr.left!=null){
                            dq.addFirst(curr.left);
                        }
                        n--;

                    }

                }
                ans.add(temp);
                x = 1-x;
            }

            return ans;

        }
    }
}
