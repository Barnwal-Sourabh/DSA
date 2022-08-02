package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinStepsTwoOne {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine().trim());
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

}
