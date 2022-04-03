package BinaryTree1;

import java.util.Scanner;

import Queues.QueueEmptyException;
import Queues.QueueUsingLL;

public class BinaryTreeUse {
    public static void main(String[] args) {
        // BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        // BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(2);
        // root.left = node1;
        // BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(3);
        // root.right = node2;
        // Scanner s = new Scanner(System.in);
        // BinaryTreeNode<Integer> root = takeInput(s);
        // printTree(root);
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printTree(root);
        // System.out.println(countNodes(root));
        System.out.println("Diameter :" + diameter(root));

    }

    public static BinaryTreeNode<Integer> takeInput(Scanner s){
        int rootData;
        System.out.println("Enter root data");
        rootData = s.nextInt();

        if(rootData == -1){
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        root.left = takeInput(s);
        root.right = takeInput(s);
        return root;
    }

    public static void printTree(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }

        String toBePrinted = root.data + "";
        if(root.left != null){
            toBePrinted += "L:" + root.left.data + ","; 
        }
        if(root.right != null){
            toBePrinted += "R:" + root.right.data; 
        }
        System.out.println(toBePrinted);
        printTree(root.left);
        printTree(root.right);
    }

    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        Scanner sc = new Scanner(System.in);
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        System.out.println("Enter root data");
        int rootData = sc.nextInt();
        if(rootData == -1){
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        pendingNodes.enqueue(root);

        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> front;
            try {
                front = pendingNodes.dequeue();
            } catch (QueueEmptyException e) {
               return null;
            }
            System.out.println("Enter left child of " + front.data);
            int leftChild = sc.nextInt();
            if(leftChild != -1){
                BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(leftChild);
                pendingNodes.enqueue(child);
                front.left = child;
            }

            System.out.println("Enter right child of " + front.data);
            int rightChild = sc.nextInt();
            if(rightChild != -1){
                BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(rightChild);
                pendingNodes.enqueue(child);
                front.right = child;
            }
               
        }
        
        return root;
    }

    public static int countNodes(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }

        int ans = 1;
        ans += countNodes(root.left);
        ans += countNodes(root.right);
        return ans;
    }

    public static int diameter(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }

        int option1 = height(root.left) + height(root.right);
        int option2 = diameter(root.left);
        int option3 = diameter(root.right);

        return Math.max(option1, Math.max(option2, option3));
    }

    public static int height(BinaryTreeNode<Integer> root) {
        if(root == null){
            return 0;
        }
            int lh = height(root.left);
            int rh = height(root.right);

            return 1 + Math.max(lh, rh);
        
    }        
    
    
}
