package PriorityQueue;

import java.util.*;

public class KLargestElement {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n = s.nextInt();
		int input[] = new int[n];
		for(int j = 0; j < n; j++) {
			input[j] = s.nextInt();
		}
		int k = s.nextInt();
		ArrayList<Integer> output = KLargestElement.kLargest(input, k);
		for(int i : output) {
			System.out.println(i);
		}
		
	}

    public static ArrayList<Integer> kLargest(int arr[], int k) {
		ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0; i<k; i++){
            pq.add(arr[i]);
        }
        
        for(int i= k; i<arr.length; i++){
            if(pq.peek() < arr[i]){
                pq.remove();
                pq.add(arr[i]);
            }
        }
		
        while(!pq.isEmpty()){
            ans.add(pq.remove());
        }
        
        return ans;
	}
}