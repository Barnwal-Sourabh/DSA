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
        s.close();
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

    // // public static int largest(TreeNode<Integer> root){
    //     if(root == null){
    //         return Integer.MIN_VALUE;
    //     }
        
    //     int ans = root.data;
    //     for(int i=0; i<root.children.size(); i++){
    //         int childLargest = largest(root.children.get(i));
    //         if(childLargest > ans){
    //             ans = childLargest;
    //         }
    //     }  
    //     return ans;
    // }

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
// 1 2 2 3 2 4 5 -1 -1 -1 
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

    public static void printAtK(TreeNode<Integer> root, int k){
        if(k < 0){
            return;
        }
        if(k == 0){
            System.out.println(root.data);
            return;
        }
        
        for(int i = 0; i<root.children.size(); i++){
            printAtK(root.children.get(i), k-1);
        }
    }

    public static int countLeafOfNodes(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int countLeaf = 0;
        if(root.children.size() == 0){
            countLeaf++;
        }

        for(int i = 0; i<root.children.size(); i++){
            countLeaf += countLeafOfNodes(root.children.get(i));
        }
        return countLeaf;
    }

    public static void preOrder(TreeNode<Integer> root){
        if(root == null){
            return;
        }
        System.out.print(root.data +" ");

        for(int i = 0; i<root.children.size(); i++){
            preOrder(root.children.get(i));
        }
    }
    public static void postOrder(TreeNode<Integer> root){
        if(root == null){
            return;
        }
     

        for(int i = 0; i<root.children.size(); i++){
            postOrder(root.children.get(i));
        }
        System.out.print(root.data +" ");
    }

    public static boolean checkIfContainsX(TreeNode<Integer> root, int x){
		if(root == null){
            return false;
        }
        boolean ans = false;
       
        if(root.data == x){
            ans = true;
        }
        
        for(int i =0; i<root.children.size(); i++){
            checkIfContainsX(root.children.get(i), x);
        }
		return ans;
	}

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
        if(root == null){
            return root;
        }
        int largestSum = 0;
        TreeNode<Integer> ans = null;

        for(int i=0; i<root.children.size(); i++){
            maxSumNode(root.children.get(i));
        }

        int treesum = root.data;
        for(int i=0; i<root.children.size(); i++){
            treesum += root.children.get(i).data;
        }

        if(treesum > largestSum){
            largestSum = treesum;
            ans = root;
        }
        return ans;

    }

    static boolean identical = true;
	public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){
		
       
        if(root1.children.size() != root2.children.size()){
            return identical = false;
        }    
        
        for(int i =0; i<root1.children.size(); i++){
        		checkIdentical(root1.children.get(i), root2.children.get(i));
        }
           
        return identical;
		
	}

    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
		if(root == null){
            return null;
        }
        
        TreeNode<Integer> nextLargerNode = null;
		if(root.data > n){
 			nextLargerNode = root;
 		}
		
 		for(TreeNode<Integer> child : root.children){
			TreeNode<Integer> nextLargerInChild = findNextLargerNode(child, n);
 			if(nextLargerInChild != null ){
 				if(nextLargerNode == null || nextLargerNode.data > nextLargerInChild.data){
			 		nextLargerNode = nextLargerInChild;
 				}
 			}
 		}
 		return nextLargerNode;
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

    public static void main(String[] args) {
        // Scanner s = new Scanner(System.in);
        // TreeNode<Integer> root = takeInput(s);
        TreeNode<Integer> root = takeInputLevelwise();
        System.out.println(numNodeGreater(root, 2));
        // printLevelWise(root);
        // int count = numNodes(root);
        // int sum = sumOfAllNode(root);
        // System.out.println();
        // System.out.println("Total number of node is : "+ count);
        // System.out.println("Sum of all Nodes: "+ sum);
        // // System.out.println("Largest Node in tree : "+largest(root));
        // // printAtK(root, 1);
        // int countLeaf = countLeafOfNodes(root);
        // System.out.println("Number of leaf :"+countLeaf);

        // preOrder(root);
        // System.out.println();
        // postOrder(root);
        // System.out.println();
        // boolean checkX = checkIfContainsX(root, 40);
        // System.out.println(checkX);

        // TreeNode<Integer> largestNodeSum = maxSumNode(root);
        // System.out.println("Maximum sum node is :" + largestNodeSum.data); 
        // TreeNode<Integer> root1 = takeInputLevelwise();
        // boolean identicaltree = checkIdentical(root, root1);
        // System.out.println(identicaltree); 
        // TreeNode<Integer> nextLargerNode = findNextLargerNode(root, 18);
        // System.out.println(nextLargerNode.data);
        // TreeNode<Integer> root = new TreeNo1 2de<Integer>(4);
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
