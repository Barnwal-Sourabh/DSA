package Graphs;

import java.util.*;
import java.io.*;

public class GetPathBFS {
    public static ArrayList<Integer> getPathBFS(int edges[][], int sv, int ev, boolean visted[]) {
        if (sv == ev) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(ev);
            visted[ev] = true;
            return ans;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        q.add(sv);
        visted[sv] = true;

        while (!q.isEmpty()) {
            int cv = q.remove();
            for (int i = 0; i < edges.length; i++) {
                if (edges[cv][i] == 1 && !visted[i]) {
                    q.add(i);
                    visted[i] = true;
                    map.put(i, cv);
                    if (i == ev) {
                        ans.add(i);
                        while (!ans.contains(sv)) {
                            int b = map.get(i);
                            ans.add(b);
                            i = b;
                        }
                        return ans;
                    }
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
        ArrayList<Integer> ans = getPathBFS(edges, v1, v2, visited);
        if (ans != null) {
            for (int i : ans) {
                System.out.print(i + " ");
            }
        }
        sc.close();

    }
}
