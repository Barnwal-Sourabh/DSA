package Tree;

import java.util.*;

public class FindSecondLargestNode {

	

	static Scanner s = new Scanner(System.in);

	public static TreeNode<Integer> takeInputLevelWise(){
		Queue<TreeNode<Integer>> pendingNodes = new LinkedList<TreeNode<Integer>>();  // Queue of node that are entered themselves but their children aren't added yet
		int rootData = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.poll();
				int numChild = s.nextInt();
				for(int i = 0 ; i < numChild; i++){
					int currentChild = s.nextInt();
					TreeNode<Integer> childNode = new TreeNode<Integer>(currentChild);
					pendingNodes.add(childNode);
					currentNode.children.add(childNode);
				}
			} catch (Exception e) {
			}
		}
		return root;
	}


	public static void main(String[] args) {
		TreeNode<Integer> root =  takeInputLevelWise();
		TreeNode<Integer> ans = FindSecondLargestNode.findSecondLargest(root);
		if(ans == null){
			System.out.println(Integer.MIN_VALUE);
		}else{
			System.out.println(ans.data);
		} 
	}

    static int largestNode = 0;
    public static void largest(TreeNode<Integer> root){
        if(root.data > largestNode){
            largestNode = root.data;
        }
        for(int i = 0; i < root.children.size(); i++){
            largest(root.children.get(i));
        }
    } 
    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
        // Write your code here
        largest(root);
           return findSmallerNode(root,largestNode);

    }
    public static TreeNode<Integer> findSmallerNode(TreeNode<Integer> root, int n){

        // Write your code here
        if(root == null)
        {
            return null;
        }

        int nearest = Integer.MIN_VALUE;
        TreeNode<Integer> nearestNode = null;
        TreeNode<Integer> ret = null;

        if(root.data < n )
        {
            nearestNode = root;
            nearest = root.data;
        }
        for(int i = 0; i < root.children.size(); i++)
        {
            ret = findSmallerNode(root.children.get(i),n);
            if(ret!=null && ret.data>nearest)
            {
                nearestNode = ret;
                nearest = ret.data;
            }
        }
        return nearestNode;
    
    
    
    }

}

