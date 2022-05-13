package BinarySearchTree1;

import java.io.*;
import java.util.*;



public class FindPathInBST {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static BinaryTreeNode<Integer> takeInput() throws IOException {
		st = new StringTokenizer(br.readLine());
		int rootData = Integer.parseInt(st.nextToken());
		if (rootData == -1) {
			return null;
		}
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.add(root);

		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.poll();
			} catch (Exception e) {
				return null;
			}
			int leftChildData = Integer.parseInt(st.nextToken());
			if (leftChildData != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.add(leftChild);
			}
			int rightChildData = Integer.parseInt(st.nextToken());
			if (rightChildData != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.add(rightChild);
			}
		}
		return root;
	}

	public static void main(String[] args) throws IOException {
		BinaryTreeNode<Integer> root = takeInput();
		int k = Integer.parseInt(br.readLine());
		ArrayList<Integer> output = FindPathInBST.getPath(root, k);
		if(output != null) {
			for(int i : output) {
				System.out.print(i+" ");
			}
		}
	}

    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
		if(root == null){
            return null;
        }
        ArrayList<Integer> output = new ArrayList<>();
        if(root.data == data){
            output.add(root.data);
            return output;
        }

        ArrayList<Integer> leftOutput =  getPath(root.left, data);
        if(leftOutput != null){
            leftOutput.add(root.data);
            return leftOutput;
        }

        ArrayList<Integer> rightOutput = getPath(root.right, data);
        if(rightOutput != null){
            rightOutput.add(root.data);
            return rightOutput;
        }else {
            return null;
        }
	}

}
