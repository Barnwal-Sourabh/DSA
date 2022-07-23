package HashMap;

import java.util.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestSubsetZeroSum {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(LongestSubsetZeroSum.lengthOfLongestSubsetWithZeroSum(arr));
	}

    
    
    public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int temp = 0;
        int length = 0;
        for(int i = 0; i<arr.length; i++){
            temp = temp + arr[i];
            if(!map.containsKey(temp)){
                map.put(temp, i);
            }else {
                int k = map.get(temp);
                int l = i-k;
                length = l;
            }
            
            if(temp == 0){
                length=i+1;
            }
            
            max = Math.max(length, max);
            
        }
        return max;        
	}
}
