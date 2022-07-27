package PriorityQueue;

import java.util.PriorityQueue;

public class InbuiltPriorityQueue{

    public static void sortKSorted(int arr[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0; 
        for(; i < k; i++){
            pq.add(arr[i]);
        }

        for(; i < arr.length; i++){
            arr[i - k] = pq.remove();
            pq.add(arr[i]);
        }

        for(int j = arr.length - k; j < arr.length; j++){
            arr[j] = pq.remove();
        }
    }
    public static void main(String[] args) {
        int arr[] =  {2,4,1,9,6,8};
        sortKSorted(arr, 3);
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }    
}