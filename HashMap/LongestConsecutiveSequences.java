package HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LongestConsecutiveSequences {

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

    public static void printArray(ArrayList<Integer> arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        int[] arr = takeInput();
        ArrayList<Integer> ans = LongestConsecutiveSequences.longestConsecutiveIncreasingSequence(arr);
        printArray(ans);

    }

    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        int maxLength = 0;
        int start = 0;
        HashMap<Integer, Boolean> map = new HashMap<>();
        ArrayList<Integer> output = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            map.put(key, true);
        }

        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i])) {
                int length = 0;
                int temp = arr[i];
                while (map.containsKey(temp)) {
                    length++;
                    map.put(temp, false);
                    temp += 1;
                }
                int startCurr = arr[i];
                temp = arr[i] - 1;
                while (map.containsKey(temp)) {
                    length++;
                    map.put(temp, false);
                    startCurr = temp;
                    temp = temp - 1;
                }

                if (length > maxLength) {
                    maxLength = length;
                    start = startCurr;
                } else if (length == maxLength) {
                    maxLength = length;
                    for (int j = 0; j < arr.length; j++) {
                        if (arr[j] == start) {
                            break;
                        }
                        if (arr[j] == startCurr) {
                            start = startCurr;
                            break;
                        }
                    }
                }
            }
        }

        output.add(start);
        output.add(start + maxLength - 1);

        return output;
    }
}
