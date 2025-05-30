package Algorithms.TreeTraversal;

import com.sun.source.tree.Tree;

public class InorderTraversal {
    public static void main(String args[]) {
//        TreeDataStructure treeDataStructure = new TreeDataStructure();
//        treeDataStructure.root = new Node(27);
//        treeDataStructure.root.leftChild = new Node(12);
//        treeDataStructure.root.rightChild = new Node(3);
//        treeDataStructure.root.leftChild.leftChild = new Node(44);
//        treeDataStructure.root.leftChild.rightChild = new Node(17);
//        treeDataStructure.root.rightChild.leftChild = new Node(56);
//        System.out.println("Inorder traversal: ");
//        treeDataStructure.inOrderTraversal(treeDataStructure.root);

    }

//    @AllArgs
    public class TreeNode{
        int val;

        TreeNode leftChild;
        TreeNode rightChild;

         public TreeNode(int val) {
            this.val = val;
        }


        public TreeNode(int val, TreeNode leftChild, TreeNode rightChild) {
            this.val = val;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

    public TreeNode() {
    }
}

}
