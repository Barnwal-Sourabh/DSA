package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinTower {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
            String[] strNums = br.readLine().trim().split("\\s");
            int n = Integer.parseInt(strNums[0]);
            int x = Integer.parseInt(strNums[1]);
            int y = Integer.parseInt(strNums[2]);

            System.out.println(CoinTower.findWinner(n, x, y));
    }
    public static String findWinner(int n, int x, int y) {
		
        int dp[]= new int[n+1];
        dp[1] = 1;
        
        int opt1 = 0;
        int opt2 = 0;        
        int opt3 = 0;
        
        for(int i =2; i< dp.length; i++){
            if(i == x || i == y){
                dp[i] = 1;
                continue;
            }
            
            if(i - x >= 1){
                opt1 = dp[i-x] ^ 1;
            }
            if(i - y >= 1){
                opt2 = dp[i-y] ^ 1;
            }
            
            opt3 = dp[i - 1] ^ 1;
            dp[i] = Math.max(opt3, Math.max(opt1, opt2));
            
        }
        
        if(dp[n] != 0){
            return "Beerus";
        }else {
            return "Whis";
        }
	}

}