package BinaryTree1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PrintTree {

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
		
		PrintTree.printLevelWise(root);
	}
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
		if(root == null){
        	return;
        }
        Queue<BinaryTreeNode<Integer>>  pendingNodes = new LinkedList<BinaryTreeNode<Integer>>(); 
        pendingNodes.add(root);
        
        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> front;
			try {
				front = pendingNodes.poll();
			} catch (Exception e) {
				return;
			}
            
            if(front == null){
                if(pendingNodes.isEmpty()){
                    break;
                }
            	System.out.println();
            }else{   
				System.out.print(front.data + ":");
                if(front.left != null){
        			pendingNodes.add(front.left);
					System.out.print("L:" + front.left.data + ",");            
					
                }else {
                    System.out.print("L:" + "-1" + ",");
                }
                
                if(front.right != null){
            		pendingNodes.add(front.right);
                    System.out.print("R:" + front.right.data); 
                   
        		}else {
                    System.out.print("R:" + "-1");
                }
                
            }
            System.out.println();
        }
        
	}
}