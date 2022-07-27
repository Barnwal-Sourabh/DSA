package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

        public class KSmallestElement {
    
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        static StringTokenizer st;
    
        public static void main(String[] args) throws NumberFormatException, IOException {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int input[] = new int[n];
            for(int i = 0; i < n; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }
            int k = Integer.parseInt(br.readLine());
            ArrayList<Integer> output = KSmallestElement.kSmallest(n, input, k);
            Collections.sort(output);
            for (int i : output) {
                System.out.print(i + " ");
            }
        }

        public static ArrayList<Integer> kSmallest(int n, int[] arr, int k) {
            ArrayList<Integer> ans = new ArrayList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i =0; i<k; i++){
                pq.add(arr[i]);
            }
            
            for(int i= k; i<arr.length; i++){
                if(arr[i] < pq.peek()){
                    pq.poll();
                    pq.add(arr[i]);
                }
            }
            
            while(!pq.isEmpty()){
                ans.add(pq.poll());
            }
            
            return ans;
    
        }
    
    }