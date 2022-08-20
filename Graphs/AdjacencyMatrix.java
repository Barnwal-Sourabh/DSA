package Graphs;

import java.util.Scanner;

class AdjacencyMatrix {
    public static void printHelper(int edges[][], int sv, boolean visted[]) {
        System.out.println(sv);
        visted[sv] = true;
        int n = edges.length;
        for (int i = 0; i < n; i++) {
            if (edges[sv][i] == 1 && !visted[i]) {
                printHelper(edges, i, visted);
            }
        }
    }

    public static void print(int edges[][]) {
        boolean visted[] = new boolean[edges.length];

        for (int i = 0; i < edges.length; i++) {
            if (!visted[i]) {
                printHelper(edges, i, visted);
            }
        }
    }

    public static void main(String[] args) {
        int n, e;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        e = sc.nextInt();
        int edges[][] = new int[n][n];

        for (int i = 0; i < e; i++) {
            int fv = sc.nextInt();
            int sv = sc.nextInt();
            edges[fv][sv] = 1;
            edges[sv][fv] = 1;
        }
        print(edges);
        sc.close();
    }

}