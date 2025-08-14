package Code.LeetCode.Tree;

public class ConvertSortedArrayToBST {

//    https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/




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
        public TreeNode sortedArrayToBST(int[] nums) {
            return constructTree(nums , 0 , nums.length-1);



        }

        public TreeNode constructTree(int[] nums , int left , int right){
            if(left>right){
                return null;
            }

            int mid = left+(right-left)/2;

            TreeNode root = new TreeNode(nums[mid]);

            root.left = constructTree(nums , left , mid-1);
            root.right = constructTree(nums , mid+1 , right);
            return root ;



        }
    }
}
