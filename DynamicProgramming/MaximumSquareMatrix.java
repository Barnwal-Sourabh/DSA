package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumSquareMatrix {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[][] takeInput() throws IOException {

        String[] nm;
        nm = br.readLine().split("\\s");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int arr[][] = new int[n][m];

        if (n == 0) {
            return arr;
        }

        String[] strNums;
        for (int i = 0; i < n; ++i) {
            strNums = br.readLine().split("\\s");
            for (int j = 0; j < m; ++j) {
                arr[i][j] = Integer.parseInt(strNums[j]);
            }

        }

        return arr;
    }

    public static void main(String[] args) throws IOException {

        int[][] arr = takeInput();
        System.out.println(MaximumSquareMatrix.findMaxSquareWithAllZeros(arr));
    }

    public static int findMaxSquareWithAllZeros(int[][] input) {
        if (input.length == 0) {
            return 0;
        }
        int m = input.length;
        int n = input[0].length;
        int output = 0;

        int storage[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (input[0][i] == 0) {
                storage[0][i] = 1;
                output = 1;
            } else {
                storage[0][i] = 0;
            }

        }
        for (int j = 0; j < m; j++) {
            if (input[j][0] == 0) {
                storage[j][0] = 1;
                output = 1;
            } else {
                storage[j][0] = 0;
            }

        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (input[i][j] == 1) {
                    storage[i][j] = 0;
                } else {
                    int min = Math.min(storage[i - 1][j - 1], Math.min(storage[i - 1][j], storage[i][j - 1]));
                    storage[i][j] = min + 1;
                    if (output < storage[i][j]) {
                        output = storage[i][j];
                    }
                }
            }
        }
        return output;
    }
}