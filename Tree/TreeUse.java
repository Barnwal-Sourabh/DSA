package Tree;



import java.util.Scanner;

import Queues.QueueEmptyException;
import Queues.QueueUsingLL;



public class TreeUse {

    public static TreeNode<Integer> takeInput(Scanner s){
        int n;
       
        System.out.println("Enter next node data");
        n = s.nextInt();
        TreeNode<Integer> root = new TreeNode<Integer>(n);
        System.out.println("Enter number of children for " + n);
        int chilCount = s.nextInt();

        for(int i = 0; i<chilCount; i++){
            TreeNode<Integer> child = takeInput(s);
            root.children.add(child);
        }
        
        return root;
    }
    public static void print(TreeNode<Integer> root){
        String s = root.data + ":";
        
        for(int i = 0; i<root.children.size();i++){
            s = s + root.children.get(i).data + ",";
        }
        System.out.println(s);
        for(int i = 0; i<root.children.size(); i++){
            print(root.children.get(i));
        }


    }

    public static TreeNode<Integer> takeInputLevelwise(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter root data");
        int rootData = s.nextInt();
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        TreeNode<Integer> root = new TreeNode<Integer>(rootData);
        pendingNodes.enqueue(root);

        while(!pendingNodes.isEmpty()){
           try {
            TreeNode<Integer> frontNode = pendingNodes.dequeue();
            System.out.println("Enter the number of children of "+ frontNode.data);
            int numchildren = s.nextInt();
            for(int i = 0; i < numchildren; i++){
                System.out.println("Enter " + (i+1) + "th child of "+frontNode.data);
                int child = s.nextInt();
                TreeNode<Integer> childNode = new TreeNode<Integer>(child);
                frontNode.children.add(childNode);
                pendingNodes.enqueue(childNode);
            }

        } catch (QueueEmptyException e) {
            //Shoudn't come here
        }

        }

        return root;
        
    }

    public static void printLevelWise(TreeNode<Integer> root){
		QueueUsingLL<TreeNode<Integer>> queue = new QueueUsingLL<>();
        queue.enqueue(root);
        queue.enqueue(null);
        
        while(!queue.isEmpty()){
            try{
            TreeNode<Integer> frontNode = queue.dequeue();
			if(frontNode == null){
                if(queue.isEmpty()){
                    break;
                }
                System.out.println();
            	queue.enqueue(null);
            }else {
                System.out.print(frontNode.data +" ");
                for(int i = 0; i<frontNode.children.size(); i++){
                    queue.enqueue(frontNode.children.get(i));
                }
            }
                
            } catch (QueueEmptyException e) {
                //shouldn't come here
			}
                
        }    
        
        

	}

    public static int sumOfAllNode(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
		int sum = root.data;
        
        for(int i = 0; i<root.children.size(); i++){
            sum += sumOfAllNode(root.children.get(i));
        }
        return sum;
	}

    public static int numNodes(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int count = 1;
        for(int i = 0; i<root.children.size(); i++){
            count += numNodes(root.children.get(i));
        }
        return count;
    }

    public static int largest(TreeNode<Integer> root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        
        int ans = root.data;
        for(int i=0; i<root.children.size(); i++){
            int childLargest = largest(root.children.get(i));
            if(childLargest > ans){
                ans = childLargest;
            }
        }  
        return ans;
    }

    public static int numNodeGreater(TreeNode<Integer> root,int x){
		if(root == null){
            return 0;
        }
		int count = 0;
        for(int i = 0; i < root.children.size(); i++){
           	count += numNodeGreater(root.children.get(i), x);
        }
        if(root.data > x){
                count++;
		}
        return count;
	}

    public static int getHeight(TreeNode<Integer> root){
		int height = 0;
        for(int i = 0; i<root.children.size(); i++){
            int childHeight = getHeight(root.children.get(i));
            if(childHeight > height){
                height = childHeight;
            }
        }
        return height+1;
	}

    public static void main(String[] args) {
        // Scanner s = new Scanner(System.in);
        // TreeNode<Integer> root = takeInput(s);
        TreeNode<Integer> root = takeInputLevelwise();
        printLevelWise(root);
        int count = numNodes(root);
        int sum = sumOfAllNode(root);
        System.out.println();
        System.out.println("Total number of node is : "+ count);
        System.out.println("Sum of all Nodes: "+ sum);
        System.out.println("Largest Node in tree : "+largest(root));
        // TreeNode<Integer> root = new TreeNode<Integer>(4);
        // TreeNode<Integer> node1 = new TreeNode<Integer>(2);
        // TreeNode<Integer> node2 = new TreeNode<Integer>(3);
        // TreeNode<Integer> node3 = new TreeNode<Integer>(5);
        // TreeNode<Integer> node4 = new TreeNode<Integer>(6);

        // root.children.add(node1);
        // root.children.add(node2);
        // root.children.add(node3);
        // node2.children.add(node4);
        
    }
}
