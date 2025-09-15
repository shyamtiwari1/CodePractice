package Code.LeetCode.Tree;

public class LongestZigZagPathInBinaryTree {


//    https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/


    class Solution {

        int maxlen = 0 ;
        public int longestZigZag(TreeNode root) {
            if(root==null) return 0 ;
            dfs(root.left , 1 , true);
            dfs(root.right , 1, false);
            return maxlen;

        }


        public void dfs(TreeNode root , int len , boolean isLeft){
            if(root==null)return ;

            maxlen = Math.max(maxlen , len);

            if(isLeft){
                dfs(root.right , len+1 , false);
                dfs(root.left , 1 , true);
            }else{
                dfs(root.left, len+1 , true);
                dfs(root.right , 1,false);
            }


        }
    }
}


