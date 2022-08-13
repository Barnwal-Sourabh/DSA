package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Input {
	private int n;
	private int[] weights;
	private int[] values;
	private int maxWeight;

	public Input(int[] weights, int[] values, int n, int maxWeight) {
		this.n = n;
		this.weights = weights;
		this.values = values;
		this.maxWeight = maxWeight;
	}

	public int getSize() {
		return this.n;
	}

	public int[] getWeights() {
		return this.weights;
	}

	public int[] getValues() {
		return this.values;
	}

	public int getMaxWeight() {
		return this.maxWeight;
	}
}

public class Knapsack {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Input takeInput() throws NumberFormatException, IOException {
		
		int n = Integer.parseInt(br.readLine().trim());

		if (n == 0) {
			return (new Input(new int[0], new int[0], 0, 0));
		}

		String[] strWeights = br.readLine().trim().split(" ");
		String[] strValues = br.readLine().trim().split(" ");
		int maxWeight = Integer.parseInt(br.readLine().trim());

		int[] weights = new int[n];
		int[] values = new int[n];

		for (int i = 0; i < n; i++) {
			weights[i] = Integer.parseInt(strWeights[i]);
			values[i] = Integer.parseInt(strValues[i]);
		}

		return (new Input(weights, values, n, maxWeight));

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        Input input = takeInput();

        int n = input.getSize();
        int[] weights = input.getWeights();
        int[] values = input.getValues();
        int maxWeight = input.getMaxWeight();

        
        System.out.println(Knapsack.knapsackDP(weights, values, n, maxWeight));
    }
    public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
		return knapsack(0, weights, values,maxWeight);
	}
    public static int knapsack(int i, int[] weights, int[] values, int maxWeight){
        if(weights.length == i || maxWeight == 0){
            return 0;
        }
        
        if(weights[i] > maxWeight){
            return knapsack(i+1, weights, values, maxWeight);
        }else {
            int op1 = values[i] + knapsack(i+1, weights, values, maxWeight - weights[i]);
            int op2 = knapsack(i+1, weights, values, maxWeight);
            return Math.max(op1, op2);
        }
        
    }

	//Dynamic programming approch
	static int knapsackDP(int[] weight, int[] value, int n, int maxWeight) {

		int dp[][] = new int[2][maxWeight+1];
	  
	  for(int i=0; i<n; i++){
		  for(int j =1; j<=maxWeight; j++){
			  if(weight[i] <=j){
				  dp[i%2][j] = Math.max(value[i] + dp[(1+i) %2][j - weight[i]] , dp[(i+1) % 2][j]);
			  }else {
				  dp[i%2][j] = dp[(i+1) % 2][j];
			  }
		  }
	  }
	  return dp[(n+1) % 2][maxWeight];
  }
}
    

