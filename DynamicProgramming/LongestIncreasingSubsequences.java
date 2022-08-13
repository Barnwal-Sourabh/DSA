package DynamicProgramming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class LongestIncreasingSubsequences {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[] takeInput() throws IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            return input;
        }
        
		String[] strNums;
		strNums = br.readLine().split("\\s");
		
        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        return input;
    }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        int[] arr = takeInput();
        System.out.println(LongestIncreasingSubsequences.lis(arr));



    }
    public static int lis(int arr[]) {
        int storage[] = new int[arr.length];
		storage[0] = 1;
		int ans = 1;
        for(int i=1; i<storage.length; i++){
            int maxCount = 1;
            for(int j =i-1; j>=0; j--){
            	if(arr[j] < arr[i]){
					int temp = storage[j] + 1;
                    if(temp > maxCount){
                        maxCount = temp;
                    }
                }    
            }
            storage[i] = maxCount;
            if(maxCount > ans){
                ans = maxCount;
            }
        }
        return ans;
    }
}
