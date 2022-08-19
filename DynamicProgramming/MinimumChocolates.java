package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumChocolates {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[] takeInput() throws IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            return input;
        }

        String[] strNums;
        strNums = br.readLine().split("\\s");

        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        return input;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        int[] arr = takeInput();
        System.out.print(MinimumChocolates.getMin(arr, arr.length));

    }

    public static int getMin(int arr[], int N) {
        if (N == 0) {
            return 0;
        }

        int dp[] = new int[N];
        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            if (arr[i] > arr[i - 1]) {
                dp[i] = 1 + dp[i - 1];
            } else {
                dp[i] = 1;
            }
        }

        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1] && dp[i] <= dp[i + 1]) {
                dp[i] = 1 + dp[i + 1];
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += dp[i];
        }

        return ans;
    }
}
