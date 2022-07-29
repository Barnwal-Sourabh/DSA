package PriorityQueue;

import java.util.*;
import java.io.*;

public class RunningMedian {

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

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        int[] arr = takeInput();
        RunningMedian.findMedian(arr);

    }

    public static void findMedian(int arr[]) {

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for (int e : arr) {
            if (max.isEmpty()) {
                max.add(e);
            } else if (e > max.peek()) {
                min.add(e);
                if (min.size() - max.size() > 1) {
                    int p = min.remove();
                    max.add(p);
                }
            } else {
                max.add(e);
                if (max.size() - min.size() > 1) {
                    int p = max.remove();
                    min.add(p);
                }
            }
            if (max.size() > min.size()) {
                System.out.print(max.peek() + " ");
            } else if (min.size() > max.size()) {
                System.out.print(min.peek() + " ");
            } else {
                System.out.print((max.peek() + min.peek()) / 2 + " ");
            }

        }
    }
}