package BinarySearchTree1;

import java.io.*;
import java.util.*;

public class PairSumBST {

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
		int s = Integer.parseInt(br.readLine());
		PairSumBST.printNodesSumToS(root,s);
	}
    public static int count(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        return count(root.left) + count(root.right) + 1;
    }
	public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
		if(root == null){
            return;
        }
        
        int totalCount = count(root);
        int count = 0;
        
        Stack<BinaryTreeNode<Integer>> inorder = new Stack<BinaryTreeNode<Integer>>();
        Stack<BinaryTreeNode<Integer>> revInorder = new Stack<BinaryTreeNode<Integer>>();
        
        BinaryTreeNode<Integer> temp = root;
    	while(temp != null){
            inorder.push(temp);
            temp = temp.left;
        }
        temp = root;
        while(temp != null){
            revInorder.push(temp);
            temp = temp.right;
        }
        
        while(count < totalCount -1){
            BinaryTreeNode<Integer> top1 = inorder.peek();
            BinaryTreeNode<Integer> top2 = revInorder.peek();
            if(top1.data + top2.data == s){
                System.out.println(top1.data + " " + top2.data);
                
                BinaryTreeNode<Integer> top = top1;
                inorder.pop();
                count++;
                if(top.right !=null){
                    top = top.right;
                    while(top != null){
                        inorder.push(top);
                        top = top.left;
                    }
                }
                
                top = top2;
                revInorder.pop();
                count++;
                if(top.left != null){
                    top = top.left;
                    while(top != null){
                        revInorder.push(top);
                        top = top.right;
                    }
                }
                
            }else if(top1.data + top2.data > s){
                    BinaryTreeNode<Integer> top = top2;
                	revInorder.pop();
                	count++;
                	if(top.left != null){
                    	top = top.left;
                    	while(top != null){
                        	revInorder.push(top);
                        	top = top.right;
                    	}
                	}
            }else {
                BinaryTreeNode<Integer> top = top2;
            	top = top1;
               	inorder.pop();
                count++;
                if(top.right !=null){
                    top = top.right;
                    while(top != null){
                        inorder.push(top);
                        top = top.left;
                    }
                } 
            }
            
        }
        
	}
}