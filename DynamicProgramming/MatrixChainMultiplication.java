package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class MatrixChainMultiplication {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[] takeInput() throws IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size + 1];

        if (size == 0) {
            return input;
        }
        
		String[] strNums;
		strNums = br.readLine().split("\\s");
		
        for (int i = 0; i < size + 1; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        return input;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {


        int[] arr = takeInput();
        System.out.print(MatrixChainMultiplication.mcm(arr));


    }
    public static int mcm(int[] p){
		int  n = p.length;
        int[][] storage = new int[p.length][p.length];
        for(int i =n-1;i>=0;i--) {
            for(int j=0;j<n;j++) {
                if( i +1 < j ) {
                    int min = Integer.MAX_VALUE;
                    for(int k=i+1;k<j;k++) {
                        int c = storage[i][k] + storage[k][j] + p[i] * p[k] * p[j] ;
                        if(c < min) {
                            min = c;
                        }
                    }
                    storage[i][j] = min ;
                }
            }
        }
        return storage[0][n-1];
	
	}
}