package Code.LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

public class Pathsum2 {

//    https://leetcode.com/problems/path-sum-ii/description/


// backtracking
    // instead of using currsum we can also use targetsum directly

    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> currlist = new ArrayList<>();
            int currsum = 0 ;
            Traversal(root , targetSum , currsum , ans , currlist);

            return ans;

        }


        public void Traversal(TreeNode root , int targetsum , int currsum , List<List<Integer>>ans ,List<Integer>currlist ){

            if(root==null)return ;

            currsum+=root.val;
            currlist.add(root.val);

            if(root.left==null && root.right==null && currsum==targetsum){
                ans.add(new ArrayList<>(currlist));
            }else{
                Traversal(root.right , targetsum , currsum , ans , currlist);
                Traversal(root.left , targetsum , currsum , ans , currlist);
            }

            if(currlist.size()!=0){
                currlist.remove(currlist.size()-1);
            }


        }
    }
}
