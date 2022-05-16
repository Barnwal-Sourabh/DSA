package BinarySearchTree1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.*;

public class PairSumBinaryTree {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<BinaryTreeNode<Integer>>();
        int start = 0;

        String[] nodeDatas = br.readLine().trim().split(" ");

        if (nodeDatas.length == 1) {
            return null;
        }

        int rootData = Integer.parseInt(nodeDatas[start]);
        start += 1;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.poll();
            } catch (Exception e) {
                return null;
            }

            int leftChildData = Integer.parseInt(nodeDatas[start]);
            start += 1;

            if (leftChildData != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
                currentNode.left = leftChild;
                pendingNodes.add(leftChild);
            }

            int rightChildData = Integer.parseInt(nodeDatas[start]);
            start += 1;

            if (rightChildData != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
                currentNode.right = rightChild;
                pendingNodes.add(rightChild);
            }
        }

        return root;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BinaryTreeNode<Integer> root = takeInput();
        int sum = Integer.parseInt(br.readLine().trim());

        PairSumBinaryTree.pairSum(root, sum);

    }

    public static void pairSum(BinaryTreeNode<Integer> root, int sum) {
        if (root == null) {
            return;
        }
        int[] arr = arrayInsertion(root);
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] == sum) {
                System.out.println(arr[i] + " " + arr[j]);
                i++;
                j--;
            } else if (arr[i] + arr[j] < sum)
                i++;
            else
                j--;
        }
    }

    private static int[] arrayInsertion(BinaryTreeNode<Integer> root) {
        if (root == null) {
            int[] arr = new int[0];
            return arr;
        }
        int firstData = root.data;
        int[] jrr = arrayInsertion(root.left);
        int[] krr = arrayInsertion(root.right);
        int[] finalArray = new int[1 + jrr.length + krr.length];
        int k = 0;
        finalArray[k] = firstData;
        k++;
        for (int i = 0; i < jrr.length; i++) {
            finalArray[k] = jrr[i];
            k++;
        }
        for (int i = 0; i < krr.length; i++) {
            finalArray[k] = krr[i];
            k++;
        }
        return finalArray;
    }
}
