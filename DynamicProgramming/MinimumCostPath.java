package DynamicProgramming;

public class MinimumCostPath {
    
    //Recursive solution
    public static int minCostPath(int arr[][]){
        return minCostPath(arr, 0, 0);
    }
    
    private static int minCostPath(int arr[][], int i, int j){
        int m = arr.length;
        int n = arr[0].length;
        
        //Base Case
        if(i == m-1 && j == n-1){
            return arr[i][j];
        }    
        //edge case
        if(i >= m || j >= n){
            return Integer.MAX_VALUE;
        }

        int opt1 = minCostPath(arr, i+1, j);
        int opt2 = minCostPath(arr, i+1, j+1);
        int opt3 = minCostPath(arr, i, j+1);

        return arr[i][j] + Math.min(opt1, Math.min(opt2, opt3));
    }
    public static void main(String[] args) {
        int arr[][] = {{1,1,1}, {4,5,2}, {7,8,9}};
        System.out.println(minCostPath(arr));
    }
}
