package Code.LeetCode.Tree;

public class PathSum {
//    https://leetcode.com/problems/path-sum/description/


    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null)
                return false;
            int currsum = 0;
            return traversal(root, targetSum, currsum);

        }

        public boolean traversal(TreeNode root, int targetsum, int currsum) {
            if (root == null)
                return false;

            currsum += root.val;

            if (root.left == null && root.right == null)
                return currsum == targetsum;
            return traversal(root.left, targetsum, currsum) || traversal(root.right, targetsum, currsum);
        }
    }
}
