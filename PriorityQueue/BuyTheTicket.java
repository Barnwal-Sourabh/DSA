package PriorityQueue;

import java.io.*;
import java.util.*;

class Pair{
    int value;
    int index;
}

public class BuyTheTicket {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int input[] = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(BuyTheTicket.buyTicket(input, k));
    }

    public static int buyTicket(int input[], int k) {
        /*
         * Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < input.length; i++) {
            Pair pair = new Pair();
            pair.value = input[i];
            pair.index = i;
            priorityQueue.add(input[i]);
            queue.add(pair);
        }
        int count = 0;
        while (!queue.isEmpty()) {

            if (priorityQueue.peek() == queue.peek().value) {
                priorityQueue.remove();
                Pair pair = queue.poll();
                count++;
                if (pair.index == k) {
                    return count;
                }
            } else {

                queue.add(queue.poll());

            }

        }

        return count;
    }
}
