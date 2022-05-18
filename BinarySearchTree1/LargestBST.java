package BinarySearchTree1;
import java.io.*;
import java.util.*;

public class LargestBST {

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
		System.out.println(LargestBST.largestBSTSubtree(root));
	}
    static class Pair{
        int min;
        int max;
        boolean isBST;
        int height;
    }
	public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		Pair ans = helperlargestBSTSubtree(root);
        return ans.height;
	}
    public static Pair helperlargestBSTSubtree(BinaryTreeNode<Integer> root){
        if(root == null){
            Pair output = new Pair();
            output.min = Integer.MAX_VALUE;
            output.max = Integer.MIN_VALUE;
            output.isBST = true;
            output.height = 0;
            return output;
        }
        
        Pair left = helperlargestBSTSubtree(root.left);
        Pair right = helperlargestBSTSubtree(root.right);
        
        int min = Math.min(root.data, Math.min(left.min, right.min));
        int max = Math.max(root.data, Math.max(left.max, right.max));
        
        Pair output = new Pair();
        output.min = min;
        output.max = max;
        
         output.isBST = left.max < root.data && right.min > root.data 
                       && left.isBST && right.isBST;
        
        if(output.isBST){
            output.height = Math.max(left.height , right.height) + 1;
        }else {
            output.height = Math.max(left.height, right.height);
        }
        
        return output;
        
    }


}
