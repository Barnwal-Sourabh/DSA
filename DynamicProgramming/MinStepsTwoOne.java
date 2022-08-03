package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinStepsTwoOne {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine().trim());
        System.out.println(MinStepsTwoOne.countM(n));
        System.out.println(MinStepsTwoOne.countStepsDP(n));
        System.out.println(MinStepsTwoOne.countMinStepsToOne(n));
    }

    public static int countMinStepsToOne(int n) {
        if (n == 1) {
            return 0;
        }

        int subtractOne = Integer.MAX_VALUE;
        int divideByTwo = Integer.MAX_VALUE;
        int divideByThree = Integer.MAX_VALUE;

        subtractOne = countMinStepsToOne(n - 1);
        if (n % 3 == 0) {
            divideByThree = countMinStepsToOne(n / 3);
        }
        if (n % 2 == 0) {
            divideByThree = countMinStepsToOne(n / 2);
        }
        return 1 + Math.min(subtractOne, Math.min(divideByThree, divideByTwo));
    }

    //Memoization technique
    public static int countM(int n) {
        int storage[] = new int[n + 1];
        return countM(n, storage);
    }

    private static int countM(int n, int[] storage) {
        if (n == 1) {
            storage[n] = 0;
            return storage[n];
        }

        if (storage[n] != 0) {
            return storage[n];
        }

        int opt1 = countM(n - 1, storage);
        int minStep = opt1;
        if (n % 3 == 0) {
            int opt2 = countM(n / 3, storage);
            minStep = Math.min(opt2, minStep);
        }
        if (n % 2 == 0) {
            int opt3 = countM(n / 2, storage);
            minStep = Math.min(opt3, minStep);
        }

        storage[n] = 1 + minStep;
        return storage[n];
    }

    //DP technique
    public static int countStepsDP(int n){
        int storage[] = new int[n+1];
        storage[1] = 0;

        for(int i =2; i<=n; i++){
            int max = storage[i-1];
            if(i % 3 == 0){
                if(max > storage[i/3]){
                    max = storage[i/3];
                }
            }
            if(i % 2 == 0){
                if(max > storage[i/2]){
                    max = storage[i/2];
                }
            }
            storage[i] = 1 + max;
        }
        return storage[n];
    }

}
