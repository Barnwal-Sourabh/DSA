package BinarySearchTree1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class LCAofBT {

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
        String[] strNums = br.readLine().trim().split(" ");
        int a = Integer.parseInt(strNums[0]);
        int b = Integer.parseInt(strNums[1]);

		int h = LCAofBT.getLCA(root, a, b);

		System.out.println(h);
	}

    static int getLCA(BinaryTreeNode<Integer> root, int n1, int n2) {
		if(root == null){
            return -1;
        }
        if(root.data == n2 || root.data == n1 ){
            return root.data;
        }
        int a = getLCA(root.left, n1, n2);
        int b = getLCA(root.right, n1, n2);
        if(a == -1 && b == -1){
            return -1;
        }else if(a != -1 && b == -1){
            return a;
        }else if(a == -1 && b != -1){
            return b;
        }else {
            return root.data;
        }
		
	}
}
