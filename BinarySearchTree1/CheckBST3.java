package BinarySearchTree1;

import BinaryTree1.BinaryTreeNode;

public class CheckBST3 {
    
    public static boolean isBST3(BinaryTreeNode<Integer> root, int min, int max){
        if(root == null){
            return false;
        }

        if(root.data < min  || root.data > max){
            return false;
        }

         boolean isLeftOk = isBST3(root, min, root.data - 1);
         boolean isRightOk = isBST3(root, root.data, max);
         return isLeftOk && isRightOk;
    }
}
