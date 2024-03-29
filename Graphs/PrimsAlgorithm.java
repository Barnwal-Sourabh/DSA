package Graphs;

import java.util.*;;

public class PrimsAlgorithm {
    private static void prims(int[][] adjacencyMatrix) {
        int v = adjacencyMatrix.length;
        boolean visted[] = new boolean[v];
        int weight[] = new int[v];
        int parent[] = new int[v];
        weight[0] = 0;
        parent[0] = -1;
        for(int i = 0; i<v; i++){
            weight[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < v; i++) {
            int minVertex = findMinVertex(weight, visted);
            visted[minVertex] = true;

            for (int j = 0; j < v; j++) {
                if (adjacencyMatrix[minVertex][j] != 0 && !visted[j]) {
                    if (adjacencyMatrix[minVertex][j] < weight[j]) {
                        weight[j] = adjacencyMatrix[minVertex][j];
                        parent[j] = minVertex;
                    }
                }
            }
        }

        for (int i = 1; i < v; i++) {
            if (parent[i] < i) {
                System.out.println(parent[i] + " " + i + " " + weight[i]);
            } else {
                System.out.println(i + " " + parent[i] + " " + weight[i]);
            }
        }

    }

    private static int findMinVertex(int[] weight, boolean[] visted) {
        int minVertex = -1;

        for (int i = 0; i < weight.length; i++) {
            if (!visted[i] && (minVertex == -1 || weight[i] < weight[minVertex]))
                minVertex = i;
        }
        return minVertex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        int adjacencyMatrix[][] = new int[v][v];

        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();
            adjacencyMatrix[v1][v2] = weight;
            adjacencyMatrix[v2][v1] = weight;
        }

        prims(adjacencyMatrix);
        sc.close();
    }

}
