package BinarySearchTree1;

import java.io.*;
import java.util.*;

public class PrintNodeAtdistanceK {

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
		String[] target_k = br.readLine().trim().split(" ");

		int target = Integer.parseInt(target_k[0].trim());
		int k = Integer.parseInt(target_k[1].trim());

		PrintNodeAtdistanceK.nodesAtDistanceK(root, target, k);
	}
    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root,int node,int k) {
        nodesAtDistanceKWithRootDistance(root, node, k);
    }
    public static int nodesAtDistanceKWithRootDistance(BinaryTreeNode<Integer> root,int node,int k) {
        if(root==null)
            return -1;

        if(root.data == node) {

            printNodesDown(root,k);
            return 0;
        }
        int leftHeight = nodesAtDistanceKWithRootDistance(root.left, node, k);
        if(leftHeight!=-1) {
            if(leftHeight+1 == k) {
                System.out.println(root.data);
            }
            else {
                printNodesDown(root.right, k-leftHeight-2);
                
            }
            return leftHeight+1;
        }
        int rightHeight = nodesAtDistanceKWithRootDistance(root.right, node, k);
        if(rightHeight!=-1) {
            if(rightHeight+1 == k) {
                System.out.println(root.data);
            }
            else {
                printNodesDown(root.left, k-rightHeight-2);
            }
            return rightHeight+1;
        }
        return -1;

    }
    private static void printNodesDown(BinaryTreeNode<Integer> root, int k) {
        if(root==null) {
            return ;
        }
        if(k==0) {
            System.out.println(root.data);
            return ;
        }
        printNodesDown(root.left, k-1);
        printNodesDown(root.right, k-1);
	}
}
