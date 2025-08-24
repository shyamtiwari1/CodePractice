package Code.LeetCode.Tree;

public class SubTreeOfAnother {

//    https://leetcode.com/problems/subtree-of-another-tree/





    class Solution {

        // this is not optimal O(m*n)
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if(root==null && subRoot==null)return true;
            if(isSameTree(root,subRoot))return true;
            if(root!=null){
                return isSubtree(root.left , subRoot) || isSubtree(root.right,subRoot);
            }else{
                return false;
            }


        }

        public boolean isSameTree(TreeNode p , TreeNode q){
            if(p==null && q==null)return true;
            if(p==null || q==null)return false;

            return p.val==q.val &&isSameTree(p.right, q.right) && isSameTree(p.left , q.left);

        }
    }
}
