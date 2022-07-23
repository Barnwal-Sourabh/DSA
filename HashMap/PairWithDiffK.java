package HashMap;

import java.io.*;
import java.util.*;

public class PairWithDiffK {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());
        System.out.println(PairWithDiffK.getPairsWithDifferenceK(arr, k));
    }

    public static int getPairsWithDifferenceK(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        if (k == 0) {
            for (int i = 0; i < arr.length; i++) {
                int freq = map.get(arr[i]);
                if (freq > 1) {
                    for (int j = 0; j < (freq * (freq - 1)) / 2; j++) {
                        count++;
                    }
                }
                map.put(arr[i], 0);
            }
        } else {

            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];
                if (map.containsKey(num - k) && (map.get(num - k) > 0)) {
                    count += map.get(num) * map.get(num - k);
                }
                if (map.containsKey(num + k) && (map.get(num + k) > 0)) {
                    count += map.get(num) * map.get(num + k);
                }
                map.put(num, 0);
            }
        }
        return count;
    }

}