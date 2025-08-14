package Code.LeetCode.Tree;

import java.util.*;

import java.util.LinkedList;

public class maximumWidthOfBinaryTree {
//    https://leetcode.com/problems/maximum-width-of-binary-tree/description/




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
        public int widthOfBinaryTree(TreeNode root) {

            Queue<Pair<TreeNode , Integer>> queue = new LinkedList<>();
            queue.offer(new Pair<>(root, 0));

            int ans = 0 ;

            while(!queue.isEmpty()){
                int size = queue.size();
                int first = queue.peek().getValue();
                int last = first ;
                for(int i = 0 ; i <size;i++){

                    Pair<TreeNode, Integer> pair = queue.poll();
                    TreeNode node = pair.getKey();
                    int index  = pair.getValue();
                    last = index;
                    if(node.left !=null){
                        queue.offer(new Pair<>(node.left , 2*index+1));
                    }
                    if(node.right!=null){
                        queue.offer(new Pair<>(node.right , 2*index+2));
                    }
                }
                ans = Math.max(ans , (int)(last-first+1));

            }

            return ans;

        }

        static class Pair<K, V> {
            private final K key;
            private final V value;
            public Pair(K key, V value) { this.key = key; this.value = value; }
            public K getKey() { return key; }
            public V getValue() { return value; }
        }
    }
}
