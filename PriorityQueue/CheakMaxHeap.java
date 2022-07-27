package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CheakMaxHeap {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int input[] = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(CheakMaxHeap.checkMaxHeap(input));
	}
    public static boolean checkMaxHeap(int arr[]) {
        boolean ans = true;
        for(int i =0; 2 * i + 1 < arr.length; i++){
        	int left = 2 * i + 1; 
        	int right = 2 * i + 2;
            if(arr[i] < arr[left]){
                ans = false;
            }
            if(right < arr.length && arr[i] < arr[right]){
                ans = false;
            }
        }
        
        return ans;
    }
}

