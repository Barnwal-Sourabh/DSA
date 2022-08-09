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

    //Memoization
    public static int minCostPathM(int arr[][]){
        int m = arr.length;
        int n = arr[0].length;
        int storage[][] = new int[m][n];
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                storage[i][j] = -1;
            }
        }

        return minCostPathM(arr, 0, 0, storage);

    }
    private static int minCostPathM(int[][] arr, int i, int j, int[][] storage) {
        int m = arr.length;
        int n = arr[0].length;
        
        //edge case
        if(i >= m || j >= n){
            return Integer.MAX_VALUE;
        }
        //Base Case
        if(i == m-1 && j == n-1){
            storage[m-1][n-1] = arr[i][j];
            return storage[i][j];
        }
        
        if(storage[i][j] != -1){
            return storage[i][j];
        }

        int opt1 = minCostPathM(arr, i+1, j, storage);
        int opt2 = minCostPathM(arr, i+1, j+1, storage);
        int opt3 = minCostPathM(arr, i, j+1, storage);


        storage[i][j] = arr[i][j] + Math.min(opt1, Math.min(opt2, opt3));
        return storage[i][j];
    }

    public static void main(String[] args) {
        int arr[][] = {{1,1,1}, {4,5,2}, {7,8,9}};
        System.out.println(minCostPath(arr));
        System.out.println(minCostPathM(arr));
    }
}
