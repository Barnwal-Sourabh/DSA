package Tree;

import java.util.Scanner;

public class TakeInputRecursively {

    public static TreeNode<Integer> takeInput(){
        int n;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter next Node data:");
        n = s.nextInt();
        TreeNode<Integer> root = new TreeNode<Integer>(n);
        int chilCount = s.nextInt();

        for(int i = 0; i<chilCount; i++){
            TreeNode<Integer> child = takeInput();
            root.children.add(child);
        }
        s.close();;
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

    public static void main(String[] args) {
        TreeNode<Integer> root = takeInput();
        print(root);
    }
    
}
