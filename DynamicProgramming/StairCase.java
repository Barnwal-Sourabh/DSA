package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StairCase {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println(StairCase.staircase(n));
    }
    public static long staircase(int n) {
        if(n == 0 || n == 1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        long storage[] = new long[n+1];
        storage[0] = 1;
        storage[1] = 1;
        storage[2] = 2;
        
        for(int i = 3; i<=n; i++){
            storage[i] = storage[i-1] + storage[i-2] + storage[i-3];
        }
        
        return storage[n];
	}

}

