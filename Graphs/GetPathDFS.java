package Graphs;

import java.util.*;
import java.io.*;

public class GetPathDFS {
    public static ArrayList<Integer> getPathDFS(int edges[][], int sv, int ev, boolean visted[]) {
        if (sv == ev) {
            ArrayList<Integer> ans = new ArrayList<>();
            visted[ev] = true;
            ans.add(ev);
            return ans;
        }
        visted[sv] = true;
        for (int i = 0; i < edges.length; i++) {
            if (edges[sv][i] == 1 && !visted[i]) {
                ArrayList<Integer> arr = getPathDFS(edges, i, ev, visted);
                if (arr != null) {
                    arr.add(sv);
                    return arr;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        int edges[][] = new int[v][v];
        for (int i = 0; i < e; i++) {
            int fv = sc.nextInt();
            int sv = sc.nextInt();
            edges[fv][sv] = 1;
            edges[sv][fv] = 1;
        }
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        boolean visited[] = new boolean[v];
        ArrayList<Integer> ans = getPathDFS(edges, v1, v2, visited);
        if (ans != null) {
            for (int i : ans) {
                System.out.print(i + " ");
            }
        }
        sc.close();

    }
}
