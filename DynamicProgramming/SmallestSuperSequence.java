package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestSuperSequence {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException  {
		String str1 = br.readLine();
		String str2 = br.readLine();
		int min_len = SmallestSuperSequence.smallestSuperSequence(str1, str2);
		System.out.print(min_len);
	}
    public static int smallestSuperSequence(String s, String t) {
		int m = s.length();
        int n = t.length();
        int dp[][] = new int[m+1][n+1];
        for(int i =0; i<=m; i++){
            for(int j =0; j<=n; j++){
                if(i == 0){
                    dp[i][j] = j;
                }else if(j == 0){
                    dp[i][j] = i;
                }else if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = 1 + Math.min(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}