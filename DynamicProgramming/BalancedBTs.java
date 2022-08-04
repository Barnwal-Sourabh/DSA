package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BalancedBTs {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws NumberFormatException, IOException {


        int n = Integer.parseInt(br.readLine().trim());
        System.out.print(BalancedBTs.balancedBTs(n));
    }

    public static int balancedBTs(int height){
        //recursive solution
        
        // if(height == 0 || height == 1) {
		// 	return 1;
		// }
		// // long mod = (long)Math.pow(10, 9) + 7;
		// long x = balancedBTs(height-1);
		// long y = balancedBTs(height-2);
		
		// long x_2 = (x*x);//%mod;
		// long x_y = (x*y);//%mod;
		// long x_y_2 = (2*x_y) ;//% mod ;
		// return (x_2+x_y_2) ;//% mod;

        //Dynamic solution

        int mod = (int)Math.pow(10,9) + 7;
        int storage[] = new int[height+1];
        storage[0] = 1;
        storage[1] = 1;
        for(int i = 2; i<=height; i++){
            long x =(long) storage[i-1];
			long y = (long)storage[i-2];
			
			long x_2 =(x*x)% mod;
			long x_y_2 = (2*x*y)% mod;
			storage[i] = (int)(x_2+x_y_2)%mod;
        }
        
        return storage[height];
    }
}