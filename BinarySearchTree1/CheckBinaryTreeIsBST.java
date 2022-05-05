package BinarySearchTree1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CheckBinaryTreeIsBST {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
		Queue<BinaryTreeNode<Integer>>  pendingNodes = new LinkedList<BinaryTreeNode<Integer>>(); 
		int start = 0;

		String[] nodeDatas = br.readLine().trim().split(" ");

		if (nodeDatas.length == 1) {
			return null;
		}
		
		int rootData = Integer.parseInt(nodeDatas[start]);
		start += 1;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.add(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.poll();
			} catch (Exception e) {
				return null;
			}

			int leftChildData = Integer.parseInt(nodeDatas[start]);
			start += 1;

			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.add(leftChild);
			}

			int rightChildData = Integer.parseInt(nodeDatas[start]);
			start += 1;

			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.add(rightChild);
			}
		}

		return root;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BinaryTreeNode<Integer> root = takeInput();

        boolean ans = CheckBinaryTreeIsBST.isBST(root);
        
        System.out.println(ans);

	}

    public static int minimum(BinaryTreeNode<Integer> root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        
        return Math.min(root.data , Math.min(minimum(root.left), minimum(root.right)));
    }
    
    public static int maximum(BinaryTreeNode<Integer> root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        
        return Math.max(root.data , Math.max(maximum(root.left), maximum(root.right)));
    }
    
	public static boolean isBST(BinaryTreeNode<Integer> root) {
		if(root == null){
            return true;
        }
		
        int leftMax = maximum(root.left);
        int rightMin = minimum(root.right);
        
        if(root.data <= leftMax){
            return false;
        }
        if(root.data > rightMin){
            return false;
        } 
        
        boolean isLeftBST = isBST(root.left);
		boolean isRightBST = isBST(root.right);
        
        if(isLeftBST && isRightBST){
            return true;
        }else {
           return false; 
        }
	}
}