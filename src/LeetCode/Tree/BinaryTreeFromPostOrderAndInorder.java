package LeetCode.Tree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPostOrderAndInorder {


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


        public TreeNode buildTree(int[] inorder, int[] postorder) {
            Map<Integer , Integer> mpp = new HashMap<>();
            for(int i = 0 ; i < inorder.length;i++){
                mpp.put(inorder[i] , i);
            }
            return build(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, mpp);
        }

        public TreeNode build(int[] postorder,  int poststart, int postend ,int[] inorder,int instart, int inend,Map<Integer , Integer> mpp){
            if(poststart>postend || instart>inend){
                return null;
            }
            int rootval = postorder[postend];
            TreeNode root = new TreeNode(rootval);
            int inrootindex = mpp.get(rootval);
            int numsleft =  inrootindex - instart;

            root.left = build(postorder, poststart, poststart + numsleft - 1,
                    inorder, instart, inrootindex - 1, mpp);

            root.right = build(postorder, poststart + numsleft, postend - 1,
                    inorder, inrootindex + 1, inend, mpp);
            return root;

        }
    }

