package BinaryTree1;

import java.io.*;
import java.util.*;

class PostPair {
	int[] postOrder;
	int[] inOrder;

	public PostPair(int[] postOrder, int[] inOrder) {
		this.postOrder = postOrder;
		this.inOrder = inOrder;
	}

}

public class ConstructTreeFromPosOAndInO {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static PostPair takeInput() throws NumberFormatException, IOException {
    	int n = Integer.parseInt(br.readLine().trim());

    	int pre[] = new int[n];
    	int in[] = new int[n];

    	String[] postOrder = br.readLine().trim().split(" ");
    	String[] inOrder = br.readLine().trim().split(" ");


    	for (int i = 0; i < n; i++) {
    		pre[i] = Integer.parseInt(postOrder[i].trim());
    		in[i] = Integer.parseInt(inOrder[i].trim());
    	}

    	return new PostPair(pre, in);

    }

	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
        pendingNodes.add(null);

		while(!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> frontNode = pendingNodes.poll();

        
	        if (frontNode == null) {
	            System.out.println();

	            if (!pendingNodes.isEmpty()) {
	                pendingNodes.add(null);
	            }

	        } else {
	        	System.out.print(frontNode.data + " ");

	            if (frontNode.left != null) {
	                pendingNodes.add(frontNode.left);
	            } 

	            if (frontNode.right != null) {
	                pendingNodes.add(frontNode.right);
	            } 
	        }

		}
		
	}
    public static void main(String[] args) throws NumberFormatException, IOException {

    	PostPair input = takeInput();

    	int[] postOrder = input.postOrder;
    	int[] inOrder = input.inOrder;

    	BinaryTreeNode<Integer> root = ConstructTreeFromPosOAndInO.buildTree(postOrder, inOrder);

    	printLevelWise(root);

    }

    public static BinaryTreeNode<Integer> buildTreeHelper(int[] in, int[] pos, int inS, int inE, int posS, int posE){
        if(inS > inE){
            return null;
        }
        
        int rootData = pos[posE];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        int rootIndex = -1;
        
        for(int i = inS; i <= inE; i++){
            if(in[i] == rootData){
                rootIndex = i;
                break;
            }
        }
        
        if(rootIndex == -1){
            return null;
        }
        
        int leftInS = inS;
        int leftInE = rootIndex - 1;
        int leftPosS = posS;
        int leftPosE = leftInE - leftInS + leftPosS;
        int rightInS = rootIndex + 1;
        int rightInE = inE;
        int rightPosS = leftPosE + 1;
        int rightPosE = posE - 1;
        
        root.left = buildTreeHelper(in, pos, leftInS, leftInE, leftPosS, leftPosE);
        root.right = buildTreeHelper(in, pos, rightInS, rightInE, rightPosS, rightPosE);
        
        return root;
    }
    
	public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
		return buildTreeHelper(inOrder, postOrder, 0, inOrder.length - 1, 0, postOrder.length -1);
	}
}
