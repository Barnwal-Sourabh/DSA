package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumCountSquare {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine().trim());
        System.out.println(MinimumCountSquare.minCountDP(n));
    }
    //Recursion Method
    public static int minCount(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= Math.sqrt(n); i++) {
            int count = minCount(n - i * i);
            if (min > count) {
                min = count;
            }
        }

        return min + 1;
    }
    //Memoization
    public static int minCountM(int n){
        int storage[] = new int[n+1];
        return minCount(n,storage);
    }
    public static int minCount(int n, int storage[]){
        if (n == 1 || n == 0) {
            storage[n] = n;
            return storage[n];
        }
        if(storage[n] != 0){
            return storage[n];
        }
        int min = Integer.MAX_VALUE;
        for(int i =1; i<=Math.sqrt(n); i++){
            int count = minCount(n - i * i, storage);
            if (min > count) {
                min = count;
            }
        }

        storage[n] = min + 1;
        return storage[n];
        
    }

    //Dynamic Programming
    public static int minCountDP(int n){
        int storage[] = new int[n+1];
        storage[0] = 0;
        storage[1] = 1;
        
        for(int i = 2; i <= n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <=Math.sqrt(i); j++){
                int count = storage[i - (j*j)];
                if(min > count){
                    min = count;
                }
            }
            storage[i] = min + 1;
        }
        return storage[n];
    }


}
