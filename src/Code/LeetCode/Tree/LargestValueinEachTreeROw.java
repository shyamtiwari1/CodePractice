package Code.LeetCode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValueinEachTreeROw {

//    https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/





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
        public List<Integer> largestValues(TreeNode root) {
            if(root==null){
                return new ArrayList<>();
            }

            Queue<TreeNode> queue = new LinkedList<>();


            queue.add(root);
            List<Integer> ans = new ArrayList<>();

            while(!queue.isEmpty()){
                int n = queue.size();
                int max = Integer.MIN_VALUE;
                while(n!=0){
                    TreeNode x = queue.poll();
                    max = Math.max(max , x.val);
                    if(x.left!=null){
                        queue.add(x.left);
                    }
                    if(x.right!=null){
                        queue.add(x.right);
                    }
                    n--;

                }
                ans.add(max);
            }
            return ans;

        }
    }
}
